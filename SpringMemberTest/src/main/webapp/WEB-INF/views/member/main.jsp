<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member/main.jsp</h1>
	
	<!-- 로그인 정보가 없는 경우 다시 로그인 페이지로 이동(JSTL) -->
	<c:if test="${empty sessionScope.id }">
		<c:redirect url="/member/login"/>
	</c:if>
	
	${sessionScope.id }님 환영합니다 <hr>
	
	<input type="button" value="로그아웃" onclick=" location.href='/member/logout'; ">
	
	<hr>
	<h3><a href="/member/info">회원정보 조회</a></h3>
	
	<hr>
	<h3><a href="/member/update">회원정보 수정</a></h3>
	
</body>
</html>