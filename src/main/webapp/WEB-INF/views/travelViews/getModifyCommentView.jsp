<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
<h2>댓글 수정하기</h2>
<table class="table table-bordered">
	<tr height="50" align="center">
		<td width="150">번호</td>
		<td colspan=3 width="250">${travel.seq}</td>
	</tr>
	<tr height="50" align="center">
		<td width="150">글제목</td>
		<td colspan=4 width="250">${travel.title}</td>
	</tr>
	<tr height="50" align="center">
		<td width="100">글작성자</td>
		<c:choose>
			<c:when test="${empty travel.writer}">
				<td width="250">(탈퇴함)</td>
			</c:when>
			<c:otherwise>
				<td width="250">${travel.writer}</td>
			</c:otherwise>
		</c:choose>
		<td width="100">작성일</td>
		<td width="250">${travel.regdate}</td>
	</tr>
	<tr height="50" align="center">
		<td colspan="4">
			<input type="button" value="목록보기" onclick="location.href='getTravelList.do'" />
		</td>
	</tr>
	<tr height="300" align="center">
		<td colspan=4 width="250">${travel.content}</td>
	</tr>
</table>

<h2>댓글</h2>
<form action="insertProcComment.do?seq=${travel.seq}" method="post">
<table class="table table-bordered">
	<tr height="50" align="center">
		<td width="300">
			<input class="form-control" type="text" name="content">
		</td>
		<td width="100">
			<input type="submit" value="등록하기" />
		</td>
	</tr>
</table>
</form>

<form action="modifyProcComment.do?commentSeq=${cdo.commentSeq}&seq=${travel.seq}" method="post">
	<table class="table table-striped">
		<c:forEach items="${cList}" var="comment">
			<c:set var="seq1" value="${comment.commentSeq}" />
			<c:set var="seq2" value="${cdo.commentSeq}" />
				
			<c:if test="${seq1 eq seq2}">
				<tr height="20">
					<td width="200">${comment.writer}</td>
					<td width="100">${comment.regdate}</td>
					<td width="100">
						<input type="submit" value="수정하기">
					</td>
				</tr>
				<tr height="40">
					<td colspan="3" width="400"><input class="form-control" type="text" value="${comment.content}" name="content" /></td>
				</tr>
			</c:if>
			
			<c:if test="${seq1 ne seq2}">
				<tr height="20">
					<c:choose>
						<c:when test="${empty comment.writer}">
							<td width="200">(탈퇴함)</td>
						</c:when>
						<c:otherwise>
							<td width="200">${comment.writer}</td>
						</c:otherwise>
					</c:choose>
					<td width="100">${comment.regdate}</td>
					<td width="100"></td>
				</tr>
				<tr height="40">
					<td colspan="3" width="400">${comment.content}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</form>

</div>
</body>
</html>