<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${KEY_BOARDLIST}" var="bvo">
	${bvo.seq} , 
	<a href="${pageContext.request.contextPath}/board_detail?seq=${bvo.seq}">${bvo.title}</a>, 
	${bvo.regdate} <br> 
</c:forEach>
<p><br>
<a href="${pageContext.request.contextPath}/lec04_board/board_insert.jsp">글쓰기</a>
</body>
</html>