package exam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.service.Service;
import exam.vo.ExamVO;

public class StuShowSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		Service service = Service.getInstance();
		ArrayList<ExamVO> stulist = service.stushowsubject(id);
		
		request.setAttribute("stulist", stulist);
		HttpUtil.forward(request, response, "/stushowsubject.jsp");
	}

}
