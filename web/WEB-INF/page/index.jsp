<%@ page import="java.util.ArrayList" %>
<%@ page import="com.handsome.shop.bean.GoodsCategory" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>英俊商城 - 首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min-3.2.0.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.min-1.9.0.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min-3.2.0.js" type="text/javascript"
            charset="utf-8"></script>
</head>
<body>

<%--<jsp:include page="header.jsp"/>--%>

<%
    request.setAttribute("goodsCategoryList", new ArrayList<GoodsCategory>());
%>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">所有分类</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <c:forEach var="category" items="${goodsCategoryList}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                ${category.name}
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <c:forEach var="child" items="${category.children}">
                                <li>
                                    <a href="/category/${child.categoryId}">${child.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</nav>

<content>

    <div align="center">

        <%--<div class="goods_type_box">--%>
        <%--<span>商品类型：</span>--%>
        <%--<c:forEach var="goodsType" items="${sessionScope.goodsTypeList}">--%>
        <%--<a href="search_goods_type.jsp?goodsTypeId=${goodsType.goodsTypeId}">${goodsType.name}</a>--%>
        <%--<a href="#">${goodsType.name}</a>--%>
        <%--</c:forEach>--%>
        <%--</div>--%>

        <div class="search_box">
            <input type="text" class="form-control" id="search_word" placeholder="请输入商品关键字">
            <button class="btn btn-primary" onclick="search()">搜索</button>
        </div>

        <%--<a class="ad" title="618狂欢节会场" href="#">--%>
        <%--<img src="img/img_618.jpg">--%>
        <%--</a>--%>

    </div>

    <div align="center"><h2>双十一专场</h2></div>

    <jsp:include page="index_11_11.jsp"/>

    <div align="center"><h2>服装区</h2></div>

    <div align="center"><h2>手机区</h2></div>

</content>

<jsp:include page="footer.jsp"/>

<script type="text/javascript">
    function search() {
        var searchWord = $("#search_word").val();
        if (searchWord == "") {
            alert("请输入关键字搜索");
            return;
        }
        window.location.href = "search.do?searchWord=" + searchWord;
    }
</script>

</body>
</html>
