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

<c:forEach items="${KEY_EMPLIST}" var="evo">
	${evo.empno} , ${evo.ename} <br> 
</c:forEach>
<p><br>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script> $(function() { }); </script>		

</body>
</html>