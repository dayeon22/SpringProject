<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function valid_ck() {
		let id = document.getElementById('input_id').value;
		let pw = document.getElementById('input_pw').value;
		let pwc = document.getElementById('input_pwc').value;
		let name = document.getElementById('input_name').value;
		let age = document.getElementById('input_age').value;
		
		if(id == '' || pw == '' || pwc == '' || name == '' || age == ''){
			alert('모든 항목을 입력해 주세요.');
		} else if (pw != pwc) {
			alert('비밀번호를 확인해 주세요.')
		}
		else{
			document.join.submit();
		}
	}
</script>
</head>
<body>
	<form name="join" method="post" action="join.do">
		<div>
			아이디: <input type="text" name="id" id="input_id"/><br />
			비밀번호: <input type="password" name="password" id="input_pw"/><br />
			비밀번호 확인: <input type="password" name="passwordConfirm" id="input_pwc"/><br />
			이름: <input type="text" name="name" id="input_name"/><br />
			나이: <input type="text" name="age" id="input_age"/><br />
			성별: <input type="radio" name="gender" value="남">남
			<input type="radio" name="gender" value="여">여
		<input type="button" value="가입하기" onclick="valid_ck()"/></div>
	</form>
</body>
</html>