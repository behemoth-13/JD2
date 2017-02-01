<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<!DOCTYPE html PUBLIC >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>${showOrdersByUserId_title}</title>
</head>
<body>
<%@include file="../fragments/header.jspf"  %>
<section class="main_content">
    <div class="container">
        <div class="col-md-12">
            <div class="content-text">
                <c:if test="${sessionScope.ROLE == 1}">
                    <h2>${your_orders}</h2>
                </c:if>
                <c:if test="${sessionScope.ROLE != 1}">
                    <h2>${orders}</h2>
                </c:if>
                <table class="table">
                    <tr>
                        <c:if test="${sessionScope.ROLE == 0}">
                            <th>id</th>
                        </c:if>
                        <th>${weight}</th>
                        <th>${capacity}</th>
                        <th>${distance}</th>
                        <th>${creation_date}</th>
                        <th>${status_order}</th>
                        <th>${date_status}</th>
                    </tr>
                    <c:forEach items="${requestScope.LIST_ORDERS}" var = "order" >
                    <tr>
                        <c:if test="${sessionScope.ROLE == 0}">
                            <td>${order.id}</td>
                        </c:if>
                        <td>${order.weight}</td>
                        <td>${order.capacity}</td>
                        <td>${order.distance}</td>
                        <td>${order.creationTime}</td>
                        <td>
                            <c:if test="${order.statusOrder == 0}">
                                ${order_has_come}
                            </c:if>
                            <c:if test="${order.statusOrder == 1}">
                                ${order_proceed_disp}
                            </c:if>
                            <c:if test="${order.statusOrder == 2}">
                                ${order_in_work}
                            </c:if>
                            <c:if test="${order.statusOrder == 3}">
                                ${order_completed}
                            </c:if>
                            <c:if test="${order.statusOrder == 4}">
                                ${order_rejected}
                            </c:if>
                        </td>
                        <td>${order.timeStatusOrder}</td>
                        </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>