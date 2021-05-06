
<%@ page import="com.ykp.snacks.domain.user" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/29
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天天生鲜-管理员中心</title>
    <link rel="stylesheet" type="text/css" href="/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/js/table_search.js"></script>
</head>
<body>
<%
    List<user> allusers = (List<user>)session.getAttribute("allusers");
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
        <h3>用户中心</h3>
        <ul>
            <li><a href="/AdminController/to_admin_center_info">· 个人信息</a></li>
            <li><a href="/AdminController/to_alter_admin_info">· 修改信息</a></li>
            <li><a href="/AdminController/to_admin_center_allorder">· 全部订单</a></li>
            <li><a href="/AdminController/to_admin_center_alluser"  class="active">· 用户信息</a></li>
            <li><a href="/AdminController/to_admin_center_allGoods">· 商品信息</a></li>
        </ul>
    </div>
    <div class="right_content clearfix">
        <input type="text" id="lin" class="admin_search_user" placeholder="请输入需要搜索的内容">
        <table id="table-1" cellspacing='0' border="1" class="order_list_table w980">
            <tr>
                <th>微信昵称</th>
                <th>电话</th>
                <th>地址</th>
            </tr>
            <%
                for (int i = 0; i < allusers.size(); i++) {
                    user user = allusers.get(i);%>
            <form action="/AlterController/admin_alter_user" method="post">
                <input type="hidden" name="openid" value="<%=user.getOpenid()%>">
                <tr>
                    <td><%=user.getNickName()%></td>
                    <td><%=user.getPhone()%></td>
                    <td><%=user.getAddress()%></td>
                    <td><button type="submit" id="searchuser" name="searchuser">修改</button></td>
                </tr>
            </form>
            <%}
            %>
        </table>
    </div>
</div>

<script type="text/javascript">
    var table = document.getElementById("table-1");
    var input = document.getElementById("lin")
    input.onkeyup = function () {
        new Search(table, input)
    }
</script>
</body>
</html>