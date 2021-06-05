package exam.service;

import java.util.ArrayList;

import exam.dao.ExamDao;
import exam.vo.ExamVO;

public class Service {
	private static Service service = new Service();
	private Service() {}
	private ExamDao dao = ExamDao.getInstance();
	public static Service getInstance()
	{
		return service;
	}
	public boolean login(String id, String pwd, String kind) {
		
		// TODO Auto-generated method stub
		return dao.login(id, pwd, kind);
	}
	public void profenroll(ExamVO examvo) {
		// TODO Auto-generated method stub
		
		dao.profenroll(examvo);
		
	}
	public ArrayList<ExamVO> profshowsubject(String id) {
		// TODO Auto-generated method stub
		return dao.profshowsubject(id);
		
	}
	public ExamVO search(String sid) {
		// TODO Auto-generated method stub
		
		ExamVO exam = dao.search(sid);
		
		return exam;
	}
	public void studentenroll(ExamVO examvo) {
		// TODO Auto-generated method stub
		dao.studentenroll(examvo);
	}
	public ArrayList<ExamVO> stushowsubject(String id) {
		// TODO Auto-generated method stub
		return dao.stushowsubject(id);
		
	}
	

}
