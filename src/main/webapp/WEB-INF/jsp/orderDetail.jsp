<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/3
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.ykp.snacks.domain.order" %>
<%@ page import="com.ykp.snacks.domain.goods" %>
<%@ page import="com.ykp.snacks.domain.user" %>
<%@ page import="com.ykp.snacks.domain.evaluation" %>
<%@ page import="com.ykp.snacks.Dao.GoodsDao" %>
<%@ page import="com.ykp.snacks.Dao.UserDao" %>
<%@ page import="com.ykp.snacks.Dao.EvaluationDao" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.hsqldb.rights.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>订单详情</title>
    <link href="../../css/orderDetail.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%
    ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletConfig().getServletContext());
    GoodsDao goodsDao=(GoodsDao)ctx.getBean("goodsDao");//获取bean接口对象GoodsDao(开头字母小写)
    UserDao userDao=(UserDao)ctx.getBean("userDao");//获取bean接口对象UserDao
    EvaluationDao evaluationDao=(EvaluationDao)ctx.getBean("evaluationDao");//获取bean接口对象UserDao

    order orderDetail = (order)request.getAttribute("orderDetail");
    goods goods = goodsDao.getGoodsByname(orderDetail.getGoodsName());
    user user = userDao.getUserByOpenid(orderDetail.getOpenid());
    evaluation evaluation = evaluationDao.getOneEvaluation(orderDetail.getOrderId(),user.getOpenid() );
    ArrayList<String> orderState = new ArrayList<String>(Arrays.asList("待发货", "待评价", "用户申请退货","用户已评价","已发货", "退货已完成"));
%>



<section class="aui-flexView">
    <header class="aui-navBar aui-navBar-fixed">
        <%--<a href="javascript:;" class="aui-navBar-item">--%>
            <%--<i class="icon icon-return"></i>--%>
        <%--</a>--%>
        <div class="aui-center">
            <span class="aui-center-title">订单详情</span>
        </div>
        <a href="javascript:;" class="aui-navBar-item">
            <i class="icon icon-sys"></i>
        </a>
    </header>
    <section class="aui-scrollView">
        <div class="aui-flex aui-flex-context">
            <div class="aui-flex-box">
                <%-- 1：待发货，2：待评价，3：退货，4：已评价，5：已发货，6：已完成退货--%>
                <h2>订单状态：<%=orderState.get(orderDetail.getState()-1)%></h2>
                <h3></h3>
            </div>
        </div>
        <div class="aui-flex">
            <div class="aui-address-img">
                <img src="<%=user.getAvatarUrl()%>" alt="">
            </div>
            <div class="aui-flex-box">
                <h4>电话：<em><%=user.getPhone()%></em></h4>
                <h4>收货地址：<em><%=user.getAddress()%></em></h4>
            </div>
        </div>

        <div class="aui-flex aui-flex-four">
            <div class="aui-flex-add">
                <img src="<%=goods.getImage()%>" alt="">
            </div>
            <div class="aui-flex-box">
                <p><%=orderDetail.getGoodsName()%></p>
                <p class="b-line" style="color:#999">共<%=orderDetail.getWeight()%>个</p>
            </div>
        </div>
        <div class="aui-flex aui-flex-four" style="padding-top:0">
            <div class="aui-flex-box">

                <%if(orderDetail.getState()==1){%>
                    <a href="/AlterController/DeliverGoods?orderId=<%=orderDetail.getOrderId()%>">
                        <button>发货</button>
                    </a>
                <%}%>
                <%if(orderDetail.getState()==3){%>
                <a href="/AlterController/ReturnGoods?orderId=<%=orderDetail.getOrderId()%>">
                    <button >同意退货</button>
                </a>

                <%}%>

            </div>
        </div>
        <div class="aui-flex b-line">
            <div class="aui-flex-box">
                <h6>订单金额: <em>￥<%=orderDetail.getTotalPrice()%></em> <i>(免运费)</i></h6>
            </div>
        </div>
        <div class="aui-list-box">
            <a href="javascript:;" class="aui-flex aui-flex-right">
                <%--<div class="aui-flex-icon-img">--%>
                    <%--<h4>联系买家：<%=user.getPhone()%></h4>--%>
                <%--</div>--%>
                <div class="aui-flex-box" style="position: relative;right: 290px;">
                    <h4>联系买家：<%=user.getPhone()%></h4>
                </div>
            </a>

        </div>
        <div class="divHeight"></div>
        <div class="aui-flex">
            <div class="aui-flex-box">
                <h4>订单编号: <em><%=orderDetail.getOrderId()%></em></h4>
                <h4>支付方式: <em>微信支付</em></h4>
                <h4>下单时间: <em><%=orderDetail.getTime()%></em></h4>
                <%
                    if(orderDetail.getState()==4){%>
                        <h4 class="evaluation">评论信息：<%=evaluation.getContent()%></h4>
                <%}%>
            </div>
        </div>
    </section>

</body>
</html>
