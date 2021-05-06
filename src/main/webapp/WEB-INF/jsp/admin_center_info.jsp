
<%@ page import="com.ykp.snacks.domain.admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天天生鲜-管理员中心</title>
    <link rel="stylesheet" type="text/css" href="/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<%
    admin admin = (admin)session.getAttribute("admin");
%>
<div class="header_con">
    <div class="header">
        <div class="fr">
            <div class="user_link fl">
                <a><%=admin.getName()%></a>
                <span>|</span>
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
            <li><a href="/AdminController/to_admin_center_info" class="active">· 个人信息</a></li>
            <li><a href="/AdminController/to_alter_admin_info">· 修改信息</a></li>
            <li><a href="/AdminController/to_admin_center_allorder">· 全部订单</a></li>
            <li><a href="/AdminController/to_admin_center_alluser">· 用户信息</a></li>
            <li><a href="/AdminController/to_admin_center_allGoods">· 商品信息</a></li>
            <li><a href="/AdminController/to_user_feedback">· 用户反馈</a></li>
        </ul>
    </div>
    <div class="right_content clearfix">
        <div class="info_con clearfix">
            <h3 class="common_title2">基本信息</h3>
            <ul class="user_info_list">
                <li><span>用户名：</span><%=admin.getName()%></li>
                <li><span>密码：</span><%=admin.getPassword()%></li>
                <li><span>性别：</span><%=admin.getSex()%></li>
                <li><span>电话：</span><%=admin.getPhone()%></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
