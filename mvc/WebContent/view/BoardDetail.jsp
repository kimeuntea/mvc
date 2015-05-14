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
내가 notice의 BoardDetail다<br>
<table border=1>
	<tr >
		<td>제목</td><td>${data.title }</td>
	</tr><tr>
		<td>작성자</td><td>${data.pname }</td>
	</tr><tr>
		<td>작성일</td><td>${data.reg_date }</td>
	</tr><tr>
		<td>조회수</td><td>${data.cnt }</td>
	</tr><tr>
		<td>내용</td><td>${data.content }</td>
	</tr><tr>
		<td>파일</td><td>${data.upfile }</td>
		
	</tr><tr>
		<td colspan="2" align="right">
			<a href="BoardDelete.bo?id=${data.id }&page=${param.page }">삭제</a>
			<a href="BoardModifyForm.bo?id=${data.id }&page=${param.page }">수정</a>
			<a href="BoardList.bo?page=${param.page }">리스트로</a>
		</td>
	</tr>
</table>

</body>
</html>