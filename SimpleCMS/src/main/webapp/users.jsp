<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<table class="users">
    <tr class="head">
        <td>Name</td>
        <td>Role</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${users}" var="record">
        <tr>
            <td><c:out value="${record.username}"/></td>
            <td>
                <c:out value="${record.authorities} "/>
            </td>
            <td><a href="/users/add?id=${record.username}"><c:out value="Edit"/></a></td>
            <td><a href="/users/delete?id=${record.username}"><c:out value="Delete"/></a></td>
        </tr>
    </c:forEach>
</table>

<button onclick="document.location.href='/users/add?id='">Add User</button>

<div class="logout" style="text-align: right">
    <a href="<c:url value="/j_spring_security_logout" />" > Logout </a>
</div>

</body>
</html>