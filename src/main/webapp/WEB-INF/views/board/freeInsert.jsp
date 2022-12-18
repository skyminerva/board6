<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
	 	<title>게시판</title>
	</head>
	<body>
	
		<div id="root">
			<header>
				<h1> 자유 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			 자유게시판 - 글 작성
			</nav>
			<hr />
			
			<section id="container">
				<form action="/board/freeInsert" method="post" onsubmit="return formCheck(this);">
				     <div id="msg">
					</div>
					<table>
						<tbody>
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="title" value=""/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content" name="content" ></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="name">작성자</label><input type="text" id="name" name="name" value="${sessionScope.user.name}" readonly="readonly"/>
								</td>
							<tr>
								<td>						
									<button type="submit">작성</button>
									<button onclick ="location.href='/board/freeBoard'">자유게시판</button>
									<c:if test="${sessionScope.user.id != null}">
										<button onclick ="location.href='/board/logout'">로그아웃</button>
									</c:if>
								</td>
							</tr>			
						</tbody>			
					</table>
					<script>
       			     function formCheck(frm) {
        			         let msg ='';
     
        			         if(frm.title.value.length < 2) {
           			          setMessage('제목은 2자리 이상을 입력해주세요.', frm.title);
       			            return false;
        			         }
     
       			          if(frm.name.value.length==0) {
       			              setMessage('이름을 입력해주세요.', frm.name);
       			              return false;
      			           }
                
			                 return true;
			            }
    			 		<!-- 폼체크해서 if 문에 따라서 메세지 선택 -->
   			         function setMessage(msg, element){
     			            document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
     
    			             if(element) {
     			                element.select();
     			            }
      			      }
      			  </script>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>