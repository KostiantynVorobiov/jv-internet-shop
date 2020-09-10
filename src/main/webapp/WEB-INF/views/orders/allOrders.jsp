<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All order (Admin)</title>
</head>
<body>
<h1>All user's orders</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>User</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>
                <c:out value="${order.id}"/>
            </td>
            <td>
                <c:out value="${order.userId}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>