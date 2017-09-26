<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/9/21
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("getContextPath: " + request.getContextPath());
    System.out.println("getServletPath: " + request.getServletPath());
    System.out.println("getServletContext().getRealPath(\"a\"): " + request.getServletContext().getRealPath("a"));
    System.out.println("getServletContext().getRealPath(\"\\\"): " + request.getServletContext().getRealPath("\\"));
    System.out.println("getServletContext().getRealPath(\"\\a\"): " + request.getServletContext().getRealPath("\\a"));
    System.out.println("getServletContext().getRealPath(\"/\"): " + request.getServletContext().getRealPath("/"));
    System.out.println("getServletContext().getRealPath(\"/a\"): " + request.getServletContext().getRealPath("/a"));
    System.out.println("getServletContext().getContextPath(): " + request.getServletContext().getContextPath());
    System.out.println("getServletContext().getContext(\"a\"): " + request.getServletContext().getContext("a"));

    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        String value = cookie.getValue();
    }
%>
<form action="">
    <input type="time">
</form>
</body>
</html>
