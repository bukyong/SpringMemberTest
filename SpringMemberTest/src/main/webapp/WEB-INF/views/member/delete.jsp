<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/member/delete.jsp</h1>
	
	<fieldset>
		<legend> 회원 삭제(탈퇴) </legend>
		<form action="" method="post">
			<!-- 아이디 -->
			<input type="hidden" name="userid" value="${sessionScope.id }">
			비밀번호 : <input type="password" name="userpw" placeholder="비밀번호를 입력하시오">
			<input type="submit" value="삭제하기">
		</form>
	</fieldset>

</body>
</html>