<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>게시판리스트</title>

<style>
table {
	width: 80%;
	border: 1px solid #444444;
	border-collapse: collapse;
}
th {
	border: 1px solid #444444;
	background-color: #eee;
}
td {
	border: 1px solid #444444;
	padding: 10px;
}
.space {
  width: 800;
  display: inline-block;
}

</style>

</head>
<body>  
	<div style="text-align:center">
		<h1>내맘대로 게시판</h1>
		<br/><br/><br/>
		
		<div id="menu" style="text-align:left;">
		<ul>
		    <a href="/board/">Home</a>
		    <a href="/board/boardAll">BoardAll</a>
		    <a href="<c:url value='/board/freeBoard'/>">자유게시판</a>
		    <a href="<c:url value='/board/java'/>">Java</a>
		    <a href="<c:url value='/board/sql'/>">Sql</a>
		    <a href="<c:url value='/board/review'/>">복습</a>
		</ul>
		
		</div>
		<table align="center">
		<div style="text-align:right; width: 89.5%;"> 
			<button onclick="location.href='/board/'">홈</button>
			<button onclick="location.href='/board/userAdd'">회원 가입</button>
			<button onclick="location.href='/board/loginView'">로그인</button>
			<button onclick="location.href='/board/insert'">게시판 등록</button>
			<!-- 세션에 user 객체가 있으므로 null이 아니므로 로그아웃 버튼과 id name 나오는 것 확인 -->
			<!-- 쿠키로 자동로그인 시에는 세션스코프를 이용한 유저 객체는 가지고 오지 못한다. -->
			<c:if test="${cookie.id.value != null}">
				<button onclick="location.href='/board/logout'">로그아웃</button>${sessionScope.user.id} ${sessionScope.user.name}
				<h2>${cookie.id.name}</h2>
				<h2>${cookie.id.value}</h2>
				<input type="text" name="id" id ="id" value= "${sessionScope.user.id}">
				<input type="text" name="name" id ="name" value= "${sessionScope.user.name}">
			</c:if>
		</div>
		<table align="center">
		<div style="text-align:right; width: 89.5%;">
			<input type="button" value="회원 가입" onclick="location.href='/board/userAdd'">
			<div class = "space">게시글을 작성하려면 회원 가입이 필요합니다. 이런 문구가 들어가면 될 듯</div> 
			<input type="button" value="게시물 등록" onclick="location.href='/board/insert'">
			<br/><br/>
		</div>

		<thead>
			<tr>
				<th >ID</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록일</th>

			</tr>
			</thead>
			<!-- 게시글 리스트 -->
			<c:forEach var="boardAll" items="${boardAll}">
				<tr >
					<td width="10%"><a href="/board/select?id=${boardAll.id}">${boardAll.id}</a></td>
					<td width="10%"><a href="/board/select?id=${boardAll.id}">${boardAll.name}</a></td>
					<td width="30%">${boardAll.title}</td>
					<td width="15%"><fmt:formatDate pattern="yyyy-MM-dd" value="${boardAll.regdate}" /></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>