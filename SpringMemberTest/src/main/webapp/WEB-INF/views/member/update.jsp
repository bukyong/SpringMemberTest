<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/member/update.jsp</h1>
	
	<fieldset>
		<legend>회원정보 수정</legend>
		<form action="" method='post'>
			아이디 : <input type="text" name="userid" value="${resultVO.userid }" readonly> <br>
			비밀번호 : <input type="password" name="userpw"> <br>
			이름 : <input type="text" name="username" value="${resultVO.username }"> <br>
			이메일 : <input type="email" name="useremail" value="${resultVO.useremail }"> <br>
			
			<input type="submit" value="회원수정">
		</form>
	</fieldset>
	
</body>
</html>