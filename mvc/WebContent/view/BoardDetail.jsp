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
���� notice�� BoardDetail��<br>
<table border=1>
	<tr >
		<td>����</td><td>${data.title }</td>
	</tr><tr>
		<td>�ۼ���</td><td>${data.pname }</td>
	</tr><tr>
		<td>�ۼ���</td><td>${data.reg_date }</td>
	</tr><tr>
		<td>��ȸ��</td><td>${data.cnt }</td>
	</tr><tr>
		<td>����</td><td>${data.content }</td>
	</tr><tr>
		<td>����</td><td>${data.upfile }</td>
		
	</tr><tr>
		<td colspan="2" align="right">
			<a href="BoardDelete.bo?id=${data.id }&page=${param.page }">����</a>
			<a href="BoardModifyForm.bo?id=${data.id }&page=${param.page }">����</a>
			<a href="BoardList.bo?page=${param.page }">����Ʈ��</a>
		</td>
	</tr>
</table>

</body>
</html>