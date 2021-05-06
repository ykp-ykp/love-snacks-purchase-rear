<%@ page import="com.ykp.snacks.domain.goods" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/29
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--下面引用外部js没有用，所哟js我就写在了最下面--%>
    <link rel="stylesheet" type="text/css" href="/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/js/register.js"></script>

</head>
<body>
<div class="register_con">
    <div class="l_con fl">
        <a class="reg_logo"><img src="/images/lovesnack.jpg"></a>
        <div class="reg_slogan">快速送达  ·  即刻享用</div>
        <div class="reg_banner"></div>
    </div>

    <div class="r_con fr">
        <div class="reg_title clearfix">
            <h1>修改商品信息</h1>
        </div>
        <%
            goods goods = (goods)request.getAttribute("alter_goods");
        %>
        <div class="reg_form clearfix">
            <form action="/FileController/UpdateGoods" method="post" onsubmit="return admin_alter_goods_checkall()" id="reg_form" enctype="multipart/form-data">
                <ul>
                    <li>
                        <label>商品名:</label>
                        <input type="text" name="goodsName" id="goodsName" readonly="readonly" value="<%=goods.getName()%>">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>价格:</label>
                        <input type="text" name="price" id="price" value="<%=goods.getPrice()%>" placeholder="<%=goods.getPrice()%>">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>折扣:</label>
                        <input type="text" name="discount" id="discount" value="1.0" placeholder="最大为1.0">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>余量:</label>
                        <input type="text" name="surplus" id="surplus" value="<%=goods.getSurplus()%>" placeholder="<%=goods.getSurplus()%>">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>简介:</label>
                        <textarea name="information" id="information" style="width: 288px;height: 50px "><%=goods.getInformation()%></textarea>
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>图片:</label>
                        <input type="file" name="file" id="file"/>
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li class="reg_sub">
                        <input type="submit"  value="确 定" name="submit" id="submit">
                    </li>
                </ul>
            </form>
        </div>
    </div>

</div>
</body>
</html>