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
���� �۾����<br>
<form action="BoardWrite.bo" method="post" enctype="multipart/form-data">
	<table border=1>
		<tr >
			<td>����</td><td><input type="text" name="title"></td>
		</tr><tr>
			<td>�ۼ���</td><td><input type="text" name="pname"></td>
		</tr><tr>
			
			<td>����</td><td>
				<textarea rows="5" cols="20" name="content"></textarea>
			</td>
		</tr><tr>
			<td>����</td><td>
			<input type="file" name="upfile">
			</td>
		</tr><tr>
			<td colspan="2" align="center">
				<input type="submit" value="�Է�">
				<input type="reset" value="���">
				<a href="BoardList.bo?page=${param.page }">����Ʈ��</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>