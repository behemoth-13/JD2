<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${sessionScope.LOGIN} (${sessionScope.SURNAME} ${sessionScope.NAME})</title>
</head>
<body>
	<%@include file="../fragments/header.jspf"  %>
	<section class="main_content">
		<div class="container">
			<div class="col-md-8">
				<div class="content-text">
					<div class="blog_item">
						<div class="row">
							<div class="col-md-12">
								<div>
									<h2>${about_profile}</h2>
									<br>
									<br>
									<b>${login}:</b> ${sessionScope.LOGIN}
									<br>
									<br>
									<b>${name}:</b> ${sessionScope.NAME}
									<br>
									<br>
									<b>${surname}:</b> ${sessionScope.SURNAME}
									<br>
									<br>
									<b>${email}:</b> ${sessionScope.EMAIL}
									<br>
									<br>
									<b>${phone}:</b> ${sessionScope.PHONE}
									<br>
									<br>
									<b>${date_creation_profile}:</b> ${sessionScope.USER_CREATION_DATE}
									<br>
									<br>
									<b>${type_profile}:</b>
									<c:if test="${sessionScope.ROLE == 0}">${role_admin}</c:if>
									<c:if test="${sessionScope.ROLE == 1}">${role_user}</c:if>
									<c:if test="${sessionScope.ROLE == 2}">${role_guest}</c:if>
									<c:if test="${sessionScope.ROLE == 3}">${role_manager}</c:if>
									<c:if test="${sessionScope.ROLE == 4}">${role_driver}</c:if>
									<c:if test="${sessionScope.ROLE == 5}">${role_banned_user}</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="../fragments/footer.jspf" %>
</body>
</html>