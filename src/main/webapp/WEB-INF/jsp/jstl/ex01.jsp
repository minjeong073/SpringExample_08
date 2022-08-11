<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl Core 라이브러리 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리</title>
</head>
<body>

	<h2>1. 변수 정의하기</h2>
	
	<!-- int number1 = 100; -->
	<c:set var="number1" value="100" />
	
	<!-- value 값 tag 사이에 넣어도 됨 -->
	<c:set var="number2">200</c:set>
		
	<h4>number1 : ${number1 }</h4>
	<h4>number2 : ${number2 }</h4>
	
	
	<h2>2. 변수 출력하기</h2>
	
	<h4><c:out value="100"/></h4>
	
	<!-- 가능하지만 아래처럼 쓰지는 않음 -->
	<h4><c:out value="${number1 }"/></h4>
	
	<!-- el > jstl 순서로 적용됨 -->
	
	<!-- html 에 포함되면 alert 되어야 정상
		 문자 그대로 출력됨
		 c:out 에 escapeXml="true" (기본) : xml 같은 내용이 그대로 보여지게 하라 
	 -->
	<c:out value="<script>alert('안녕')</script> " />	
	<!-- 같은 표현 -->
	<c:out value="<script>alert('안녕')</script> " escapeXml="true"/>
	
	<!-- tag 가 html 에 포함되어 alert 됨 -->
	<!-- <c:out value="<script>alert('안녕')</script> " escapeXml="false" /> -->		
	
	
	<h2>3. 조건문</h2>
	
	<!-- test="true " 등의 공백 주의! -->
	
	<c:if test="true">
		<h4>조건이 참이다</h4>
	</c:if>
	
	<c:if test="false">
		<h4>조건이 거짓이다</h4>
	</c:if>
	
	<!-- el tag 안에서 간단한 연산을 통해 비교 -->
	<c:if test="${number1 > 50 }">
		<h4>number1 이 50보다 크다</h4>
	</c:if>	
	
	<%-- if (number1 == 100) --%>
	<c:if test="${number1 == 100 }">
		<h4>number1 은 100이다</h4>
	</c:if>
	
	<%-- 같은 표현 --%>
	<c:if test="${number1 eq 100 }">
		<h4>number1 은 100이다</h4>
	</c:if>
	
	<c:if test="${number2 ne 100 }">
		<h4>number2 는 100이 아니다</h4>
	</c:if>
	
	<%-- if (number1 == null) --%>
	<%-- 변수가 없다, 객체가 null, 리스트가 비어있다 - empty 로 확인 가능 --%>
	<c:if test="${empty number1 }">
		<h4>number1 변수가 없다</h4>
	</c:if>
	
	<%-- if (number1 != null) --%>
	<c:if test="${!empty number1 }">
		<h4>number1 변수가 없다</h4>
	</c:if>
	<%-- 같은 표현 --%>
	<c:if test="${not empty number1 }">
		<h4>number1 변수가 없다</h4>
	</c:if>
	
	
	
	
	
</body>
</html>