<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
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
<frameset rows="100,*" frameborder="no" border="0" framespacing="0">
   <frame src="header.jsp" name="top" scrolling="no" noresize="noresize">
    <frameset cols="1000,*" frameborder="no" border="0" framespacing="0">
     <frame src="chat.jsp" name="left" scrolling="no" noresize="noresize">
      <frame src="friendlist.jsp" name="right" scrolling="no" noresize="noresize">
    </frameset>
</frameset>
</html>