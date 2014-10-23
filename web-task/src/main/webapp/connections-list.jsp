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

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <title>Cayetano Web-Task</title>
</head>
<body>


<div id="main_wrapper" style="width: 90%;margin: auto">

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Clients Connections</h3>
        </div>
        <div class="panel-body">

            <div id="filter" style="text-align: left">
                <form role="form" action="between" method="get" style="width: 30%;">
                    <div class="form-group">
                        <input name="startDate" type="text"  class="form-control"  placeholder="Start Date">
                    </div>

                    <div class="form-group">
                        <input name="endDate" type="text" class="form-control"  placeholder="End Date">
                    </div>

                    <input type="submit" class="btn btn-default"/>
                </form>
            </div>
            <div id="connections_table">

                <table class="table">
                    <thead>
                    <tr>
                        <th>Ip:</th>
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
    </div>




</div>
</body>
</html>
