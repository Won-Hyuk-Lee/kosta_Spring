<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/board_insert" method="post">
제목:<input type="text" name="title"><br>
내용:<textarea name="contents"></textarea><br>
<input type="submit" value="글쓰기">
</form>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script> $(function() { }); </script>		

</body>
</html>