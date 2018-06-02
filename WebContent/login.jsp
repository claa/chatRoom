<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{text-align:center;}
#box{border:1px solid black;width:400px;padding:20px 40px;margin:200px auto; background:#D8D8D8;line-height:30px;}
a{text-decoration:none;}
#pass{background:url(images/eye.png) no-repeat 130px,2px;background-color:white;}
</style>
</head>
<body>
<h1><font style="color:red;size:25px;">在线聊天室</font></h1>
<div id="box">
<font color="red">${requestScope.error}</font>
<form action="loginAction" method="post" >
用户名:<input type="text" name="username"><br>
<font color="red"><s:fielderror fieldName="usrename"/></font> 
密&emsp;码:<input type="password" name="password" id="pass" ><br>
<font color="red"><s:fielderror fieldName="password"/></font> 
验证码:<input type="text" name="checking"><br>
&emsp;&emsp;&emsp;<img src="image.jsp"><a href="" target="_self">看不清，换一张</a><br>
<font color="red"><s:fielderror fieldName="checking"/></font> 
<input type="submit" value="登录" >
<input type="reset"  value="取消" >
<input type="button" value="注册" onclick="location='register.jsp'">
</form>
<!-- 放在密码行上面，会找不到属性type -->
<script type="text/javascript">
var pass=document.getElementById("pass");
pass.onmouseover = function(){
	pass.setAttribute("type","text");
}
pass.onmouseout = function(){
	pass.setAttribute("type","password");
}
</script>
</div>
</body>
</html>