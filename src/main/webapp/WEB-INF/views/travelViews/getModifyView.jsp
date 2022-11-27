<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>선택된 게시판 수정하기</h2>
<form action="modifyProcTravel.do?seq=${travel.seq}" method="post">
	<table border="1">
		<tr height="50" align="center">
			<td width="150">번호</td>
			<td width="250">${travel.seq}</td>
		</tr>
		<tr height="50" align="center">
			<td width="150">글제목</td>
			<td width="250">
				<input type="text" value="${travel.title}" name="title">
			</td>
		</tr>
		<tr height="50" align="center">
			<td width="150">글작성자</td>
			<td width="250">${travel.writer}</td>
		</tr>
		<tr height="50" align="center">
			<td width="150">글내용</td>
			<td width="250">
				<input type="text" value="${travel.content}" name="content">
			</td>
		</tr>
		<tr height="50" align="center">
			<td colspan="2">
				<input type="submit" value="수정하기" />
				<input type="button" value="목록보기" onclick="location.href='getTravelList.do'" />
			</td>
		</tr>
	</table>
</form>
</center>
</body>
</html>