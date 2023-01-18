<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	 	<title>회원가입</title>
	</head>
	<body>
	
		<div id="root">
			<header>
				<h1> 회원 가입</h1>
			</header>
			<hr />
			 
			<nav>
			  로그인 - 회원가입
			</nav>
			<hr />
			
			<section id="container">
				<form role="form" method="post" action="/board/userAdd">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="id">아이디        </label><input type="text" id="id" name="id" placeholder="8~12자리의 영어와 숫자 조합"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="password">비밀번호   </label><input type="text" id="pwd" name="pwd" placeholder="8~12자리의 영어와 숫자 조합"/>
								</td>
							</tr>
							<tr>
								<td>
									<label for="name">이름        </label><input type="text" id="name" name="name" />
								</td>
							</tr>	
							<tr>
								<td>
									<label for="Email">Email     </label><input type="text" id="Email" name="Email" />
								</td>
							<tr>
							<tr>
								<td>
									<label for="birth">생년월일     </label><input type="text" id="birth" name="birth" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="address">집주소     </label><input type="text" id="address" name="address" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="addressdetail">상세주소    </label>	<input type="text" name="addressdetail" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="mobile">휴대폰      </label><input type="text" id="mobile" name="mobile" />
								</td>
							</tr>
							
							<tr>
								<td>						
									<button type="submit">회원가입</button>
								</td>
							</tr>			
						</tbody>			
					</table>
				</form>

			</section>
			<hr />
		</div>
	</body>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		window.onload = function(){
			document.getElementById("address").addEventListener("click", function(){ //주소입력칸을 클릭하면
				//카카오 지도 발생
				new daum.Postcode({
					oncomplete: function(data) { //선택시 입력값 세팅
						document.getElementById("address").value = data.address; // 주소 넣기
						document.querySelector("input[name=addressdetail]").focus(); //상세입력 포커싱
					}
				}).open();
			});
		}
</script>
</html>