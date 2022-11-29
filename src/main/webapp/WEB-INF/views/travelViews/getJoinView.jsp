<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="join.do">
		<div>
			아이디: <input type="text" name="id" /><br />
			비밀번호: <input type="password" name="password" /><br />
			비밀번호 확인: <input type="password" name="passwordConfirm" /><br />
			이름: <input type="text" name="name" /><br />
			나이: <input type="text" name="age" /><br />
			성별: <input type="radio" name="gender" value="남">남
			<input type="radio" name="gender" value="여">여
		<input type="submit" value="가입하기" /></div>
	</form>
</body>
</html>