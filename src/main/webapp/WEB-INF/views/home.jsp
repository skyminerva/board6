<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<a href="/board/boardAll"> 게시판 리스트 화면으로</a>
</body>
</html>
