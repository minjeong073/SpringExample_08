<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록</title>

<script 
	src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous">
</script>


</head>
<body>
	
	<!-- <form method="get" action="/ajax/user/add" id="userForm"> -->
	
		<label>이름</label> <input type="text" name="name" id="nameInput">
		<label>생년월일</label> <input type="text" name="birthday" id="birthdayInput"> 
		<label>이메일</label> <input type="text" name="email" id="emailInput">
		<button type="submit" id="saveBtn">저장</button>
		<%-- 유효성 검사 - 비어져 있는 경우 --%>
	<!-- </form> -->
	
	<script>
	
		$(document).ready(function() {
		
			// 3. AJAX 
			// form tag 없애고 form 이 해야할 동작을 AJAX 가 수행
			//
			$("#saveBtn").on("click", function() {
				
				let name = $("#nameInput").val();
				let birthDay = $("#birthdayInput").val();
				let email = $("#emailInput").val();
				
				if (name == "") {
					alert("이름을 입력하세요");
					return;
				}
				
				if (birthDay == "") {
					alert("생년월일을 입력하세요");
					return;
				}
				
				if (email == "") {
					alert("이메일을 입력하세요");
					return;
				}
				
				// form
				$.ajax({
					type:"get"
					, url:"/ajax/user/add"
					, data:{"name":name, "birthday":birthDay, "email":email}
					// 성공할 경우 data(resp) 전달
					, success:function(data) {
						
						// js 기본 문법일 경우에는 json 문자열 String 형태이지만
						// ajax 는 String 을 받아서 json 형태를 인식해서 data 객체 형태로 가져옴
						// -> data.key값 형태로 value 값 가져옴
						if (data.result == "success") { // insert 성공할 경우
							location.href = "/ajax/user/list";
						} else { // data.result == "fail" (insert 실패할 경우)
							// error 와 alert 구분하기
							alert("저장 실패");
						}
					
					}
					, error:function() {
						alert("저장 에러");	
						
					}
				});
					
			});
				
			
			
			
			// 버튼 눌렀을 때 비어있는 경우 error 창 띄움
			// id 는 # , class 는 . , tag 는 없음
			// on(event 이름, 수행될 function)
			
			// $("#saveBtn").on("click", function() { });
				
			/* 
			$("#userForm").on("submit", function() {
			
				// input 하나씩 가져와서 확인
				let name = $("#nameInput").val();
				let birthDay = $("#birthdayInput").val();
				let email = $("#emailInput").val();
				
				if (name == "") {
					alert("이름을 입력하세요");
					return false;
				}
				
				if (birthDay == "") {
					alert("생년월일을 입력하세요");
					return false;
				}
				
				if (email == "") {
					alert("이메일을 입력하세요");
					return false;
				}
				
				// validation 일어나서 return; 이 된 후
				// form : action 주소로 이동시킴 -> 비어있어도 그 상태로 list 보여짐
				// form 일 때 잡아야 할 이벤트 : submit (button click 이 아님)
				// -> form tag 에 id 부여한 후 return 에 중단될 경우 동작을 정해줘야함
				// 중단될 경우 action page 로 넘어가지 않게 : return false;
				
			});	
			*/
			
		});
		
	</script>
	
</body>
</html>