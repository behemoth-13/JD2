<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf"%> <!-- localization -->
<%@include file="../fragments/common.jspf"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${success_title}</title>
</head>
<body>
<%@include file="../fragments/header.jspf"%>
<section class="main_content">
	<div class="row">
		<div class="col-md-12">
			<div>
				<h2>${about_profile}</h2>
			</div>
		</div>
	</div>
</section>
<%@include file="../fragments/footer.jspf"%>
</body>
</html>