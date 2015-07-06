<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="ScheduleFunction" prefix="DAY"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		window.onload = function(){
			var sc = document.schedule;
			sc.title.value = "${WEEK.title}"
			sc.day.value = ${WEEK.day}
			sc.start_time.value = ${WEEK.start_time};
			sc.end_time.value = ${WEEK.end_time};
			sc.class_room.value = "${WEEK.class_room}";
			sc.contents.value = "${WEEK.contents}";
			sc.color.value = "${WEEK.color}";
		}
		
		var overlap = "${overlap}";
		
		if(overlap=="true"){
			alert("시간표가 중복됩니다.");
		}
	</script>
</head>
<body>
	<c:set var="time" value="8" />
	<c:set var="minute" value=":00" />
	
	<form action="scheduleMod" method="GET" name="schedule" >
		<input type="hidden" name="now_day" value="${WEEK.day }"/>
		<input type="hidden" name="now_start_time" value="${WEEK.start_time }" />
		<input type="hidden" name="now_end_time" value="${WEEK.end_time }" />
		과목: <input type="text" name="title"><br>
		요일:<select name="day">
				<c:forEach var="i" begin="1" end="7">
					<option value="${i }">${DAY:DayKor(i)}</option>
				</c:forEach>
			</select><br>
		수업시간:<select name="start_time">			
					<c:forEach var="i" begin="1" end="25">
						<c:choose>
							<c:when test="${i%2==0 }">
								<c:set var="minute" value=":30"/>
							</c:when>
							<c:otherwise>
								<c:set var="minute" value=":00" />
								<c:set var="time" value="${time+1 }"/>
							</c:otherwise>
						</c:choose>
						<option value="${i}">${time}${minute}</option>
					</c:forEach>
				</select>~
				<c:set var="time" value="8"/>
				<select name="end_time">
					<c:forEach var="i" begin="1" end="24">
						<c:choose>
							<c:when test="${i%2==0 }">
								<c:set var="minute" value=":30"/>
							</c:when>
							<c:otherwise>
								<c:set var="minute" value=":00" />
								<c:set var="time" value="${time+1 }"/>
							</c:otherwise>
						</c:choose>
						<option value="${i}">${time}${minute}</option>
					</c:forEach>
				</select><br>
		강의실: <input type="text" name="class_room"><br>
		내용:<input type="text" name="contents"><br>
		표시색상:<select name="color">
					<option value="#FFA7A7">빨간색</option>
					<option value="#FFD9EC">분홍색</option>
					<option value="#4374D9">파랑색</option>
					<option value="#D4F4FA">하늘색</option>
					<option value="#FFE400">노란색</option>
					<option value="#A6A6A6">회색</option>
					<option value="#CEFBC9">초록색</option>
			    </select>
		<input type="submit" value="등록">
	</form>
</body>
</html>