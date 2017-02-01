<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${cars}</title>
</head>
<body>
<%@include file="../fragments/header.jspf"  %>
<section class="main_content">
    <div class="container">
        <div class="col-md-12">
            <div class="content-text">
                    <h2>${cars}</h2>
                <table class="table">
                    <tr>
                        <th>driver_user_id</th>
                        <th>brand id</th>
                        <th>state number</th>
                        <th>status</th>
                        <th>count of km</th>
                    </tr>
                    <c:forEach items="${requestScope.LIST_CARS}" var = "car" >
                    <tr>
                        <td>${car.driversUsersId}</td>
                        <td>${car.brandsOfCarsId}</td>
                        <td>${car.stateNumber}</td>
                        <td>${car.countOfKM}</td>
                        <td>
                            <c:if test="${car.status == 0}">
                                ready
                            </c:if>
                            <c:if test="${car.status == 1}">
                                broken
                            </c:if>
                        </td>
                        </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>
</body>
</html>