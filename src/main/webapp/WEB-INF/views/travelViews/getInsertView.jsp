<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<center>
<c:if test="${empty sessionId}">
	<script>
		alert("로그인 후 이용 가능합니다.");
		history.go(-1);
	</script>
</c:if>
<h2>새로운 글 등록</h2>
<form action="insertProcTravel.do" method="post">
	<table border="1">
		<tr height="50" align="center">
			<td width="150">글제목</td>
			<td width="250">
				<input type="text" name="title">
			</td>
		</tr>
		<tr height="50" align="center">
			<td width="150">글작성자</td>
			<td width="250">
				<input type="text" name="writer" value="${sessionId}" readonly>
			</td>
		</tr>
		<tr height="50" align="center">
			<td colspan="2" width="250">
				<!-- <input type="text" name="content"> -->
				<textarea rows="15" cols="30" name="content">글 내용을 적어주세요.</textarea>
			</td>
		</tr>
		<tr height="50" align="center">
			<td colspan="2">
				<input type="submit" value="저장" />
				<input type="reset" value="취소" />
				<input type="button" value="목록보기" onclick="location.href='getTravelList.do'" />
			</td>
		</tr>
	</table>
</form>
</center>
</body>
</html>