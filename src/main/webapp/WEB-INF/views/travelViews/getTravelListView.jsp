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
	<h2>게시판 전체 내용</h2>
	<a href="insertTravel.do">새로운 글 추가</a>
	<a href="loginView.jsp">로그인</a>
	<form method="post" action="searchTravelList.do">
		<table border="1">
			<tr height="40" bgcolor="yellow">
				<td colspan="4" align="right">
					<select name="searchCon">
						<option value="title">글제목</option>
						<option value="content">글내용</option>
					</select>
					<input type="text" name="searchKey">
					<input type="submit" value="검색">
				</td>
			</tr>
		
			<tr height="40">
				<td width="150" align="center">번호</td>
				<td width="150" align="center">제목</td>
				<td width="150" align="center">글쓴이</td>
				<td width="150" align="center">내용</td>
			</tr>
			<c:forEach items="${tList}" var="travel">
				<tr height="40">
					<td width="150" align="center">${travel.seq}</td>
					<td width="150" align="center"> 
						<a href="getTravel.do?seq=${travel.seq}">${travel.title}</a>
					</td>
					<td width="150" align="center"> ${travel.writer} </td>
					<td width="150" align="center"> ${travel.content} </td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</center>
</html>