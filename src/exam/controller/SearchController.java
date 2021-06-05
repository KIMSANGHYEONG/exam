package exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import exam.service.Service;
import exam.vo.ExamVO;

public class SearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("sid");
		
		Service service = Service.getInstance();
		ExamVO exam = service.search(sid);
		
		request.setAttribute("sid", sid);
		if(exam == null) request.setAttribute("result", "No Subject!");
		request.setAttribute("exam", exam);
		HttpUtil.forward(request, response, "/search2.jsp");
	}

}
