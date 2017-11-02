<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/6/21
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${sessionScope.goodsTypeList.get(requestScope.goodsTypeId-1).name}</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min-3.2.0.css"/>
    <script src="js/jquery.min-1.9.0.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.min-3.2.0.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">
        .goods_type_box {
            margin: 5px;
        }

        .goods_type_box a {
            margin: 10px;
        }

        .goods_box td {
            padding: 20px;
        }

        .selected {
            color: black;
            font-weight: bold;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"/>

<content>

    <center>
        <div class="goods_type_box">
            <span>商品类型：</span>
            <c:forEach var="goodsType" items="${sessionScope.goodsTypeList}">
                <a href="search_goods_type.jsp?goodsTypeId=${goodsType.goodsTypeId}"
                   <c:if test="${goodsType.goodsTypeId==requestScope.goodsTypeId}">class="selected"</c:if>
                >
                        ${goodsType.name}
                </a>
            </c:forEach>
        </div>
    </center>
    <hr>

    <jsp:include page="goods_box.jsp"/>

</content>

<jsp:include page="footer.jsp"/>

</body>
</html>
