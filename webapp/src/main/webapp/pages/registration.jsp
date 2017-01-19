<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %>
<%@include file="../fragments/common.jspf"  %>
<!DOCTYPE html PUBLIC>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${registration_title}</title>
	</head>
	<body>
		<%@include file="../fragments/header.jspf"  %>
		<script type="text/javascript" src="js/validationRegistration.js"></script>
			<div class="container">
				<div class="col-md-12">
					<div class="row" align="center">
						<div class="row">
							<h2>${registration}</h2>
		
							<form action="Controller" method="post">
							
							    ${name} <input type="text" maxlength="15" name="un" id="nameForm" onKeyUp="check('name')"><p id="name" style="color: #FF3D3D">
							    ${val_name_surname}</p>
							    ${surname} <input type="text" maxlength="15" name="us" id="surnameForm" onKeyUp="check('surname')">
							    <p id="surname" style="color:#FF3D3D">
							    ${val_name_surname}</p>
							    <br>
							    
								${login} <input type="text" maxlength="15" name="ul" id="loginForm" onKeyUp="check('login')">
								<p id="login" style="color:#FF3D3D">${val_login}</p>
								<br>
								
								${email} <input type="text" name="ue" id="emailForm" onKeyUp="check('email')">
								<p id="email" style="color:#FF3D3D">${val_email}</p>
								<br>
								
								${phone} <input type="text" name="up" id="phoneForm" onKeyUp="check('phone')">
								<p id="phone" style="color:#2bc6a4">${val_phone}</p><br>
								
								${password} <input type="password" maxlength="15" name="ua" id="passwordForm" onKeyUp="check('password')" >
								<p id="password" style="color:#FF3D3D">${val_password}</p>
								<br>
								<button class="button" name="cm" value="ur" type="submit">${register_button}</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		<%@include file="../fragments/footer.jspf" %>
	</body>
</html>