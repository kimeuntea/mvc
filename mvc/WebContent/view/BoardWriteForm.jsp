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
내가 글쓰기다<br>
<form action="BoardWrite.bo" method="post" enctype="multipart/form-data">
	<table border=1>
		<tr >
			<td>제목</td><td><input type="text" name="title"></td>
		</tr><tr>
			<td>작성자</td><td><input type="text" name="pname"></td>
		</tr><tr>
			
			<td>내용</td><td>
				<textarea rows="5" cols="20" name="content"></textarea>
			</td>
		</tr><tr>
			<td>파일</td><td>
			<input type="file" name="upfile">
			</td>
		</tr><tr>
			<td colspan="2" align="center">
				<input type="submit" value="입력">
				<input type="reset" value="취소">
				<a href="BoardList.bo?page=${param.page }">리스트로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>