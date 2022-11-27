<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
	 	<title>회원가입</title>
	</head>
	<style>
	 .msg {
      height: 30px;
      text-align:center;
      font-size:16px;
      color:red;
      margin-bottom: 20px;
        }
	</style>
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
									<label for="mobile">휴대폰     </label><input type="text" id="mobile" name="mobile" />
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
			  <script>
      				 function formCheck(form) {
        			    let msg ='';
        			 if(form.id.value.length<3) {
         		       setMessage('id의 길이는 3이상이어야 합니다.', form.id);
               		  return false;
          		     }
     			      return true;
    			     }
  			  </script>
			</section>
			<hr />
		</div>
	</body>
</html>