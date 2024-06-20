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
REST(JSON) 테스트<hr>

<input id="0__Controller_Str_Str_Btn" type="button" value="Str_Str전송-Controller">
<input id="1__Controller_Json_Str_Btn" type="button" value="Json_Str전송-Controller">
<input id="2__Controller_Json_Json_Btn" type="button" value="Json_Json전송-Controller">
<input id="3__RestController_Json_Str_Btn" type="button" value="Json_Str전송-RestController">
<input id="4__RestController_Json_Json_Btn" type="button" value="Json_Json전송-RestController">


<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script> 
$(document).ready(function(){
	
	$("#0__Controller_Str_Str_Btn").click(  function(){
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_str_str",
	        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
	        data 		: "seq=1&regid=hong",   
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ console.log("성공:" + myval);    }
		});
	}); 
	
	
	$("#1__Controller_Json_Str_Btn").click(  function(){
		var objData = {"seq":1,"regid":"hong"};
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_json_str",
	        contentType : "application/json; charset=UTF-8",
	        data 		: JSON.stringify(objData),   
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ console.log("성공:" + myval);    }
		});
	});
	
	$("#2__Controller_Json_Json_Btn").click(  function(){
		var objData = {"seq":1,"regid":"hong"};
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_json_json",
	        contentType : "application/json; charset=UTF-8",
	        data 		: JSON.stringify(objData),   
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ console.log("성공:" + myval);    }
		});
	});
	
	
	
	$("#3__RestController_Json_Str_Btn").click(  function(){
		var objData = {"seq":1,"regid":"hong"};
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/restctl_json_str",
	        contentType : "application/json; charset=UTF-8",
	        data 		: JSON.stringify(objData),   
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ console.log("성공:" + myval);    }
		});
	});
	$("#4__RestController_Json_Json_Btn").click(  function(){
		var objData = {"seq":1,"regid":"hong"};
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/restctl_json_json",
	        contentType : "application/json; charset=UTF-8",
	        data 		: JSON.stringify(objData),   
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ console.log("성공:" + myval);    }
		});
	});
		
	
	
}); </script>		

</body>
</html>