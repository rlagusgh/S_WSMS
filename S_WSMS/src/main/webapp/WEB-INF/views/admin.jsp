<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring security</title>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script>
	function getAjax() {
		$.ajax({
			type:"POST",
			url:"Test1",
			dataType:"json",
			data:"",
			success:function (result) {
				$.each(result,function(index,item){
					var output = '';
	
					for(var i=0;i<item.length;i++){
						output += item[i].user_ID;
						output += item[i].user_NAME+'<br>';
					}
					
					
					$("#getTest").html(output);
				});
			}
		});
	}
	
	function getTest() {
		var contents='';
		var array = [
			{name:'naver',link:'http:www.naver.com'},
			{name:'daum',link:'http:www.daum.com'},
			{name:'jobKorea',link:'http:www.jobKorea.com'}
		];
		
		//each
		$.each(array,function(index,item){
			var output='';
			
			output += '<a href="'+item.link+'">';
			output += '<h1>'+item.name+'</h1>';
			output += '</a>'
			
		//
		contents+=output;
		});
		
		$("#getTest").html(contents);
	}
</script>
</head>

<body>
	<div id="getTest"></div>
	
	<button onclick="getAjax()">getAjax</button>
	<button onclick="getTest()">getTest</button>
	
</body>

</html>