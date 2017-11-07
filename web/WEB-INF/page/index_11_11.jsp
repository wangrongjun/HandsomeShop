<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/6/18
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>GoodsBox</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min-3.2.0.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/goods_box.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min-1.9.0.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min-3.2.0.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/wang.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

<div class="goods_box container">
    <div class="row">

        <c:forEach var="goods" items="${requestScope.double11GoodsList}" varStatus="status">
            <div class="col-sm-3">
                <div class="goods">
                    <div class="goods_image">
                        <a href="goods/${goods.goodsId}">
                                <%--<c:if test="${goods.goodsImageList!=null&&goods.goodsImageList.size()>0}">--%>
                                <%--<img src="${goods.goodsImageList.get(0).imageUrl}"/>--%>
                                <%--</c:if>--%>
                            <img src="${goods.goodsImageList.get(0).imageUrl}"/>
                        </a>
                    </div>
                    <a href="goods/${goods.goodsId}" class="goods_name">
                            ${goods.goodsName}
                    </a>
                    <div class="price">￥ ${goods.price}</div>
                    <div class="remain_and_sell">
                        <span class="remain">库存：<span id="remainCount">${goods.remainCount}</span>&nbsp;件</span>
                        <span class="sell">销量：<span id="sellCount">${goods.sellCount}</span>&nbsp;笔</span>
                    </div>
                    <div class="description">${goods.description}</div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

</body>
</html>
