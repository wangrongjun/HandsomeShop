<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/6/18
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>GoodsBox</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/goods_box.css">
</head>
<body>

<div class="goods_box container">
    <div class="row" id="food_goods_list"></div>
</div>

<script>
    showGoodsList(${requestScope.foodGoodsListJson});
    function showGoodsList(goodsList) {
        var $goodsList = $("#food_goods_list");
        for (var i = 0; i < goodsList.length; i++) {
            var goods = goodsList[i];
            var html = '\
            <div class="col-sm-3">\
                <div class="goods">\
                    <div class="goods_image">\
                        <a href="goods/' + goods.goodsId + '">\
                            <img src="' + goods.goodsImageList[0].imageUrl + '"/>\
                        </a>\
                    </div>\
                    <a href="goods/' + goods.goodsId + '" class="goods_name">' + goods.goodsName + '</a>\
                    <div class="price">￥ ' + goods.price + '</div>\
                    <div class="remain_and_sell">\
                        <span class="remain">库存：<span id="remainCount">' + goods.remainCount + '</span>&nbsp;件</span>\
                        <span class="sell">销量：<span id="sellCount">0</span>&nbsp;笔</span>\
                    </div>\
                    <div class="description">' + goods.description + '</div>\
                </div>\
            </div>\
            ';
            $goodsList.append(html);
        }
    }
</script>

</body>
</html>
