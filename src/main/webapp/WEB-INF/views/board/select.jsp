<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- jquery 는 구글에서 찾아서 복사 -->
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>게시판</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='selectForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/board/updateView");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				formObj.attr("action", "/board/delete");
				formObj.attr("method", "post");
				formObj.submit();
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "/board/boardAll";
			})
			$(".commentWriteBtn").on("click", function(){
				var formObj = $("form[name='commentForm']");
				formObj.attr("action", "/board/commentWrite");
				formObj.submit();
			});
			
			//댓글 수정 View
			$(".commentUpdaeBtn").on("click", function(){
				location.href = "/board/commentUpdateView?id=${select.id}"
								+ "&cmtNo="+$(this).attr("data-cmtNo");
			});
		})
			
	</script>
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 게시판 상세
			</nav>
			<hr />
			
			<section id="container">
				<form name="selectForm" role="form" method="post">
					<input type="hidden" id="id" name="id" value="${select.id}" />
				</form>
					<table>
						<tbody>
							<tr>
								<td>
									<label for="id">글 번호</label><input type="text" id="id" name="id" value="${select.id}"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="title" value="${select.title}"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content" name="content"><c:out value="${select.content}" /></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="name">작성자</label><input type="text" id="name" name="name" value="${select.name}" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="regdate">작성날짜</label>
									<fmt:formatDate value="${select.regdate}" pattern="yyyy-MM-dd"/>					
								</td>
							</tr>		
						</tbody>			
					</table>
					<div>
					<!-- user.name과 select.name 이 같을 경우에만 수정 삭제 보여주기 -->
					<c:if test="${sessionScope.user.name == select.name}">
						<button type="submit" class="update_btn">수정</button>
						<button type="submit" class="delete_btn">삭제</button>
					</c:if>
					<button type="submit" class="list_btn">목록</button>	
					<!-- null이 아니므로 로그아웃 버튼과 id 이름 안나오는 것 확인 -->
					<c:if test="${sessionScope.user.id == null}">
						<button onclick="location.href='/board/logout'">로그아웃</button>${sessionScope.user.id} ${sessionScope.user.name}
					</c:if>
					</div>
					
					<!-- 댓글 -->
					<div id="comment">
						<ol class="commentList">
							<c:forEach items="${commentList}" var="commentList">
							<li>
								<p>
									작성자 : ${commentList.commenter}<br />
									작성 날짜 :  <fmt:formatDate value="${commentList.regDate}" pattern="yyyy-MM-dd hh:mm:ss" />
								</p>
								<p>${commentList.comment}</p>
								
								<div>
									<button type="button" class="commentUpdaeBtn" data-rno="${commentList.cmtNo}">수정</button>
								</div>
							</li>
							</c:forEach>   
						</ol>
					</div>
					
					<form name="commentForm" method="post">
						<input type="hidden" id="id" name="id" value="${select.id}" />

					<div>
						<label for="commenter">댓글 작성자</label><input type="text" id="commenter" name="commenter" />
						<br/>
						<label for="comment">댓글 내용</label><input type="text" id="comment" name="comment" />
					</div>
					<div>
						<button type="button" class="commentWriteBtn">작성</button>
					</div>
					</form>
			</section>
			<hr />
		</div>
	</body>
</html>