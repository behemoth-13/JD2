<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<!-- %@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>${index_title}</title>
</head>
<body>
	<div align="center">
		<%@include file="../fragments/localeButton.jspf"  %>
		<br>
		<%@include file="../fragments/login.jspf" %>
		<br>
	
		<button name="makeorder">${make_order}</button><br>
		<br>
		<button name="autopark">${autopark}</button><br>
		<br>
		<form action="about">
		<button>${prices}</button>
		</form>
		<br>
		<br>
		<form action="about">
			<button>${about}</button>
		</form>
		<br>
		<br>
	</div>
</body>
</html>