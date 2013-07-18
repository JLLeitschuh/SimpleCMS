<%@ page import="com.cyganov.simplecms.servlets.AddSectionServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags.tld" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Site</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css" />
    <script>
        $(function() {
            $( "#menu").menu();
        });
    </script>
    <style>
        .ui-menu { width: 250px; }
    </style>
</head>
<body>

<table width="100%">
    <tr>
        <td width="20%" height="80%">
            <ul id="menu">
            <s:section list="${sections}"/>
            </ul>
        </td>
        <td width="80%" height="80%" style="text-align: center">
            <c:out value="${mainSection.content.body}"/>
        </td>
    </tr>
</table>

<input type="button" value="Add Section" onclick="document.location.href='/add?parentId=${mainSection.id}'">
<input type="button" value="Edit Section" onclick="document.location.href='/add?parentId=${mainSection.parent.id}&sectionId=${mainSection.id}'">
</body>
</html>