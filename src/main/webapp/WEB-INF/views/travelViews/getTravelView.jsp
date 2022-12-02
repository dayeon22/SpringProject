<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>선택된 게시판 보기</h2>

<table border="1">
	<tr height="50" align="center">
		<td width="150">번호</td>
		<td colspan=3 width="250">${travel.seq}</td>
	</tr>
	<tr height="50" align="center">
		<td colspan=4 width="250">${travel.title}</td>
	</tr>
	<tr height="50" align="center">
		<td width="100">글작성자</td>
		<td width="250">${travel.writer}</td>
		<td width="100">작성일</td>
		<td width="250">${travel.regdate}</td>
	</tr>
	<tr height="50" align="center">
		<td colspan="4">
			<input type="button" value="수정하기" onclick="location.href='modifyTravel.do?seq=${travel.seq}'" />
			<input type="button" value="삭제하기" onclick="location.href='deleteTravel.do?seq=${travel.seq}'" />
			<input type="button" value="목록보기" onclick="location.href='getTravelList.do'" />
		</td>
	</tr>
	<tr height="300" align="center">
		<td colspan=4 width="250">${travel.content}</td>
	</tr>
</table>

<form action="insertProcComment.do?seq=${travel.seq}" method="post">
<table border="1">
	<tr height="50" align="center">
		<td width="300">
			<input type="text" name="content"> <!-- 이게 travel의 content인지, commen의 content인지 구분이 필요(?) -->
		</td>
		<td width="100">
			<input type="submit" value="등록하기" />
		</td>
	</tr>
</table>
</form>

<table border="1">
	<c:forEach items="${cList}" var="comment">
		<tr height="20">
			<td width="100">${comment.writer}</td>
			<td width="300">
				<input type="button" value="수정하기" onclick="location.href='modifyComment.do?seq=${travel.seq}&commentSeq=${comment.commentSeq}'" />
				<input type="button" value="삭제하기" onclick="location.href='deleteComment.do?seq=${travel.seq}&commentSeq=${comment.commentSeq}'" />
			</td>
		</tr>
		<tr height="40">
			<td colspan="2" width="400">${comment.content}</td>
		</tr>
	</c:forEach>
</table>

</center>
</body>
</html>