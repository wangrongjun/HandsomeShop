<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>英俊商城 - 首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min-3.2.0.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min-3.2.0.js"></script>
</head>

<body>

<jsp:include page="header.jsp"/>

<div id="show"></div>

<content>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">所有分类</a>
            </div>
            <div>
                <ul class="nav navbar-nav" id="category_ul_list">
                    <%--<c:forEach var="category" items="${requestScope.categoryList}">--%>
                    <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                    <%--${category.name}--%>
                    <%--<b class="caret"></b>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu">--%>
                    <%--<c:forEach var="child" items="${category.children}">--%>
                    <%--<li>--%>
                    <%--<a href="/category/${child.categoryId}">${child.name}</a>--%>
                    <%--</li>--%>
                    <%--</c:forEach>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--</c:forEach>--%>
                </ul>
            </div>
        </div>
    </nav>

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

    <div align="center"><h2>食品</h2></div>

    <jsp:include page="index_food.jsp"/>

    <div align="center"><h2>电子产品</h2></div>

    <jsp:include page="index_electric.jsp"/>

</content>

<jsp:include page="footer.jsp"/>

<script type="text/javascript">
    function search() {
        var searchWord = $("#search_word").val()
        if (searchWord == "") {
            alert("请输入关键字搜索")
            return;
        }
        window.location.href = "search.do?searchWord=" + searchWord
    }

    $(function () {
        var categoryList =${requestScope.categoryListJson};
        for (var i = 0; i < categoryList.length; i++) {
            var father = categoryList[i];
            if (father.categoryDepth != 1) {// 如果不是一级分类，跳过
                continue;
            }
            var childrenHtml = "";
            for (var j = 0; j < categoryList.length; j++) {
                var child = categoryList[j];
                // 如果不是从属于当前一级分类下的二级分类，跳过
                if (child.categoryDepth != 2 || child.superCategory.categoryId != father.categoryId) {
                    continue;
                }
                childrenHtml +=
                    "<li>" +
                    "<a href='/category/" + child.categoryId + "'>" + child.name + "</a>" +
                    "</li>";
            }
            $("#category_ul_list").append(
                "<li class='dropdown'>" +
                "<a href='#' class='dropdown-toggle' data-toggle='dropdown'>" +
                father.name +
                "<b class='caret'></b>" +
                "</a>" +
                "<ul class='dropdown-menu'>" + childrenHtml + "</ul>" +
                "</li>"
            );
        }
    });

    $(function () {
        $("a.dropdown-toggle").on("mouseenter", function () {
            $(this).click()
        })
    });
</script>

</body>
</html>
