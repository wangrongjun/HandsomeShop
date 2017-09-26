<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/6/18
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min-3.2.0.css"/>
    <script src="js/jquery.min-1.9.0.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.min-3.2.0.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

<jsp:include page="header.jsp"/>
<content>
    <center><h1>我的购物车(${requestScope.totalCount})</h1></center>
    <jsp:include page="goods_box.jsp"/>
    <c:if test="${requestScope.goodsList.size()>0}">
        <center>
            <button class="btn btn-danger btn-lg" style="margin-top: 30px">结算</button>
        </center>
    </c:if>
</content>
<jsp:include page="footer.jsp"/>

</body>
</html>
