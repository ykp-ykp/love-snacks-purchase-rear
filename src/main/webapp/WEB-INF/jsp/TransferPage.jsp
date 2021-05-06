<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/22
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>中转页面</title>
</head>
<body>
<input type="hidden" id="info" value="<%=request.getAttribute("info") %>">
<input type="hidden" id="pagename" value="<%=request.getAttribute("pagename") %>">
<script type="text/javascript">
    var error = document.getElementById("info").value;
    var pagename = document.getElementById("pagename").value;
    alert(error);
    window.location=("/PageController/"+pagename);
</script>
</body>
</html>
