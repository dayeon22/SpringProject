<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="login.do">
		<div>
			아이디: <input type="text" name="id" />
			비밀번호: <input type="password" name="password" />
		</div>
		<div><input type="submit" value="로그인" /></div>
		아이디 기억하기 <input type="checkbox" name="rememberMe" />
	</form>
</body>
</html>