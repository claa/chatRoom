<%@ page language="java" import="java.util.*,javax.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
 <head>  
<title>聊天室</title>  
<style type="text/css">
html{
     margin:0;
     padding:0;
}
body{
     margin:0;
     padding:0;
}
</style>     
 </head>  
    
  <body>  
   <script type="text/javascript">  
      
     var ws=null;   
     var target = "ws://"+window.location.host+"/zhongbeiTao/echo?username=${sessionScope.loginname}"; // 打开管道  ,ws://localhost:8080/项目名/@ServerEndpoint名字   
    
      window.onload=function(){  
      //判断浏览器是否支持webSocket
       if(ws==null){  
          if ('WebSocket' in window) {  
                ws = new WebSocket(target);  
            } else if ('MozWebSocket' in window) {  
                ws = new MozWebSocket(target);  
            } else {  
                alert('WebSocket is not supported by this browser.');  
                return;  
           } 
           ws.onmessage = function (event) { //创建websocket同时,接收服务器发给客服端的消息  
                if(event!=null){  
                //将json字符串转为对象  
                 eval("var msg="+event.data+";");   
                 //得到对象里面的值   info等属性在package nuc.test.Dao.ChatMessage;  msg对象是从broadcast()广播方法中接收过来的在package nuc.test.Dao.EchoSocket
                 var welcome = msg.info;  
                 var content = msg.content;  
                 var usernames = msg.usernames;
                 var count = msg.count;//通过cookie接受在线人数
                 document.cookie="counts="+count;
                 //为聊天区teaxarea赋值  
                 var textArea = document.getElementById("content");  
                 if(undefined!=welcome){  
                   textArea.value = textArea.value  + "\r\n"+welcome;  
                 }  
                  if(undefined!=content){  
                   textArea.value = textArea.value  + "\r\n"+content;  
                 }  
                  
                 //为用户列表区TD赋值  显示在线用户名
                 var userListTD = document.getElementById("userList");  
                 userListTD.innerHTML="";  
                 //选择和自己想聊天的人实现单独聊天
                 for(var i = 0 ; i < usernames.length; i++){  
                    if(undefined!=usernames[i]){  
                    if("${sessionScope.loginname}" == usernames[i]){  
                      userListTD.innerHTML += "\r\n  <input name='msgCheckBox' disabled='true' type='checkbox' value='"+usernames[i]+"'> <span style='color: red'>" +  usernames[i]+"</span></br>";  
                    }else{  
                      userListTD.innerHTML += "\r\n  <input name='msgCheckBox' type='checkbox' value='"+usernames[i]+"'>" +  usernames[i]+"</br>";  
                    }  
                       
                    }       
                 }  
                   
                   
                }  
              };  
                           
         
       }         
  
     };  
      
       
     sendMessage = function(){ //发送信息  
      if(ws!=null){  
       var checkNumber = 0 ; // 被选中复选框的个数  
       var checkedUsernameArray = new Array();  // 被选中的复选框名字  
       var checkBoxs =  document.getElementsByName("msgCheckBox");  
       for(var i = 0 ; i < checkBoxs.length ; i++ ){   
          var checkbox = checkBoxs[i];  
         if(checkbox.checked == true){  
            checkNumber ++;  
            checkedUsernameArray.push(checkbox.value) ;  
         }  
      }  
    //  alert("checkedUsernameArray = " + checkedUsernameArray);  
      var type; // 单聊 type = 1 ,type =2 群聊  
      if(checkNumber > 0 ) { // 单聊 type = 1   
        type = 1;  
      }else{ //群聊  
        type = 2;   
      }  
       var sendMessageInput = document.getElementById("sendMessageTextArea");  
       var msg = sendMessageInput.value;   
       
       /*  
        1 发送对象有哪些  
        2 发送的类型  单聊/群聊  
        3 内容  
         
       */  
       var msgObj={  
         type:type,  
         from:'${sessionScope.loginname}',  
         to:checkedUsernameArray,  
         content:msg  
       };  
     //将msgOjb对象转为json  
         var json = JSON.stringify(msgObj);  
         ws.send(json);  
         sendMessageInput.value ="";  
          
       }  
       else{  
         alert("websocket is null , please create a websocket");  
       }  
     }  
   </script>  
     
    <table cellpadding="0" cellspacing="0"  border="1" width="998px" height="350px">  
      <tr>  
        <td width="500px" height="300px">  
          <textarea id="content" rows="20" cols="60" style="border:0;">  
          </textarea>  
         </td>  
        <td id="userList" width="180px" align="center">  
              <h3>在线用户列表</h3>
        </td>  
      </tr>  
</table>  
      <br>
      <textarea id="sendMessageTextArea" rows="10" cols="100">  
       </textarea>  
       <button onclick="sendMessage()">发送</button>  
       
      
  
   
     
  </body>  
</html>  