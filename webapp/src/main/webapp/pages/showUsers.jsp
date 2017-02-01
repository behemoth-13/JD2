<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${users}</title>
</head>
<body>
    <%@include file="../fragments/header.jspf"  %>
    <section class="main_content">
        <div class="container">
            <div class="col-md-12">
                <div class="content-text">
                    <h2>${users}</h2>
                    <table class="table">
                        <tr>
                            <th>id</th>
                            <th>${name}</th>
                            <th>${surname}</th>
                            <th>${login}</th>
                            <th>${email}</th>
                            <th>${phone}</th>
                            <th>${type_profile}</th>
                            <th>${date_creation_profile}</th>
                        </tr>
                        <c:forEach items="${requestScope.LIST_USERS}" var = "user" >
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.surname}</td>
                            <td>${user.login}</td>
                            <td>${user.email}</td>
                            <td>${user.phone}</td>
                            <td>
                                <c:if test="${user.role == 0}">
                                    ${role_admin}
                                </c:if>
                                <c:if test="${user.role == 1}">
                                    ${role_user}
                                </c:if>
                                <c:if test="${user.role == 2}">
                                    ${role_guest}
                                </c:if>
                                <c:if test="${user.role == 3}">
                                    ${role_manager}
                                </c:if>
                                <c:if test="${user.role == 4}">
                                    ${role_driver}
                                </c:if>
                                <c:if test="${user.role == 5}">
                                    ${role_banned_user}
                                </c:if>
                            </td>
                            <td>${user.creationDate}</td>
                            </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </section>
    <%@include file="../fragments/footer.jspf" %>
</body>
</html>