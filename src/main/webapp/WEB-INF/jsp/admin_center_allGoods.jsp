<%@ page import="java.util.List" %>
<%@ page import="com.ykp.snacks.domain.goods" %>
<%@ page import="com.ykp.snacks.Service.Impl.GoodsServiceImpl" %>
<%@ page import="com.ykp.snacks.Dao.GoodsDao" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>

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
<div class="header_con">
    <div class="header">
        <div class="fr">
            <div class="user_link fl">
                <a><%=session.getAttribute("name")%></a>
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
<%List<goods> goodsList = (List<goods>)session.getAttribute("allgoods");%>
<div class="main_con clearfix">
    <div class="left_menu_con clearfix">
        <h3>管理员中心</h3>
        <ul>
            <li><a href="/AdminController/to_admin_center_info">· 个人信息</a></li>
            <li><a href="/AdminController/to_alter_admin_info">· 修改信息</a></li>
            <li><a href="/AdminController/to_admin_center_allorder">· 全部订单</a></li>
            <li><a href="/AdminController/to_admin_center_alluser">· 用户信息</a></li>
            <li><a href="/AdminController/to_admin_center_allGoods" class="active">· 商品信息</a></li>
            <li><a href="/AdminController/to_user_feedback">· 用户反馈</a></li>
        </ul>
    </div>
    <div class="right_content clearfix">
        <input type="text" id="lin" class="admin_search_user" placeholder="请输入需要搜索的内容">
        <a href="/PageController/add_goods" style="margin-left: 200px;font-size: 20px">添加蔬菜</a>
        <table id="table-1" cellspacing='0' border="1" class="order_list_table w980">
            <tr>
                <th>图片</th>
                <th>商品名</th>
                <th>商品类型</th>
                <th>价格</th>
                <th>折扣</th>
                <th>销量</th>
                <th>余量</th>
                <th>简介</th>
            </tr>
            <%
                for (int i = 0; i < goodsList.size(); i++) {
                    goods goods = goodsList.get(i);
                   %>
            <form action="/AlterController/admin_alter_goods" method="post">
                <input type="hidden" name="altered_goodsName" value="<%=goods.getName()%>">
                <tr>
                    <td><img style="width: 60px;height: 60px" src="<%=goods.getImage()%>"></td>
                    <td><%=goods.getName()%></td>
                    <td><%=goods.getType()%></td>
                    <td><%=goods.getPrice()%></td>
                    <td><%=goods.getDiscount()%></td>
                    <td><%=goods.getSales()%></td>
                    <td><%=goods.getSurplus()%></td>
                    <td style="font-size: 10px"><%=goods.getInformation()%></td>
                    <td><button type="submit" id="searchuser" name="searchuser">修改</button></td>
                    <td><a href="/AlterController/admine_delete_goods?goodsName=<%=goods.getName()%>">删除</a></td>
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
