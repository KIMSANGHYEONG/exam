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
	ArrayList<ExamVO> proflist = (ArrayList<ExamVO>)request.getAttribute("proflist");
	ArrayList<ExamVO> studentlist = (ArrayList<ExamVO>)request.getAttribute("studentlist");
	
	if(!proflist.isEmpty())
	{
	%>
		<table border = "1">
			<tr><th>과목번호</th><th>과목명</th><th>최대인원</th><th>수강인원</th></tr>
	<% 
		for(int i = 0; i < proflist.size(); i++)
		{
			ExamVO exam = proflist.get(i);
			String sid = exam.getSid();
			String title = exam.getTitle();
			int count = exam.getCount();%>

			<tr><td><%= "<a href = 'studentlist.do'>"%><%=sid%><%="</a>" %></td>
				<td><%= title %></td>
				<td><%= count %></td>	
				</tr>
	<%		
		}
		
	%>
		</table>
	<% 
	}else{
		
	}
	%>
	
	<a href = "profmenu.jsp" >Menu</a>
</body>
</html>