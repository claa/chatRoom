package nuc.test.Dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class ChatMessage {
      private int type;//聊天类型，1为单聊，2为群聊
      private String from; //发送者
      private List<String> to;//接收者
      private String content;//聊天信息
      private String info;//进入和退出聊天室的提示消息
      private List<String> usernames;//列表的用户名
      private List<String> SessionUsername;//websocket session名字
      private static Gson gson=new Gson();//google开发的框架，使java变为json;
      private int count;
        
        public int getCount() {
		return count;
	    }
	    public void setCount(int count) {
		this.count = count;
	    }
		public ChatMessage() {
        	
        }
        public ChatMessage(String info,List<String> usernames,int count) {
        	this.info=info;
        	this.usernames=usernames;
        	this.count=count;
        }
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public List<String> getTo() {
			return to;
		}
		public void setTo(List<String> to) {
			this.to = to;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String time=sdf.format(new Date());
			this.content = "\r\n"+time+"\r\n"+from+"  said :"+content;
		}
		
		 public String getChartMessageToJson(){  
		        return gson.toJson(this);  
		 }
		 
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
		public List<String> getUsernames() {
			return usernames;
		}
		public void setUsernames(List<String> usernames) {
			this.usernames = usernames;
		}
		public List<String> getSessionUsername() {
			return SessionUsername;
		}
		public void setSessionUsername(List<String> sessionUsername) {
			SessionUsername = sessionUsername;
		}     
}
