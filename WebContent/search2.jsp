<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action = "studentenroll.do" method = "put">
	<%
	String result = (String)request.getAttribute("result");
	if( result != null) {
		out.print(result);
	}else{
	%>
	${exam.sid} ${exam.title}
	<input type = "submit" value = "Enrolment"><br>
	</form>
	<%} %>
<a href = "studentmenu.jsp">Menu</a>
</body>
</html>