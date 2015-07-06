<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<div align="center" class="container">
		<h1>회원가입 완료</h1>
		<table>
			<tr>
				<td>ID: </td>
				<td>${user.USER_ID}</td>
			</tr>
			<tr>
				<td>이름: </td>
				<td>${user.USER_NAME}</td>
			</tr>
			<tr>
				<td>E-MAIL: </td>
				<td>${user.USER_EMAIL }</td>
			</tr>
			<tr>
				<td>가입일: </td>
				<td>${user.JOIN_DATE }</td>
			</tr>
			<tr>
				<td><a href="schedule"><button>확인</button></a></td>
			<tr>
		</table>
	</div>
</body>
</html>