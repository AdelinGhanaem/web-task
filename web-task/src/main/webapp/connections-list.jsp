<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adelin
  Date: 14-10-22
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>


<div id="main_wrapper">
    <div id="filter">
        <form action="between" method="get">
            <input name="startDate" type="text"/>
            <input name="endDate" type="text"/>
            <input type="submit"/>
        </form>
    </div>
    <div id="connections_table">

        <table>
            <thead>
            <tr>
                <th>Id:</th>
                <th>Client Agent Details</th>
                <th>Connection Time</th>
            </tr>
            </thead>

            <c:forEach var="connection" items="${connections}">
                <tr>
                    <td>${connection.connectionSource}</td>
                    <td>${connection.clientAgent}</td>
                    <td>${connection.connectionTime}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>
</html>
