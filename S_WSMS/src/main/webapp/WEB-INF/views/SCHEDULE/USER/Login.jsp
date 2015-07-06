<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Main Page</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
	function login_form_check() {
		var login_form = document.login_form;

		if (login_form.id.value == "") {
			alert("아이디를 입력하세요");
			login_form.id.focus();
			return false;
		}

		if (login_form.password.value == "") {
			alert("패스워드를 입력하세요");
			login_form.password.focus();
			return false;
		}
		
		$.ajax({
            url : './j_spring_security_check',
            data: $('form input').serialize(),
            type: 'POST',
            dataType : 'json',
            beforeSend: function(xhr) {
                 xhr.setRequestHeader("accept", "application/json");
            }
       }).done(function(body) {

            var message = body.response.message;
            var error = body.response.error;
            if (error) get_msg(message);

            if (error == false) {
                 var url = '${referer}';
                 if (url == '') url = '<c:url value="/Login" />';
                 location.href = url;
            }
       });
	}

    function get_msg(message) {
         var move = '70px';
         jQuery('#message').text(message);
         jQuery('#message').animate({
              top : '+=' + move
         }, 'slow', function() {
              jQuery('#message').delay(1000).animate({ top : '-=' + move }, 'slow');
         });
    }

    
    <c:if test="${error == 'true'}">
	    jQuery(function() {
	         get_msg("로그인 실패하였습니다.");
	    });
	</c:if>
    

    function signin() {
    	$.ajax({
            url : './j_spring_security_check',
            data: $('form input').serialize(),
            type: 'POST',
            dataType : 'json',
            beforeSend: function(xhr) {
                 xhr.setRequestHeader("accept", "application/json");
            }
       }).done(function(body) {

            var message = body.response.message;
            var error = body.response.error;
            if (error) get_msg(message);

            if (error == false) {
                 var url = '${referer}';
                 if (url == '') url = '<c:url value="/Login" />';
                 location.href = url;
            }
       });
    }
    
    function JoinForm() {
    	location.href = '<c:url value="/UserJoinForm" />';
	}
    </script>
</head>
<body>
	<div align="center" class="container">
		<div class="jumbotron" align="center">
			<h1>
				WSMS <br>(Web Schedule Management System)
			</h1>
		</div>
		
		<form class="form-horizontal" role="form"
			action="./j_spring_security_check" method="POST" name="login_form"> 
			<div class="form-group">
				<label class="control-label col-sm-offset-3 col-sm-2" for="ID">ID:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="USER_ID" id="id" placeholder="Enter ID">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-offset-3 col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-3">
					<input type="password" name="USER_PASSWORD" class="form-control" id="password" placeholder="Enter password">
				</div>
			</div>
			
			<div id="message" class="label label-danger"></div>
			
			<div class="form-group">
				<div class="col-sm-offset-5 col-sm-4">
					<button type="button" onclick="login_form_check();"
					 		class="btn btn-default">로그인</button>
					<button type="button" class="btn btn-default" onclick="JoinForm()">회원가입</button>
				</div>
			</div>
			<br>
		</form>
	</div>
</body>
</html>