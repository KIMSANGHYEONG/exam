package exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import exam.vo.ExamVO;

public class ExamDao {
	
	private static ExamDao dao = new ExamDao();
	private ExamDao() {}

	public static ExamDao getInstance() {
		// TODO Auto-generated method stub
		return dao;
	}
	public Connection connect ()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "rlatkdgud98+");
		}catch(Exception e) {
			System.out.println("MDAO:connect"+e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt !=null)
		{
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.println("Pstmt close error" +e);
			}
			if(conn != null) 
			{
				try {
					conn.close();
				}catch(Exception e)
				{
					System.out.println("Conn close error" +e);
				}
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			}catch(Exception e) {
				System.out.println("rs close error" +e);
			}
		}
		close(conn, pstmt);
	}

	
	public boolean login(String id, String pwd, String kind) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{ 
			if(kind.equals("prof"))
			{
				conn = connect();	
				pstmt = conn.prepareStatement("select * from prof where id  = ? and pwd = ?");
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					result = true;
				}
				else
					result = false;
			}
			else
			{
				conn = connect();	
				pstmt = conn.prepareStatement("select * from student where id  = ? and pwd = ?");
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					result = true;
				}
				else
					result = false;
			}
		}catch(Exception e)
		{
			System.out.println("join error" + e);
		}
		finally
		{
			close(conn, pstmt,rs);
		}
		return result;
	}

	public void profenroll(ExamVO examvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?,?,?,?)");
			pstmt.setString(1, examvo.getSid());
			pstmt.setString(2, examvo.getTitle());
			pstmt.setInt(3, examvo.getCount());
			pstmt.setString(4, examvo.getId());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("profenroll error" +e);
		}
		finally
		{
			close(conn, pstmt);
		}
	}

	public ArrayList<ExamVO> profshowsubject(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExamVO exam = null;
		ArrayList<ExamVO> proflist = new ArrayList<ExamVO>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject where prof=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				exam = new ExamVO();
				exam.setSid(rs.getString(1));
				exam.setTitle(rs.getString(2));
				exam.setCount(rs.getInt(3));
				proflist.add(exam);
			}
		}catch(Exception e) {
			System.out.println("profshowsubject error" + e);
		}finally
		{
			close(conn, pstmt, rs);
		}
		return proflist;
		
	}

	public ExamVO search(String sid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExamVO exam = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject where id = ?;");
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			if(rs.next())	
			{
				exam = new ExamVO();
				exam.setSid(rs.getString(1));
				exam.setTitle(rs.getString(2));
			}
		}catch(Exception e) {
			System.out.println("Search error" + e);
		}finally
		{
			close(conn, pstmt, rs);
		}
		return exam;
	}

	public void studentenroll(ExamVO examvo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?,?)");
			pstmt.setString(1, examvo.getSid());
			pstmt.setString(2, examvo.getId());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("studentenroll error" +e);
		}
		finally
		{
			close(conn, pstmt);
		}
		
	}
	
	public ArrayList<ExamVO> stushowsubject(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExamVO exam = null;
		ArrayList<ExamVO> stulist = new ArrayList<ExamVO>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select b.id, b.name from enroll a, subject b where a.subject = b.id and a.student = (?);");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				exam = new ExamVO();
				exam.setSid(rs.getString(1));
				exam.setTitle(rs.getString(2));
				stulist.add(exam);
			}
		}catch(Exception e) {
			System.out.println("profshowsubject error" + e);
		}finally
		{
			close(conn, pstmt, rs);
		}
		return stulist;
		
	}
		
}
