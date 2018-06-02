<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="nuc.test.Service.*" %>
    <%@ page import="java.util.*" %>
       <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	   html{
	     maigrn:0;
	     padding:0;
	     }	
	    *
        {
            margin: 0;
            padding: 0;
        }
        body
        {
            font-size: 15px;
            padding: 0px;
        }
        .menu
        {
            width: 500px;
            border-bottom: solid 1px gray;
        }
        .menu h3
        {
            border: solid 1px gray;
            height: 30px;
            line-height: 30px;
            padding-left: 10px;
            padding:0 5px;
            border-bottom: none;
            cursor: pointer;
           
        }
        .menu p
        {
            border-left: solid 1px gray;
            border-right: solid 1px gray;
            padding: 20px 0;
            padding-left: 5px;
        }
        a{  text-decoration:none;}
        a:hover{
         color:red;
         font-size:15px;
        }
    </style>
  </head>
  
  <body>
    <div class="menu">
    <h3>用户列表</h3>
        <p>
            <%
                 userService user=new userService();
                 ResultSet rt=user.selectUsers();
                 String u=(String)session.getAttribute("loginid");
                 int idu=Integer.valueOf(u);
                 while(rt.next()){
            %>
                 <%=rt.getString("username") %>&emsp;
		            <a href="AddFriendAction?ids=<%=rt.getInt("id")%>&id=<%=idu%>">添加</a><br/>
            <%} %>
        </p>
    </div>
    <div class="menu">
    <h3>我的好友</h3>
      <p>
      <% 
         String name=(String)session.getAttribute("loginname");
         ResultSet rs=user.selectId(name);
         if(rs.next()){
         int ids=Integer.valueOf(rs.getString("id"));//当前用户id;
         ResultSet rst=user.selectFriends(ids);
         while(rst.next()){
      
      %>
           <%=rst.getString("username") %>&emsp;
		   <a href="deleteFriendAction?ids=<%=rst.getInt("id")%>&id=<%=ids%>">删除</a><br/>
		  <%}
         }
		  %>
      </p>
    </div>
</html>