<%@ page import="com.ykp.snacks.domain.admin" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天天生鲜-管理员中心</title>
    <link rel="stylesheet" type="text/css" href="/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/js/alter_user_info.js"></script>
</head>
<body>
<%
    admin admin = (admin)request.getAttribute("admin");
%>
<div class="header_con">
    <div class="header">
        <div class="fr">
            <div class="user_link fl">
                <a href="/">返回首页</a>
                <span>|</span>
                <a href="/AdminController/Quit">退出</a>
            </div>
        </div>
    </div>
</div>

<div class="search_bar clearfix">
    <a href="/" class="logo fl"><img src="/images/lovesnack.jpg"></a>
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;管理员中心</div>
</div>

<div class="main_con clearfix">
    <div class="left_menu_con clearfix">
        <h3>管理员中心</h3>
        <ul>
            <li><a href="/AdminController/to_admin_center_info">· 个人信息</a></li>
            <li><a href="/AdminController/to_alter_admin_info" class="active">· 修改信息</a></li>
            <li><a href="/AdminController/to_admin_center_allorder">· 全部订单</a></li>
            <li><a href="/AdminController/to_admin_center_alluser">· 用户信息</a></li>
            <li><a href="/AdminController/to_admin_center_allGoods">· 商品信息</a></li>
            <li><a href="/AdminController/to_user_feedback">· 用户反馈</a></li>
        </ul>
    </div>
    <div class="right_content clearfix">
        <div class="info_con clearfix">
            <h3 class="common_title2">基本信息</h3>
            <form action="/AlterController/Alteradmin" onsubmit="return checkall_admin()" method="post">
                <div class="reg_form clearfix">
                    <ul>
                        <li>
                            <label>当前密码:</label>
                            <input style="display:none" name="correctpwd" id="correctpwd" value="<%=admin.getPassword()%>">
                            <input type="password" name="currentpassword" id="currentpassword" value="">
                            <span class="error_tip">提示信息</span>
                        </li>
                        <li>
                            <label>修改密码:</label>
                            <input type="text" name="password" id="password" value="" placeholder="<%=admin.getPhone()%>">
                            <span class="error_tip">提示信息</span>
                        </li>
                        <li>
                            <label>手机号:</label>
                            <input type="text" name="phone" id="phone" value="">
                            <span class="error_tip">提示信息</span>
                        </li>
                        <li class="reg_sub">
                            <input type="submit"  value="提 交" name="submit" id="submit">
                        </li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</div>

<%--<script language=javascript>
    function click() {if (event.button==2) {alert('不能看！');}}document.onmousedown=click
</script>--%>
</body>
</html>