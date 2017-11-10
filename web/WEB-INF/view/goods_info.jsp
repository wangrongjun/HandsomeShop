<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/6/18
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>${requestScope.goods.goodsName}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min-3.2.0.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/luara.left.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/goods_info.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header_content_footer.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min-3.2.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body onload="showMsg('${requestScope.msg}')">

<jsp:include page="header.jsp"/>

<content>

    <div class="top">
        <div class="img_box">
            <ul>
                <c:forEach var="image" items="${requestScope.goods.goodsImageList}">
                    <li><img src="${image.imageUrl}"></li>
                </c:forEach>
            </ul>
            <ol>
                <c:forEach var="image" items="${requestScope.goods.goodsImageList}">
                    <li><img src="${image.imageUrl}"></li>
                </c:forEach>
            </ol>
        </div>

        <div class="right_box">
            <div class="goods_info_box">
                <div class="goods_name">
                    商品名称：
                    <span id="goods_name">${requestScope.goods.goodsName}</span>
                </div>

                <div class="goods_price">
                    商品价格：￥
                    <span id="goods_price">${requestScope.goods.price}</span>
                </div>
                <div class="goods_description">
                    商品描述：
                    <span id="goods_description">${requestScope.goods.description}</span>
                </div>
                <div class="goods_type">
                    商品类型：
                    <span id="goods_type">${requestScope.goods.goodsCategory.name}</span>
                </div>
            </div>

            <hr>

            <div class="attr_info">
                <div>颜色</div>
                <input type="radio" name="attr_color" id="color_white" value="white"/>
                <label for="color_white">白色</label>
                <input type="radio" name="attr_color" id="color_black" value="white"/>
                <label for="color_black">黑色</label>
                <div>尺寸</div>
                <input type="radio" name="attr_size" id="size_small" value="small"/>
                <label for="size_small">小号</label>
                <input type="radio" name="attr_size" id="size_large" value="large"/>
                <label for="size_large">大号</label>
            </div>

            <hr>

            库存：${requestScope.goods.remainCount}

            <form action="confirmOrder.do?goodsId=${requestScope.goods.goodsId}" method="post">
                <div class="buy_box">
                    <label for="count">购买数量：</label>
                    <input type="number" name="count" id="count" class="form-control" value="1"/>
                    <a class="btn btn-warning" onclick="addGoodsToShopCar()">加入购物车</a>
                    <input class="btn btn-danger" type="submit" value="购买"/>
                </div>
            </form>
        </div>
    </div>

    <hr/>

    <div class="seller_box">
        <div class="seller_head">
            <img src="${requestScope.goods.shop.headUrl}"/>
        </div>
        <div class="right_box">
            <div class="seller_info">
                <div class="seller_name">${requestScope.goods.shop.shopName}</div>
                <div class="seller_description">${requestScope.goods.shop.description}</div>
                <div class="btn_box">
                    <a class="btn btn-success" href="shop_detail.jsp?shopId=${requestScope.goods.shop.shopId}">进店逛逛</a>
                    <button class="btn btn-danger" onclick="showSellerInfo()">联系卖家</button>
                </div>
            </div>
        </div>
    </div>

    <hr/>

    <div class="evaluate_box">
        <center>用户评价</center>
        <div class="divider"></div>

        <c:if test="${requestScope.evaluateList.size()==0}">
            <center>暂无评价</center>
        </c:if>

        <c:forEach var="evaluate" items="${requestScope.evaluateList}">
            <div class="item_box">
                <div class="head">
                    <img src="${evaluate.ordersDetail.orders.customer.headUrl}"/>
                </div>
                <div class="right">
                    <div>
                        <div class="gender">
                            <img src="${evaluate.ordersDetail.orders.customer.gender==1?
                            "/img/ic_gender_man.png":"/img/ic_gender_woman.png"}"/>
                        </div>
                        <div class="evaluate">
                            <img src="${evaluate.evaluateLevel==0?"/img/ic_evaluate_bad.png":
                            (evaluate.evaluateLevel==1?"/img/ic_evaluate_normal.png":"/img/ic_evaluate_good.png")}"/>
                        </div>
                        <span class="name">${evaluate.ordersDetail.orders.customer.nickname}</span>
                        <span class="time">${evaluate.createTime}</span>
                    </div>
                    <div class="content">${evaluate.content}</div>
                </div>
            </div>
            <div class="divider"></div>
        </c:forEach>
    </div>

</content>

<jsp:include page="footer.jsp"/>

<div class="modal fade" id="mymodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">商家信息</h4>
            </div>
            <div class="modal-body">
                <div style="height: 100px;width: 100px">
                    <img src="${requestScope.goods.shop.seller.headUrl}" style="height: 100% ;width: 100%;">
                </div>
                <div>商家昵称：${requestScope.goods.shop.seller.nickname}</div>
                <div>商家姓名：${requestScope.goods.shop.seller.realName}</div>
                <div>商家性别：${requestScope.goods.shop.seller.gender==1?"男":"女"}</div>
                <div>商家电话：${requestScope.goods.shop.seller.phone}</div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<script>

    function showSellerInfo() {
        $('#mymodal').modal('toggle');
    }

    function showMsg(msg) {
        if (msg != "") {
            alert(msg);
        }
    }

    function addGoodsToShopCar() {
        var count = $("#count").val();
        window.location.href = "addGoodsToShopCar.do?goodsId=${requestScope.goods.goodsId}&count=" + count;
    }

    $(function () {
        <!--调用Luara示例-->
        $(".img_box").luara({
            width: "500",
            height: "334",
            interval: 2000,
            selected: "seleted",
            deriction: "left"
        });

    });
</script>

</body>
</html>
