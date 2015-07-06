<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function setId() {
		opener.document.User_form.id.value="${USER_ID}";
		self.close();
	}
	
	function check_id() {
		if(check_id_form.id.value==""){
			alert("아이디를 입력하세요");
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
	@media (max-width: @screen-xs-max) { ... }
</style>
</head>
<body>
	<div class="container-fluid">
	<c:choose>
		<c:when test="${bCheck_id == 1 }">
			<b><span class="label label-warning">${USER_ID }</span>는 이미 사용중인 아이디입니다.</b>
			<form name="check_id_form" method="GET" action="CheckUserId"
			class="form-inline" role="form-horizontal" onsubmit="return check_id()">
				<input type="text" name="USER_ID">
				<input type="submit" value="ID중복검사" class="btn btn-primary btn-xs">
			</form>
		</c:when>
		<c:otherwise>
			<b>입력하신 <span class="label label-success">${USER_ID }</span>는<br>
			사용하실수 있는 ID입니다.</b><br /><br />
			<button onclick="setId()">닫기</button>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>