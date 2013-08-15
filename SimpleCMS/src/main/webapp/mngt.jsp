<%@ taglib uri="/WEB-INF/tags.tld" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Site Management</title>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('.close').click(function(){
                document.location.href='/mngt/delete?id='+this.id;
            });
        });
    </script>
</head>
<body>
    <table width="100%">
        <tr>
            <td width="20%" height="90%">
                <ul class="tree">
                    <s:tree list="${sections}"/>
                </ul>
                <button onclick="document.location.href='/mngt/add'">Add Root Section</button>
            </td>
            <td width="80%" height="80%" align="center">
                <form:form id="section" commandName="section" method="post">
                    <form:hidden path="id" />
                    <table width="80%" height="80%" align="center">
                        <tr>
                            <td>
                                Section Name:<form:input path="name" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Date(DD-MM-YYY):<form:input path="date"/>
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
                                <form:textarea cssStyle="width: 80%; height: 500px" path="content.body" />
                            </td>
                        </tr>
                    </table>
                    <button style="width: 100px;" type="submit">Submit</button>
                </form:form >
                    <button onclick="document.location.href='/mngt/add?parentId=${section.id}'">Add Section</button>
            </td>
        </tr>
    </table>
    <div class="logout" style="text-align: right">
        <a href="<c:url value="/j_spring_security_logout" />" > Logout </a>
    </div>
</body>
</html>