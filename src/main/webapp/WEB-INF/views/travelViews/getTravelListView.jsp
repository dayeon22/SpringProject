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
			<a href="getLogin.do">로그인</a>&nbsp;&nbsp;
			<a href="getJoin.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="logout.do">로그아웃</a>&nbsp;&nbsp;
			<a href="unregister.do">회원탈퇴</a>
		</c:otherwise>
		</c:choose>
	</div>

	<form method="post" action="searchTravelList.do">
		<table class="table table-striped">
			<thead>
			<tr>
				<td>
					<a href="insertTravel.do">새로운 글 추가</a>
				</td>
				<td>
					<select class="form-select" name="orderValue">
						<option value="orderSeq">번호</option>
						<option value="orderTitle">제목</option>
						<option value="orderWriter">작성자</option>
						<option value="orderRegDate">작성일</option>
					</select>
				</td>
				<td>
					<select class="form-select" name="order">
						<option value="asc">오름차순</option>
						<option value="desc">내림차순</option>
					</select>
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
				<td align="center">번호</td>
				<td align="center" colspan="2">제목</td>
				<td align="center">작성자</td>
				<td align="center">작성일</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${tList}" var="travel">
				<tr height="40">
					<td align="center">${travel.seq}</td>
					<td align="center" colspan="2"> 
						<a href="getTravel.do?seq=${travel.seq}">${travel.title}</a>
					</td>
					<c:choose>
					<c:when test="${empty travel.writer}">
						<td align="center">(탈퇴함)</td>
					</c:when>
					<c:otherwise>
						<td align="center"> ${travel.writer} </td>
					</c:otherwise>
					</c:choose>
					<td align="center"> ${travel.regdate} </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>