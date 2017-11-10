<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/6/18
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_content_footer.css">
</head>
<body>

<header>
    <a class="brand" href="${pageContext.request.contextPath}/">英俊商城</a>
    <div class="menu">
        <a href="${pageContext.request.contextPath}/">首页</a>
        <%
            //            Customer customer = (Customer) request.getSession().getAttribute("customer");
//            if (customer == null) {
        %>
        <a href="/login.jsp">登录</a>
        <a href="/register.jsp">注册</a>
        <%
            //        } else {
//            CartDao shopCarDao = DaoFactory.getShopCarDao();
//            long shopCarCount = shopCarDao.queryCountByCustomerId(customer.getCustomerId());
//            OrdersDao ordersDao = DaoFactory.getOrdersDao();
//            int ordersCount = ordersDao.queryCountByCustomerId(customer.getCustomerId());
        %>
        <a href="/customer_info.jsp">英俊</a>
        <a href="/shop_car.jsp">我的购物车(0)</a>
        <a href="/customer_order_list.jsp">我的订单(0)</a>
        <a href="logout.do">[退出登录]</a>
        <%
//            }
        %>
    </div>
</header>

</body>
</html>
