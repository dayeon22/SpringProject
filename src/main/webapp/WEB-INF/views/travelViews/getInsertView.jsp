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

<c:if test="${empty sessionId}">
	<script>
		alert("로그인 후 이용 가능합니다.");
		history.go(-1);
	</script>
</c:if>

<br />
<div class="container">
<h2>새로운 글 등록</h2>
	<form action="insertProcTravel.do" method="post">
		<div class="mb-3">
			<label class="form-label" for="title">제목</label>
			<input class="form-control" id="title" type="text" name="title">
		</div>
		<div class="mb-3">
			<label class="form-label" for="writer">작성자</label>
			<input class="form-control" id="writer" type="text" name="writer" value="${sessionId}" readonly>
		</div>
		<div class="mb-3">
			<textarea rows="15" cols="150" name="content">글 내용을 적어주세요.</textarea>
		</div>
		<div class="mb-3">
			<input type="submit" value="저장" />
			<input type="reset" value="취소" />
			<input type="button" value="목록보기" onclick="location.href='getTravelList.do'" />
		</div>
	</form>
</div>

</body>
</html>