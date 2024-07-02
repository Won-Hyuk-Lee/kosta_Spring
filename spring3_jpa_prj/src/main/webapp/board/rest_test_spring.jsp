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
Spring REST Test : 
<input type="text" name="ename" id="ename">
<hr>


<b>0. [RestController : @Controller  + @ResponseBody]</b>String -- String <br>
<input type="button" id="rest-str-str" value="RestController str-str"><hr>


1. String -- String <br>
<input type="button" id="str-str" value="str-str"><hr>

2. JSON -- String <br>
<input type="button" id="json-str" value="json-str"><hr>

3. String -- JSON <br>
<input type="button" id="str-json" value="str-json"><hr>

4. JSON -- JSON <br>
<input type="button" id="json-json" value="json-json"><hr>



5. 일반적형태(String -- JSON) <br>
<form id="regForm">
(제목) : <input type="text" id="title" name="title"><br>
(글쓴이) : <input type="text" id="regid" name="regid"><br>
<input type="button" id="writeButton" value="검색"><hr>
</form>




<div id="resultDIV"></div>




	
	
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script> 
$(function() { 
	//-------------- 공통 : 테이블 그리기 -----------------------
	function makeTable(myval) {
			var htmlStr = "<table border=1 width=50%><tr><th>제목</th><th>글쓴이</th></tr>";
			$.map( myval, function( MYval, MYidx ) {
				htmlStr += "<tr><td>" +MYval["title"] + "</td><td>"+MYval["regid"] +"</td></tr>"
				//console.log(MYval["title"] + "," + MYval["regid"] + "," + MYidx);
			});
			htmlStr += "</table>";
			$("#resultDIV").empty();
			
			//$("#resultDIV").html(myval[0]["title"]);
			$("#resultDIV").html(htmlStr);
		}
	
	
	//--------------------------  RestController 호출 -----------------------
	$("#rest-str-str").click(  function(){
		var ename_val = $("#ename").val();
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/restctl_str_str",
	        data 		: "ename="+ename_val,
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
								  			console.log("0.RestContrller Spring응답:" + myval);
	  									 }
		});
	});
	
	
	//-------------------------- 일반 Controller 호출 -----------------------
	
	$("#str-str").click(  function(){
		var ename_val = $("#ename").val();
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_str_str",
	        data 		: "ename="+ename_val,
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
								  			console.log("1.Spring응답:" + myval);   
											//myval = JSON.parse(myval);
											//console.log("변환후:" + myval);
	  										//makeTable(myval);			
	  									 }
		});
	});
	
	
	$("#json-str").click(  function(){
		var objData = {"title":"aaaaatitle","regid":"hong"};
		$.ajax({
			method      : "POST",
	        url         : "<%=request.getContextPath()%>/ctl_json_str",
	        contentType : "application/json; charset=UTF-8",
	        data 		: JSON.stringify(objData),   
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
	  										console.log("2.Spring응답:" + myval);  
	  									 }
		});
	});
	
	
	$("#str-json").click(  function(){
		var ename_val = $("#ename").val();
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_str_json",
	        data 		: "ename="+ename_val,
	        //dataType	: "json",
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval, textStatus, xhr){
	  							if (xhr.status == 200) {
									console.log("3.Spring응답:" + myval["message"]);
	  							}
						 }
		});
	});
	
	
	$("#json-json").click(  function(){
		var objData = {"title":"aaaaatitle","regid":"hong"};
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_json_json",
	        data 		: JSON.stringify(objData),  
	        contentType : "application/json; charset=UTF-8",
	        //dataType	: "json",
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
	  										console.log(myval);
	  									 }
		});
	});
	
	
	$("#writeButton").click(  function(){
		var sendFormData = $("#regForm").serialize();  //title=aaaa&regid=kim
		$.ajax({
			method      : "POST",
	        url         : "${pageContext.request.contextPath}/ctl_normal",
	        data 		: sendFormData,  
	        //dataType	: "json",
	  		error 	    : function(myval){ console.log("에러:" + myval);   },
	  		success     : function(myval){ 
	  										console.log(myval);
	  										makeTable(myval);
	  									 }
		});
	});
	
	
}); </script>		

</body>
</html>