<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>show Users</title>
</head>
<body>
<%@include file="../fragments/header.jspf"  %>
<section class="main_content">
    <div class="container">
        <div class="col-md-12">
            <div class="content-text">
                <h2>Users</h2>
                <table class="table">
                    <tr>
                        <th>id</th>
                        <th>${login}</th>
                        <th>${name}</th>
                        <th>${surname}</th>
                        <th>${email}</th>
                        <th>${phone}</th>
                        <th>${date_creation_profile}</th>
                        <th>${type_profile}</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${requestScope.LIST_USERS}" var = "user" >
                    <tr>
                        <form action="Controller" method="post">
                            <td>${user.id}</td>
                            <td>${user.login}</td>
                            <td>${user.name}</td>
                            <td>${user.surname}</td>
                            <td>${user.email}</td>
                            <td>${user.phone}</td>
                            <td>${user.creationDate}</td>
                            <td>

                                <c:if test="${user.role == 0}">
                                    <select size="1">
                                    <!--<option disabled>Выберите</option>-->
                                    <option value="1">${role_user}</option>
                                    <option value="2">${role_guest}</option>
                                    <option value="3">${role_manager}</option>
                                    <option value="4">${role_driver}</option>
                                    <option value="5">${role_banned_user}</option>
                                    <option selected value="${user.role}">${role_admin}</option>
                                    </select>
                                </c:if>
                                <c:if test="${user.role == 1}">
                                    <select size="1">
                                        <option value="0">${role_admin}</option>
                                        <option value="2">${role_guest}</option>
                                        <option value="3">${role_manager}</option>
                                        <option value="4">${role_driver}</option>
                                        <option value="5">${role_banned_user}</option>
                                        <option selected value="${user.role}">${role_user}</option>
                                    </select>
                                </c:if>
                                <c:if test="${user.role == 2}">
                                    <select size="1">
                                        <option value="0">${role_admin}</option>
                                        <option value="1">${role_user}</option>
                                        <option value="3">${role_manager}</option>
                                        <option value="4">${role_driver}</option>
                                        <option value="5">${role_banned_user}</option>
                                        <option selected value="${user.role}">${role_guest}</option>
                                    </select>
                                </c:if>
                                <c:if test="${user.role == 3}">
                                    <select size="1">
                                        <option value="0">${role_admin}</option>
                                        <option value="1">${role_user}</option>
                                        <option value="2">${role_guest}</option>
                                        <option value="4">${role_driver}</option>
                                        <option value="5">${role_banned_user}</option>
                                        <option selected value="${user.role}">${role_manager}</option>
                                    </select>
                                </c:if>
                                <c:if test="${user.role == 4}">
                                    <select size="1">
                                        <option value="0">${role_admin}</option>
                                        <option value="1">${role_user}</option>
                                        <option value="2">${role_guest}</option>
                                        <option value="3">${role_manager}</option>
                                        <option value="5">${role_banned_user}</option>
                                        <option selected value="${user.role}">${role_driver}</option>
                                    </select>
                                </c:if>
                                <c:if test="${user.role == 5}">
                                    <select size="1">
                                        <option value="0">${role_admin}</option>
                                        <option value="1">${role_user}</option>
                                        <option value="2">${role_guest}</option>
                                        <option value="3">${role_manager}</option>
                                        <option value="4">${role_driver}</option>
                                        <option selected value="${user.role}">${role_banned_user}</option>
                                    </select>
                                </c:if>
                            </td>
                            <td>
                                <button class="button" name="cm" value="ur" type="submit">${register_button}</button>
                            </td>
                        </form>
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