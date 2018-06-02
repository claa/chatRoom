<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<sx:head/>
<style type="text/css">
#box{border:1px solid black;width:400px;padding:20px 40px;margin:200px auto; background:#D8D8D8;}
</style>
</head>
<body>
<!-- 内置校验器-->
<div id="box">
<font color="red">${requestScope.error}</font>
<s:form action="registerAction" method="post" style="margin-left:25px;"><!-- 简单主题theme="simple" -->
<s:textfield label="Email地址" name="email" cssStyle=""></s:textfield>
<s:password  label="密码" name="password"></s:password> 
<s:password label="确认密码" name="truepassword"></s:password> 
<s:textfield label="用户名" name="username"></s:textfield>
<s:textfield label="真实姓名"  name="trueusername"></s:textfield> 
<s:textfield label="手机号" name="phone"></s:textfield> 
<sx:datetimepicker label="日期" name="date" displayFormat="yyyy-MM-dd"></sx:datetimepicker>
<s:submit value="注册" ></s:submit>
<s:reset value="取消"></s:reset>
</s:form>
</div>
</body>
</html>