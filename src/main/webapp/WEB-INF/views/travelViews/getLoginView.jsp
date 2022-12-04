<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
	<h2>로그인</h2>
	<form method="post" action="login.do">
		<div class="mb-3">
			<label class="form-label" for="id">아이디</label>
			<input class="form-control" id="id" type="text" name="id"><br />
		</div>
		<div class="mb-3">
			<label class="form-label" for="password">비밀번호</label>
			<input class="form-control" id="password" type="password" name="password">
		</div>
		<button class="btn btn-outline-primary btn-sm" type="submit">로그인</button>
	</form>
</div>
</body>
</html>