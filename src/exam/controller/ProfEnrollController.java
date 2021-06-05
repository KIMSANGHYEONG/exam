package exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.service.Service;
import exam.vo.ExamVO;

public class ProfEnrollController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("sid");
		String title = request.getParameter("title");
		int count = Integer.parseInt(request.getParameter("count"));
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ExamVO examvo = new ExamVO(sid, title, count, id);
		
		Service s = Service.getInstance();
		s.profenroll(examvo);
		
		request.setAttribute("sid", sid);
		request.setAttribute("title", title);
		request.setAttribute("count", count);
		HttpUtil.forward(request, response, "/profmenu.jsp");
		
	}

}
