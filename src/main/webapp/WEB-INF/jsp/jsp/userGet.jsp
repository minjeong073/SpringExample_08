<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보</title>
</head>
<body>

	<h2>가장 최근에 등록된 사용자 정보</h2>
	
	<table>
		<tr>
			<th> 이름 </th>
			<th>생년월일</th>
		</tr>
		<tr>
			<td> ${user.name}</td>
			<td> ${user.yyyymmdd }</td>
		</tr>
	</table>
</body>
</html>