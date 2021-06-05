<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.util.ArrayList" %>
    <%@page import = "exam.vo.ExamVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<ExamVO> stulist = (ArrayList<ExamVO>)request.getAttribute("stulist");
	
	if(!stulist.isEmpty())
	{
	%>
	<table border = "1">
		<tr><th>과목번호</th><th>과목명</th>
	<%
		for(int i = 0; i < stulist.size(); i++)
		{
			ExamVO exam = stulist.get(i);
			String sid = exam.getSid();
			String title = exam.getTitle();%>
			
			<tr><td><%= sid %></td>
				<td><%= title %></td>
			</tr>
	<%
		}
	%>	
	</table>
	<%
	}else{
	
	}
	%>
	<a href = "studentmenu.jsp">Menu</a>
</body>
</html>