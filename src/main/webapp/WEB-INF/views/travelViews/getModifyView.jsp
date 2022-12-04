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
<br />
<div class="container">
<h2>글 수정하기</h2>
<form action="modifyProcTravel.do?seq=${travel.seq}" method="post">
	<table class="table table-bordered">
		<tr height="50" align="center">
			<td width="150">번호</td>
			<td colspan=3 width="250">${travel.seq}</td>
		</tr>
		<tr height="50" align="center">
			<td width="150">글제목</td>
			<td width="250">
				<input type="text" value="${travel.title}" name="title">
			</td>
		</tr>
		<tr height="50" align="center">
			<td width="100">글작성자</td>
			<td width="250">${travel.writer}</td>
			<td width="100">작성일</td>
			<td width="250">${travel.regdate}</td>
		</tr>
		<tr height="50" align="center">
			<td colspan="4">
				<input type="submit" value="수정하기" />
				<input type="button" value="목록보기" onclick="location.href='getTravelList.do'" />
			</td>
		</tr>
		<tr height="300" align="center">
			<td colspan=4 width="250"><textarea rows="15" cols="150" name="content">${travel.content}</textarea></td>
		</tr>
	</table>	
</form>
</div>
</body>
</html>