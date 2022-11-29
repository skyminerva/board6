<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Login view</title>
</head>
<body>
   <form action="/board/loginView" method="post" onsubmit="return formCheck(this);">
        <h3 id="title">Login</h3>
        <div id="msg">
		</div>
		<table>
			<tr>
				<td>
					<label>ID</label></br>
					<input type="text" name="id" value="" placeholder="id 입력" >
   			    </td>
    	    </tr>
    	    <tr>
     		    <td>
     		    	<label>PASSWORD</label></br>
			        <input type="password" name="pwd" value = "" placeholder="비밀번호">
				</td>
			</tr>
        <td>
        <button>로그인</button>
        </td>
        </table>
        <script>
            function formCheck(frm) {
                 let msg ='';
     
                 if(frm.id.value.length==0) {
                     setMessage('id를 입력해주세요.', frm.id);
                     return false;
                 }
     
                 if(frm.pwd.value.length==0) {
                     setMessage('password를 입력해주세요.', frm.pwd);
                     return false;
                 }
                 return true;
            }
     		<!-- 폼체크해서 if 문에 id, pwd에 따라서 메세지 선택 -->
            function setMessage(msg, element){
                 document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
     
                 if(element) {
                     element.select();
                 }
            }
        </script>
    </form>
</body>
</html>