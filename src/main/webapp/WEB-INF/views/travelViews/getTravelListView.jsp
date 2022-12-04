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
<div class="container">
	<br>
	<div class="d-flex justify-content-center">
		<h2>게시판 전체 내용</h2>
	</div>
	
	<div class="d-flex justify-content-end">
		<c:choose>
		<c:when test="${empty sessionId}">
			<a class="text-right" href="getLogin.do">로그인</a>&nbsp;&nbsp;
			<a class="text-right" href="getJoin.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="logout.do">로그아웃</a>
		</c:otherwise>
		</c:choose>
	</div>

	<form method="post" action="searchTravelList.do">
		<table class="table table-striped">
			<thead>
			<tr>
				<td colspan="2">
					<a href="insertTravel.do">새로운 글 추가</a>
				</td>
				<td>
					<select class="form-select" name="searchCon">
						<option value="title">글제목</option>
						<option value="content">글내용</option>
					</select>
				</td>
				<td>
					<input type="text" name="searchKey">
					<input type="submit" value="검색">
				</td>
			</tr>
			<tr height="40">
				<td width="50" align="center">번호</td>
				<td width="400" align="center">제목</td>
				<td width="100" align="center">작성자</td>
				<td width="150" align="center">작성일</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${tList}" var="travel">
				<tr height="40">
					<td width="50" align="center">${travel.seq}</td>
					<td width="400" align="center"> 
						<a href="getTravel.do?seq=${travel.seq}">${travel.title}</a>
					</td>
					<td width="100" align="center"> ${travel.writer} </td>
					<td width="150" align="center"> ${travel.regdate} </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>