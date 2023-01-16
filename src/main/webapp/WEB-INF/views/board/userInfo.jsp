<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보 확인</title>
</head>
	<body>
	<header>
	<h1> 회원 가입 정보 확인</h1>
</header>
	<h1>id=${userVo.id}</h1>
	<h1>pwd=${userVo.pwd}</h1>
	<h1>name=${userVo.name}</h1>
	<h1>email=${userVo.email}</h1>
	<h1>birth=${userVo.birth}</h1>
	<h1>address=${userVo.address}</h1>
	<h1>mobile=${userVo.mobile}</h1>
	</body>
<div id="menu" style="text-align:left;">
		<ul>
		    <a href="/board/">Home</a>
		    <a href="/board/boardAll">BoardAll</a>
		    <a href="<c:url value='/board/freeBoard'/>">자유게시판</a>
		    <a href="<c:url value='/board/javaBoard'/>">Java</a>
		    <a href="<c:url value='/board/sqlBoard'/>">Sql</a>
		    <a href="<c:url value='/board/reviewBoard'/>">복습</a>
		</ul>
		
		</div>
</html>