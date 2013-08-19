<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>

<form:form commandName="user" >
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="username" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td>
                Enabled:
                <form:select path="enabled">
                    <form:option value="true" label="true"/>
                    <form:option value="false" label="false"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Roles:</td>
            <td>
                <form:checkbox path="authorities" value="ROLE_USER" label="USER"/>
                <form:checkbox path="authorities" value="ROLE_ADMIN" label="ADMIN"/>
                <form:checkbox path="authorities" value="ROLE_SUPERVISOR" label="SUPERVISOR"/>
            </td>
        </tr>
    </table>
    <button style="width: 100px;" type="submit">Submit</button>
</form:form>
<button onclick="document.location.href='/users'">Back</button>
</body>
</html>