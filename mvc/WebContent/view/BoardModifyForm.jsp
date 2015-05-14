<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="BoardModify.bo" method="post" >
	<input type="hidden" name="id" value="${data.id }">
	<input type="hidden" name="page" value="${param.page}">
	<table border=1>
		<tr >
			<td>제목</td><td><input type="text" name="title" value="${data.title }"></td>
		</tr><tr>
			<td>작성자</td><td><input type="text" name="pname"  value="${data.pname }"></td>
		</tr><tr>
			
			<td>내용</td><td>
				<textarea rows="5" cols="20" name="content">${data.content }</textarea>
			</td>
		</tr><tr>
			<td>파일</td><td>
				${data.upfile }
			</td>
		</tr><tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정">
				<input type="reset" value="취소">
				<a href="BoardDetail.bo?id=${data.id }&page=${param.page}">상세보기로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>