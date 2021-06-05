package exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.service.Service;
import exam.vo.ExamVO;

public class StudentEnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String sid = (String)session.getAttribute("sid");
		String id = (String)session.getAttribute("id");
		ExamVO examvo = new ExamVO(sid, id);
		
		Service s = Service.getInstance();
		s.studentenroll(examvo);
		
		HttpUtil.forward(request, response, "/studentmenu.jsp");
	}
	
}
