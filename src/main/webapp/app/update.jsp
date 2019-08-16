<%--
  Created by IntelliJ IDEA.
  User: 47666
  Date: 2019/8/14
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>


<body>
<form id="form1" method="post" action="${pageContext.request.contextPath}/update">
    id:<input name="id" type="text">
    name:<input name="name" type="text">
    pwd:<input name="pwd" type="password">
    <input type="submit" value="确认">
    </form>
</body>
</html>
