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
내가 notice의 BoardList다<br>
<table border=1>
	<tr >
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>

<c:forEach items="${data }" var="dd" varStatus="no">
	<tr >
		<td>${(page-1)*limit+1+no.index }</td>
		
		<td><a href="BoardDetail.bo?id=${dd.id }&page=${page}">${dd.title }</a></td>
		<td>${dd.pname }</td>
		<td>${dd.reg_date }</td>
		<td>${dd.cnt }</td>
	</tr>

</c:forEach>
<tr>
	<td colspan="5" align="center">
		<c:if test="${startPage>1 }">
			<a href ="?page=${startPage-1 }" >이전${pageLimit } 페이지</a>
		</c:if>
		<c:if test="${page>1 }">
			<a href ="?page=${page-1 }" ><</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" >
			<c:choose>
				<c:when test="${page==i }">
					[${i }]
				</c:when>
				<c:otherwise>
					<a href ="?page=${i }" >${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${maxPage>page }">
			<a href ="?page=${page+1 }" >></a>
		</c:if>
		<c:if test="${maxPage>endPage }">
			<a href ="?page=${endPage+1 }" >다음${pageLimit } 페이지</a>
		</c:if>
	</td>
</tr>

<tr>
	<td colspan="5" align="right">
		<a href="BoardWriteForm.bo?page=${page }">글쓰기</a>
	</td>
</tr>
</table>

</body>
</html>