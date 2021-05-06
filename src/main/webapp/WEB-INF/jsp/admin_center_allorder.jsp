<%@ page import="java.util.List" %>
<%@ page import="com.ykp.snacks.domain.order" %>
<%@ page import="com.ykp.snacks.domain.goods" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.ykp.snacks.Dao.GoodsDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>

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
            <li><a href="/AdminController/to_alter_admin_info">· 修改信息</a></li>
            <li><a href="/AdminController/to_admin_center_allorder" class="active">· 全部订单</a></li>
            <li><a href="/AdminController/to_admin_center_alluser">· 用户信息</a></li>
            <li><a href="/AdminController/to_admin_center_allGoods">· 商品信息</a></li>
        </ul>
    </div>
<%
    ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletConfig().getServletContext());
    GoodsDao goodsDao=(GoodsDao)ctx.getBean("goodsDao");//获取bean接口对象

    //订单状态
    ArrayList<String> states = new ArrayList<String>(Arrays.asList("待发货", "待评价","退货中", "已评价","已发货","退货已完成"));
%>
    <%
        List<order> allorder = (List<order>)session.getAttribute("allorder");
    %>


<div class="right_content clearfix">
    <input type="text" id="lin" class="admin_search_user" placeholder="请输入需要搜索的内容">
    <table id="table-1" cellspacing='0' border="1" class="order_list_table w980">

        <tr>
            <th>图片</th><th>商品名</th><th>单价--个数</th><th>总金额</th><th>订单编号</th><th>状态</th><th>微信昵称</th>
        </tr>
        <tr><td style="color:#ff8800;">已确认收货的订单</td></tr>

        <%
            for (int i = 0; i <allorder.size() ; i++) {
                order order = allorder.get(i);
                if(order.getState() == 2 || order.getState() == 3){
                    String goodsName = order.getGoodsName();
                    goods goods = goodsDao.getGoodsByname(goodsName);
        %>

            <tr>
                <td><img style="width: 60px;height: 60px" src="<%=goods.getImage()%>"></td>
                <td><%=goods.getName()%></td>
                <td><%=goods.getPrice()%>--<%=order.getWeight()%></td>
                <td><%=order.getTotalPrice()%></td>
                <td><%=order.getOrderId()%></td>
                <td style="color:#ff8800;"><%=states.get(order.getState()-1)%></td>
                <td style="font-size: 10px"><%=order.getNickName()%></td>
                <td><a href="/AdminController/orderDetail?orderId=<%=order.getOrderId()%>">详情</a></td>
            </tr>
        </form>
        <%}}
        %>
        <tr><td style="color:#ff8800;">未确认收货的订单</td></tr>

        <%
            for (int i = 0; i <allorder.size() ; i++) {
                order order = allorder.get(i);
                if(order.getState() != 2 && order.getState() != 3){
                    String goodsName = order.getGoodsName();
                    goods goods = goodsDao.getGoodsByname(goodsName);
        %>

        <tr>
            <td><img style="width: 60px;height: 60px" src="<%=goods.getImage()%>"></td>
            <td><%=goods.getName()%></td>
            <td><%=goods.getPrice()%>--<%=order.getWeight()%></td>
            <td><%=order.getTotalPrice()%></td>
            <td><%=order.getOrderId()%></td>
            <td style="color:#ff8800;"><%=states.get(order.getState()-1)%></td>
            <td style="font-size: 10px"><%=order.getNickName()%></td>
            <td><a href="/AdminController/orderDetail?orderId=<%=order.getOrderId()%>">详情</a></td>
        </tr>
        </form>
        <%}}
        %>
    </table>
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
