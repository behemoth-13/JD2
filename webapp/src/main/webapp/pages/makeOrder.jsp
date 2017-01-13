<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf"%> <!-- localization -->
<%@include file="../fragments/common.jspf"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${makeOrder_title}</title>
</head>
<body>
	<%@include file="../fragments/header.jspf"  %>
	<script type="text/javascript" src="js/validationOrder.js"></script>
			<div class="container">
				<div class="col-md-12">
					<div class="row" align="center">
						<div class="row">
							<h2>${data_order}</h2>

							<form action="Controller" method="post">
							
							    ${weight} <input type="text" maxlength="15" name="ow" id="weightForm" onKeyUp="check('weight')">
							    <p id="weight" style="color: #2BC6A4">${val_weight}</p>
							    <br>
							    
							    ${capacity} <input type="text" maxlength="15" name="oc" id="capacityForm" onKeyUp="check('capacity')">
							    <p id="capacity" style="color: #2BC6A4">${val_capacity}<sup>3</sup></p>
							    <br>
							    
							    ${distance} <input type="text" maxlength="15" name="od" id="distanceForm" onKeyUp="check('distance')">
							    <p id="distance" style="color: #FF3D3D">${val_distance}</p>
							    <br>
								
								<button class="button" name="cm" value="oa" type="submit">${make_order_button}</button>
							</form>
						</div>
					</div>
				</div>
			</div>
	<%@include file="../fragments/footer.jspf" %>
</body>
</html>