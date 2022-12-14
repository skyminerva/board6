<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  밑에는 마이바티스에서 가져온 시간 </P>
<P>  The time on the server(sql.date) is ${selectNow}. </P>

	<div id="menu">
		<ul>
	
		    <li><a href="<c:url value='/board/'/>">Home</a></li>
		    <li><a href="<c:url value='/board/boardAll'/>">BoardAll</a></li>
		    <li><a href="<c:url value='/board/java'/>">Java</a></li>
		    <li><a href="<c:url value='/board/sql'/>">Sql</a></li>
		    <li><a href="<c:url value='/board/logout'/>">로그아웃</a></li>    
		    <li><a href="<c:url value='/board/userAdd'/>">회원가입</a></li>
		</ul> 
	</div>
<a href="/board/boardAll"> 게시판 리스트 화면으로</a>
</body>
</html>
