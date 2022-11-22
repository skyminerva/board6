<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>게시물 등록</title>
<style>
table {
	width: 60%;
	border: 1px solid #444444;
	border-collapse: collapse;
}
th {
	border: 1px solid #444444;
	background-color: #eee;
}
td {
	border: 1px solid #444444;
	padding :10px;
}
input {
	border: 1px solid #444444;
	padding :5px;
	font-size:15px;
	height:30px;
	
}
textarea {
	border: 1px solid #444444;
	padding :5px;
	font-size:15px;
}
</style>
</head>
<body>
	<div style="text-align:center">
		<h1>게시물 등록</h1>
		<br/><br/><br/>
		<form action="/board/write" method="POST">
		<table align="center">
		<thead>
			<tr>
				<th>제목</th>
				<td align="left">
					<input type="text" name="title" style="width:98%;">
				</td>
			</tr>
			<tr>
				<th >내용</th>
				<td align="left">
				<textarea rows="15" name="contents" style="width:98%;"></textarea>
				</td>
			</tr>
			<tr>
				<th >작성자명</th>
				<td align="left">
					<input type="text" name="name" style="width:30%;">
				</td>
			</tr>
			</thead>
		</table>
		<br/><br/>
		<input type="submit" value="등록" >
		<input type="button" value="취소" onclick="location.href='/board/list'">
	</div>
	</form>
</body>
</html>