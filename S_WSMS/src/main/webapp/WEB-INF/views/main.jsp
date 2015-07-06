<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>웹 프로그래머 김현호 포트폴리오</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="Stylesheet" href="resources/font/UhBeeSe_hyun.css" />
<link rel="Stylesheet" href="resources/css/main.css" />
</head>
<body>
	<div class="container" id="container">
		<img alt="" src="resources/image/main_title.png">
		<ul class="list-inline text-right" style="font-size: 15px; color: #FFFFFF;" id="UnBee_font">
			<li><a href="#About">About</a></li>
			<li><a href="#Portpolio">Portpolio</a></li>
			<li><a href="#Contact">Contact</a></li>
		</ul>

		<div align="center">
		<a name="About"></a>		
		<div class="panel panel-default" id="panel">
			<div class="panel-heading" id="UnBee_font"><h4>About Me</h4></div>
			<div class="panel-body">
				<div id="contents">
					<section id="picture">
						<img src="resources/image/me.jpg" class="img-thumbnail" alt="" width="200">
					</section>
					<aside id="intro">
						<div class="well" align="left">
						<strong>이름</strong>	김현호<br>
						<strong>생년월일</strong>	1990년 6월 28일<br>
						<strong>학 교</strong>	동국대학교 경주 (8월 졸업예정)<br>
						<strong>학 과</strong>	컴퓨터 공학과<br>
						<strong>전 공</strong>	Databaase&Web<br>
						<strong>사는곳</strong>	경기도 고양시 일산동구 백석동<br>
						<strong>연락처</strong>	010-3344-5343 <br>
						<strong>이메일 주소</strong>	kimnx9006@naver.com<br>
						<br><br><br>
						</div>
					</aside>
				</div> 
			</div>
		</div>	<!-- panel -->
		
		<a name="Portpolio"></a>
		<h2 id="UnBee_font">Portpolio</h2>
		<div class="panel-group" id="panel">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h4>웹 스케줄 관리 시스템</h4>
				</div>
				<div class="panel-body">
					<div id="contents">
						<section id="picture">
							<a href="schedule"><img src="resources/image/SPMS_MAIN.jpg" class="img-thumbnail" alt=""></a>
						</section>
						<aside id="intro">
							<div class="well" align="left">
							<h4><a href="schedule">WSMS<br>(Web Schedule Management System)</a></h4>
							웹에서 스케줄관리할수 있게해주는 웹 어플리케이션입니다.<br>
							<strong>개발툴</strong> Spring Tool Suite & MYSQL Workbench<br>
							<strong>개발 언어</strong> JAVA,JSP,JSTL,EL,HTML5<br>
							<strong>핵심 기능</strong> 스프링 프레임워크, Mybatis,MVC,로그인/로그아웃<br>
							<!-- 상세 설명 page -->
							</div>
						</aside>
					</div> 
				</div>
			</div>
			
			<div class="panel panel-info">
				<div class="panel-heading">Panel with panel-info class</div>
				<div class="panel-body">
					<div id="contents">
						<section id="picture">
						</section>
						<aside id="intro">
							<div class="well" align="left">
							</div>
						</aside>
					</div> 
				</div>
			</div>
				
			<div class="panel panel-info">
				<div class="panel-heading">Panel with panel-info class</div>
				<div class="panel-body">
					<div id="contents">
						<section id="picture">
						</section>
						<aside id="intro">
							<div class="well" align="left">
							</div>
						</aside>
					</div> 
				</div>
			</div>
				
			<div class="panel panel-info">
				<div class="panel-heading">Panel with panel-info class</div>
				<div class="panel-body">
					<div id="contents">
						<section id="picture">
						</section>
						<aside id="intro">
							<div class="well" align="left">
							</div>
						</aside>
					</div> 
				</div>
			</div>
		</div>	<!-- panel gourp -->
		
			
		</div>	<!-- center -->
		<jsp:include page="footer.jsp" />
	</div><!-- Container -->
</body>
</html>
