<%@ page import="com.ykp.snacks.domain.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/13
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h>所有用户信息如下</h>
<br>
<%
    List<Account> accountList = (List<Account>)session.getAttribute("accountList");
%>
<br>
<%
    for (Account account:accountList){%>
        <a><%=account%></a>
        <br>
    <%}
%>
</body>
</html>
