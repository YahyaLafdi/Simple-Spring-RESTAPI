<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World! FFFFFFFFF" %>
</h1>
<br/>
<table>
    <tr>
        <th> id </th>
        <th> name </th>
        <th> mail </th>
    </tr>
    <c:forEach var="user" items="${customers}">
        <tr>
            <td>
                <c:out value="${user.name}" />
            </td>
            <td>
                <c:out value="${user.username}" />
            </td>
            <td>
                <c:out value="${user.email}" />
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>