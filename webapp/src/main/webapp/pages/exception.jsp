<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${exception_title}</title>
</head>
<body>
	<%@include file="../fragments/header.jspf"  %>
		произошла следующая ошибка
	
	<h2>${EXCEPTION}</h2><br>
	<form action="main" method="get">
	<button class="button" type="submit">На главную</button>
	</form>
	<%@include file="../fragments/footer.jspf" %>
</body>
</html>