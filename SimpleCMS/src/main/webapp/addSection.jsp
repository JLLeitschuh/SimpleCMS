<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add New Section</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<%--<form id="newSection" method="post">--%>
    <%--<input type="hidden"  id="parentId" name="parentId" value="${parentId}">--%>
    <%--<input type="hidden"  id="id" name="id" value="${section.id}">--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<label for="name">Section Name:</label><input id="name"  name="name" value="${section.name}" type="text">--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<label for="published">Published:</label>--%>
                <%--<select id="published" name="published" >--%>
                    <%--<option>true</option>--%>
                    <%--<option>false</option>--%>
                <%--</select>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td colspan="2">--%>
                <%--<textarea id="body" name="body">${section.content.body}</textarea>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <%--<input type="submit">--%>
<%--</form>--%>
<input type="hidden"  id="parentId" name="parentId" value="${parentId}">
<form:form id="section" commandName="section" method="post">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>
                Section Name:<form:input path="name" />
            </td>
        </tr>
        <tr>
            <td>
                Published:
                <form:select path="published">
                    <form:option value="true" label="true"/>
                    <form:option value="false" label="false"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                 <form:hidden path="content.id" />
                 <form:textarea path="content.body" />
            </td>
        </tr>
    </table>
    <button type="submit">Submit</button>
</form:form >
<button onclick="document.location.href='/site?rootId=&sectionId='">Back</button>
</body>
</html>