<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "exam.vo.ExamVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a>Subject</a><br>
<form action = "search.do" method = "put">
ID : <input type = "text" name = "sid">
<input type = "submit" value = "search">
</form>

<a href = "studentmenu.jsp">Menu</a>

</body>
</html>