<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h>YogIn LMS</h><br>
	<form action = "login.do" method = "put">
	I      D : <input type = "text" name = "id" ><br>
	Password : <input type = "passowrd" name = "pwd"><br>
	<label><input type = "radio" name= "kind" value = "prof">Professor</label>
	<label><input type = "radio" name= "kind" value = "student">Student</label><br>
	<input type = "submit" value = "Login">
	</form>
</body>
</html>