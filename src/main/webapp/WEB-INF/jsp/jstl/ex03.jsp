<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl Core 라이브러리 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- jstl Format 라이브러리 -->    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL format 라이브러리</title>
</head>
<body>

	<h2>JSTL fmt</h2>
	
	<c:set var="number" value="123456789" />
	
	<h3>숫자 출력</h3>
	<h4><fmt:formatNumber value="${number }" /></h4>
	<%-- 출력 : 123,456,789 --%>
		
	<h3>type</h3>
	<%-- 쉼표 있음 위와 같은 형식 --%>
	<h4><fmt:formatNumber value="${number }" type="number" groupingUsed="true" /></h4>
	<%-- 쉼표 없음 --%>
	<h4><fmt:formatNumber value="${number }" type="number" groupingUsed="false" /></h4>
	
	<h3>percent</h3>
	<h4><fmt:formatNumber value="0.35" type="percent" /></h4>
	<%-- 출력 : 35% --%>
	<h4><fmt:formatNumber value="1" type="percent" /></h4>
	<%-- 출력 : 100% --%>
	<h4><fmt:formatNumber value="${3 / 5 }" type="percent" /></h4>
	<%-- 출력 : 60% --%>
	
	<hr>
	
	<h3>통화</h3>
	<%-- 컴퓨터 설정에 따라 통화가 정해짐 --%>
	
	<h4><fmt:formatNumber value="${number }" type="currency" /></h4>
	<%-- 출력 : \123,456,789 --%>
	<h4><fmt:formatNumber value="${number }" type="currency" currencySymbol="$"/></h4>
	<%-- 출력 : $123,456,789 --%>
	
	<hr>
	
	<%-- 바로 출력하지 않고 변수에 먼저 저장한 후 나중에 출력 --%>
	<h3>포맷팅 저장</h3>
	<h4><fmt:formatNumber value="${number }" type="currency" currencySymbol="$" var="dollar" /></h4>
	<h4>포맷팅 저장 출력 : ${dollar }</h4>
	
	<hr>
	
	<h3>숫자 패턴</h3>
	<c:set var="pi" value="3.1415926535" />
	
	<h4><fmt:formatNumber value="${pi }" /></h4>
	<%-- 출력 : 3.142 (자동으로 반올림해서 소숫점 3자리까지 반올림) --%>
	<h4><fmt:formatNumber value="${pi }" pattern="#.##"/></h4>
	<%-- 출력 : 3.14 --%>
	<h4><fmt:formatNumber value="${pi }" pattern="#.##############"/></h4>
	<%-- 출력 : 3.1415926535 (자릿수 넘어가도 나머지 출력하지 않음) --%>
	
	<h4><fmt:formatNumber value="${pi }" pattern="0.00"/></h4>
	<%-- 출력 : 3.14 --%>
	<h4><fmt:formatNumber value="${pi }" pattern="0.0000000000000"/></h4>
	<%-- 출력 : 3.1415926535000 (자릿수 넘어가면 나머지 0 으로 채움) --%>
	
	<hr>

	<h3>날짜 포맷</h3>
	
	<h3>Date 객체를 내가 원하는 형태로 표현</h3>
	<h4>${now }</h4>
	<%-- 출력 : Fri Aug 12 18:17:49 KST 2022 --%>
	<h4><fmt:formatDate value="${now }" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/></h4>
	<%-- 출력 : 2022년 08월 12일 18시 17분 49초 --%>
	
	<%-- dateString = "2022/08/12 18:18:20" --%>
	<h4>${dateString }</h4>
	<h3>문자열을 Date 객체로 전환</h3>
	<fmt:parseDate value="${dateString }" pattern="yyyy/MM/dd HH:mm:ss" var="date"></fmt:parseDate>
	<h4>${date }</h4>
	<%-- 출력 : Fri Aug 12 18:18:20 KST 2022 --%>
	<h4><fmt:formatDate value="${date }" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/></h4>
	<%-- 출력 : 2022년 08월 12일 18시 18분 20초 --%>	
	
	
	
	
</body>
</html>