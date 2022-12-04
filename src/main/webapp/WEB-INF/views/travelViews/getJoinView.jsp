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
			alert('비밀번호를 확인해 주세요.');
		} else{
			document.getElementById('join').submit();
		}
	}
</script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	
	<br />
	<div class="container">
		<h2>회원가입</h2>
		<form id="join" method="post" action="join.do">
			<div class="mb-3">
				<label class="form-label" for="input_id">아이디</label>
				<input class="form-control" id="input_id" type="text" name="id"><br />
			</div>
			<div class="mb-3">
				<label class="form-label" for="input_pw">비밀번호</label>
				<input class="form-control" id="input_pw" type="password" name="password"><br />
			</div>
			<div class="mb-3">
				<label class="form-label" for="input_pwc">비밀번호 확인</label>
				<input class="form-control" id="input_pwc" type="password" name="passwordConfirm"><br />
			</div>
			<div class="mb-3">
				<label class="form-label" for="input_name">이름</label>
				<input class="form-control" id="input_name" type="text" name="name"><br />
			</div>
			<div class="mb-3">
				<label class="form-label" for="input_age">나이</label>
				<input class="form-control" id="input_age" type="text" name="age"><br />
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" id="input_g_m" type="radio" name="gender" value="남">
				<label class="form-check-label" for="input_g_m">남</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" id="input_g_f" type="radio" name="gender" value="여">
				<label class="form-check-label" for="input_g_f">여</label>
			</div>
			
			<input type="button" value="가입하기" onclick="valid_ck()" />
			
		</form>
	</div>
</body>
</html>