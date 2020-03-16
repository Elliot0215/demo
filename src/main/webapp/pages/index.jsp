<%@ page import="com.example.demo.domain.User" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>欢迎登录,${user.username}</h1>
<%
    User user = (User) session.getAttribute("user");
    if (user.getUsername().equals("admin")){
        %>
    <a href="/admin">${user.username}</a>
<%
    }else{
        %>
    <a href="/demo">${user.username}</a>
<%
    }
%>
</body>
</html>
