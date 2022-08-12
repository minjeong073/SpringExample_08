<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl Core 라이브러리 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 라이브러리</title>
</head>
<body>

	<h2>조건 if else</h2>
	
	<%-- 직접적으로 변수 설정하지 않고 controller 에서 가져오기 때문에 
	controller.java 에 Model 객체로 가져옴 --%>

	<%-- 몸무게가 70 이하면 치킨 80 이하면 샐러드 그게 아니면 굶는다 --%>

	<c:choose>	
		<%-- if (weight <= 70) --%>	
		<c:when test="${weight <= 70 }">
			<h4>치킨 먹자</h4>
		</c:when>
		
		<%-- else if (weight <= 80) --%>
		<c:when test="${weight <= 80 }">
			<h4>샐러드 먹자</h4>
		</c:when>
		
		<%-- else --%>
		<c:otherwise>
			<h4>그게 아니면 굶는다</h4>
		</c:otherwise>
	</c:choose>
	
	
	<h2>반복문</h2>
	
	<%-- for (int i = 0; i < 5; i++) --%>
	<%-- var : 꺼내진 데이터 변수 명
		 items : 꺼낼 객체 명 (array, list, map ...)  --%>
	
	<c:forEach var="i" begin="0" end="4" step="1">
		${i } 
	</c:forEach>
	<br>
	
	<%-- for (String fruit : fruitList) --%>
	<%-- 지금 반복되는 상태 저장할 변수 : varStatus --%>
	<%-- varStatus.count : 반복 횟수
		 varStatus.index : 위치 
		 varStatus.first : 첫번째 일 경우  true
		 varStatus.last : 마지막일 경우 true --%>
	<c:forEach var="fruit" items="${fruitList }" varStatus="status">
		<h4>${fruit } :::: ${status.count } ${status.index } 
		${status.first } ${status.last }</h4>
	</c:forEach>
	
	
	<%-- List<Map<String, Object>> --%>
	<%-- for (Map<String, Object> user : userList) --%>
	<%-- el tag 에서 멤버변수 명 넣으면 해당하는 값 가져옴 --%>
	<c:forEach var="user" items="${userList }" varStatus="status">
		<h3>${status.count } 번째 사용자 정보</h3>
		<h4>이름 : ${user.name }</h4>
		<h4>나이 : ${user.age }</h4>
		<h4>취미 : ${user.hobby }</h4>
	</c:forEach>
	
	
	<%-- 책 정보 리스트 --%>
	<table border="1">
		<thead>
			<tr>
				<th>제목</th>
				<th>작가</th>
				<th>출판사</th>
			</tr>
		</thead>	
		<tbody>
			<c:forEach var="book" items="${books }">			
				<tr>
					<td>${book.title }</td>
					<td>${book.author }</td>
					<td>${book.publisher }</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	
	
	
</body>
</html>