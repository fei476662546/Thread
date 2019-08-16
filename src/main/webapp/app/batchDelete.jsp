<%--
  Created by IntelliJ IDEA.
  User: 47666
  Date: 2019/8/14
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>User</td>
        <td>pwd</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${Acclist}" var="acc" varStatus="s">
        <tr>
            <td><input type="checkbox" name="Acclist[${s.index}].id" value="${acc.id}"></td>
                <%-- 有疑问--%>
            <td><input type="text" name="Acclist[${s.index}].name" value="${acc.name}"></td>
            <td><input type="text" name="Acclist[${s.index}].pwd" value="${acc.pwd}"></td>
            <td>
                <a href="${pageContext.request.contextPath}/edit?id=${acc.id}">修改</a><%-- 有疑问--%>
                <span>${msg}</span>
                <a href="${pageContext.request.contextPath}/delete?id=${acc.id}">删除</a><%-- 有疑问--%>
                <span>${msg}</span>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
