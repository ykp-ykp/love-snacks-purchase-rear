<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/30
  Time: 9:21
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
            <h1>添加蔬菜</h1>
        </div>
        <div class="reg_form clearfix">
            <form action="/FileController/addGoods" method="post" onsubmit="return add_goods_checkall()" id="reg_form" enctype="multipart/form-data">
                <ul>
                    <li>
                        <label>商品名:</label>
                        <input type="text" name="goodsName" id="goodsName" value="">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>类型:</label>
                        <select style="width: 288px;height:35px;" type="text" name="type" id="type" value="" >
                            <option>无辣不欢</option><option>休闲零食</option><option>饮料牛奶</option>
                            <option>瓜子坚果</option><option>方便面</option><option>纸品清洁</option>
                            <option>仙女专用</option>
                        </select>
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>价格:</label>
                        <input type="text" name="price" id="price" value="" >
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>折扣:</label>
                        <input type="text" name="discount" id="discount" value="1.0" placeholder="最大为1.0">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>余量:</label>
                        <input type="text" name="surplus" id="surplus" value="">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>简介:</label>
                        <textarea name="information" id="information" style="width: 288px;height: 50px "></textarea>
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