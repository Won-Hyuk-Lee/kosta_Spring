<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시글 작성 및 파일 업로드</h2>

<!-- 게시글 및 파일 업로드 폼 -->
<form action="/submit_post" method="post" enctype="multipart/form-data">
    <div>
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required>
    </div>
    <div>
        <label for="contents">내용:</label>
        <textarea id="contents" name="contents" rows="10" cols="30" required></textarea>
    </div>
    <div>
        <label for="ufiles">파일 선택:</label>
        <input type="file" id="ufiles" name="ufiles" multiple="multiple">
    </div>
    <div>
        <input type="submit" value="전송">
    </div>
</form>

</body>
</html>
