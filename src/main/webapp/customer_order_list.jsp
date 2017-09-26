<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/6/22
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min-3.2.0.css"/>
    <link rel="stylesheet" href="header.jsp">
    <link rel="stylesheet" type="text/css" href="css/customer_order_list.css"/>
    <script src="js/jquery.min-1.9.0.js"></script>
    <script src="js/bootstrap.min-3.2.0.js"></script>
</head>
<body>

<jsp:include page="header.jsp"/>

<content>

    <center><h1>我的订单(${requestScope.ordersCount})</h1></center>

    <c:forEach var="orders" items="${requestScope.ordersList}">
        <div class="order_item">
            <div class="goods_image">
                <img src="${orders.goods.goodsImageList.get(0).imageUrl}"/>
            </div>
            <div class="right_box">
                <div class="order_info">
                    <div>订单编号：${orders.ordersId}</div>
                    <div>商品名称：${orders.goods.goodsName}</div>
                    <div>店鋪名称：${orders.goods.shop.shopName}</div>
                    <div>购买数量：${orders.buyCount}</div>
                    <div>收货人：${orders.receiverName}</div>
                    <div>联系电话：${orders.phone}</div>
                    <div>收货地址：${orders.address}</div>
                    <div>创建时间：${orders.createTime}</div>
                    <div>订单状态：<span>
                            ${orders.state==0?"交易中":(orders.state==1?"交易成功":"交易失败")}
                    </span>
                    </div>
                    <div>总价：￥ <span>${orders.price}</span></div>
                    <div class="btn_box">
                        <c:choose>
                            <c:when test="${orders.state==0}">
                                <button class="btn btn-danger">申请退款</button>
                                <button class="btn btn-success" onclick="confirm(${orders.ordersId})">确认收货</button>
                            </c:when>
                            <c:when test="${orders.state==1}">
                                <button class="btn btn-danger" onclick="deleteOrders(${orders.ordersId})">删除订单</button>
                            </c:when>
                            <c:when test="${orders.state==2}">
                                <button class="btn btn-danger" onclick="deleteOrders(${orders.ordersId})">删除订单</button>
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
        <hr>
    </c:forEach>
</content>

<jsp:include page="footer.jsp"/>

<script type="text/javascript">
    function deleteOrders(ordersId) {

    }

    function confirm(ordersId) {

    }
</script>

</body>
</html>
