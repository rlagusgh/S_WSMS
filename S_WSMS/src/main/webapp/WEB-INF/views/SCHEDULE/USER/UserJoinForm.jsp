<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입폼</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var bCheck_id = false;

	function check_form(){
		var User_form = document.User_form;
		
		if(User_form.id.value==""){
			alert("아이디를 입력하세요")
			User_form.id.focus();
			return false;
		}
		if(User_form.name.value==""){
			alert("이름을 입력하세요");
			User_form.name.focus();
			return false;
		}
		if(User_form.password.value==""){
			alert("비밀번호를 입력하세요");
			User_form.password.focus();
			return false;
		}
		if(User_form.email.value==""){
			alert("이메일을 입력하세요");
			User_form.email.focus();
			return false;
		}
		
		return true;
	}
	
	function check_id(getId){
		if(getId.id.value==""){
			alert("아이디를 입력하세요");
			return;
		}
		
		url = "CheckUserId?USER_ID="+getId.id.value;
		
		window.open(url,"CheckUserId","width=310,height=120");
		
	}
</script>
</head>
<body>
	<div align="center" class="container">
	<div class="jumbotron" align="center">
		<h1>WSMS <br>(Web Schedule Management System)</h1>
	</div>
	<h3>회원가입</h3>
	<form class="form-horizontal" role="form" action="UserJoin" 
	method="post" name="User_form" onsubmit="return check_form()">
		<div class="form-group">
			<label for="ID" class="control-label col-sm-offset-2 col-sm-2">ID:</label>
			<div class="col-sm-3">
				<input type="text" name="USER_ID" id="id" class="form-control">
			</div>
			<div class="col-sm-1">
			<button type="button" OnClick="check_id(this.form)" class="btn btn-primary btn-sm">ID중복검사</button>
			</div>
		</div>
		<div class="form-group">
			<label for="NAME" class="control-label col-sm-offset-2 col-sm-2">NAME:</label>
			<div class="col-sm-3">
				<input type="text" name="USER_NAME" id="name" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label for="PASSWORD" class="control-label col-sm-offset-2 col-sm-2">PASSWORD:</label>
			<div class="col-sm-3">
				<input type="password" name="USER_PASSWORD" id="password" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label for="EMAIL" class="control-label col-sm-offset-2 col-sm-2">EMAIL:</label>
			<div class="col-sm-3">
				<input type="text" name="USER_EMAIL" id="email" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-5">
			<input type="submit" class="btn btn-default" value="회원가입">
			</div>
		</div>
		</form>
	</div>
</body>
</html>