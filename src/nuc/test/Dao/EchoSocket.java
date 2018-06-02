package nuc.test.Dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



import net.sf.json.JSONObject;
@ServerEndpoint("/echo")  //chat.jsp页面中建立连接的名字
public class EchoSocket {
      private static List<String> usernames=new ArrayList<String>();
      private static List<Session> sessions=new ArrayList<Session>();
      private static Map<String,Session> sessionMap = new HashMap<String,Session>();
      private String username;
      private Session session;
      
      @OnOpen  
      //打开websocket
      public void open(Session session) {
    	  String strings=session.getQueryString();//接受从chat页面传过来的username
    	  this.username=strings.split("=")[1];
    	  this.usernames.add(this.username);
    	  this.sessions.add(session);
    	  sessionMap.put(this.username, session);
    	  String welcome="欢迎"+this.username+"加入聊天室";
    	  ChatMessage message=new ChatMessage(welcome,this.usernames,this.sessions.size());
    	  this.broadcast(this.sessions,message.getChartMessageToJson());  
      }
      
      @OnClose 
      //关闭websocket
      public void close(Session session) {
    	  this.sessions.remove(session);
    	  this.usernames.remove(this.username);
    	  String goMsg=this.username+"已经离开聊天室";
    	  ChatMessage message=new ChatMessage(goMsg,this.usernames,this.sessions.size());
    	  sessionMap.remove(this.username);
    	  this.broadcast(this.sessions,message.getChartMessageToJson());
    	  System.out.println("websocket is close");
      }
      
      @OnMessage
      //传送信息
      public void message(Session session,String msg) {
    	  if(session.isOpen()) {
    		  JSONObject msgjsonobj=JSONObject.fromObject(msg);
    		  ChatMessage chat=(ChatMessage)JSONObject.toBean(msgjsonobj, ChatMessage.class);
    		  chat.setUsernames(this.usernames);
    		  if(chat.getType()==1) {//实现单聊
    			  List<Session> privatelist=new ArrayList<Session>();
    			  for(int i = 0 ; i < chat.getTo().size(); i++ ) {
    				  String userChatName =chat.getTo().get(i);
    				  privatelist.add(sessionMap.get(userChatName));
    			  }
    			  privatelist.add(sessionMap.get(chat.getFrom()));
    			  this.broadcast(privatelist,chat.getChartMessageToJson());
    		  }else if(chat.getType()==2){//实现群聊
    			  this.broadcast(this.sessions,chat.getChartMessageToJson());
    		  }
    	  }
      }
      
      public List<String> getUsernames(){
    	  return usernames;
      }
      
      public List<Session> getSessions(){
    	  return sessions;
      }
      //广播消息
      private void broadcast(List<Session> sessionlist,String msg) {
    	   if(sessionlist.size()>0) {
    		   System.out.println(msg);
    		   for(int i=0;i<sessionlist.size();i++) {
    			   try {
					sessionlist.get(i).getBasicRemote().sendText(msg);//发送给chat.jsp
				} catch (IOException e) {
					// TODO Auto-generated catch block
					 System.out.println("EchoSocket.java broadcast method ,广播失败 "); 
					e.printStackTrace();
				}
    		   }
    	   }
      }
}
