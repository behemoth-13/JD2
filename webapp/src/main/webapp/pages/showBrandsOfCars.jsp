<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>!Марки машин</title>
</head>
<body>
<%@include file="../fragments/header.jspf"  %>
<section class="main_content">
    <div class="container">
        <div class="col-md-12">
            <div class="content-text">
                <h2>!Марки машин</h2>
                <form action="Controller" method="get">
                    <button name="cm" value="bg" type="submit">заказы</button>
                </form>
                <table class="table">
                    <tr>
                        <th>id</th>
                        <th>название</th>
                        <th>грузоподъёмность</th>
                        <th>объём</th>
                        <th>цена в км</th>
                    </tr>
                    <c:forEach items="${requestScope.LIST_BRANDS_OF_CARS}" var = "brand_of_car" >
                    <tr>
                        <td>${brand_of_car.id}</td>
                        <td>${brand_of_car.name}</td>
                        <td>${brand_of_car.loadingCapacity}</td>
                        <td>${brand_of_car.capacity}</td>
                        <td>${brand_of_car.costPerKM}</td>
                    </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </div>
</section>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>