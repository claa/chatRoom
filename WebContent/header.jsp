<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
html{
     maigrn:0;
     padding:0;
}
body{
      maigrn:0;
      padding:0;
}
</style>
 
</head>
               
<body topmargin="0" leftmargin="0" rightmargin="0">

 <table  width="100%" height="98" border="0" cellpadding="0"cellspacing="0" align=center>
             <tr>
                <td bgcolor="F9A859" valign="top">
	                <table width="100%" height="50" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="FBEAD0">
		                 <tr>
			                   <td align="center" style="font-size:40px;">
			                                   网上聊天室
			                   </td>	
		                 </tr> 
	                </table>
                </td>
             </tr>
             <tr>
                 <td bgcolor="F9A859" valign="top">
	                 <table width="100%" border="0" align="center" cellpadding="0"
	                         cellspacing="0">
				                  <tr>
				                     <td align="center" style="font-size:20px" valign="middle">
				                     欢迎<%=(String)session.getAttribute("loginname") %>访问!
				                     当前在线人数为<span id="people"></span>人
				                     </td>
				                  </tr>       
				                 
	                 </table>
                 </td>
              </tr>              
             
</table>
<script type="text/javascript">
        function get_cookie() {
            var search ="counts="//查询检索的值
            var returnvalue = "";//返回值
            if (document.cookie.length > 0) {
                 sd = document.cookie.indexOf(search);
                       if (sd!= -1) {
                            sd += search.length;
                            end = document.cookie.indexOf(";", sd);
                            if (end == -1)
                            end = document.cookie.length;
                             //unescape() 函数可对通过 escape() 编码的字符串进行解码。
                              returnvalue=unescape(document.cookie.substring(sd, end))
                         }
                     } 
                   return Number(returnvalue)+1;
             }
        window.document.getElementById('people').innerHTML= get_cookie(); 
 </script>
</body>
</html>