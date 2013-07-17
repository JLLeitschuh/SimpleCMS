<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Section</title>
</head>
<body>
<form id="newSection" method="post">
    <input type="hidden"  id="parentName" name="parentName" value="${parentName}">
    <table>
        <tr>
            <td>
                <label for="name">Section Name:</label><input id="name"  name="name" value="${section.name}" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <label for="published">Published:</label>
                <select id="published" name="published" >
                    <option>true</option>
                    <option>false</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <textarea id="body" name="body">${section.content.body}</textarea>
            </td>
        </tr>
    </table>
    <input type="submit">
</form>
</body>
</html>