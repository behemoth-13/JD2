<<%@ page language="java" contentType="text/html; charset=utf-8"
          pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<!DOCTYPE html PUBLIC >
<html>
<head>
    <title>!добавление новой марки машины</title>
</head>
<body>
<%@include file="../fragments/header.jspf"  %>
<script type="text/javascript" src="js/validationRegistration.js"></script>
<div class="container">
    <div class="col-md-12">
        <div class="row" align="center">
            <div class="row">
                <h2>!добавление</h2>

                <form action="Controller" method="post">

                    <!-- ${surname} <input type="text" maxlength="15" name="us" id="surnameForm" onKeyUp="check('surname')">
                    <p id="surname" style="color:#FF3D3D">${val_name_surname}</p>
                    <br>-->
                    название марки <input type="text" maxlength="15" name="bn">
                    <br>
                    грузоподъёмность <input type="text" maxlength="15" name="bl">
                    <br>
                    объем <input type="text" maxlength="15" name="bc">
                    <br>
                    цена в км <input type="text" name="bp">
                    <br>
                    <button class="button" name="cm" value="ba" type="submit">добавить</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>
