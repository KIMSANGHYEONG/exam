package exam.vo;

public class ExamVO {
	private String id;
	private String pwd;
	private String kind;
	private String sid;
	private String title;
	private int count;
	private int stu;
	public int getStu() {
		return stu;
	}

	public void setStu(int stu) {
		this.stu = stu;
	}

	public ExamVO() {}
	
	public ExamVO(String tSid, String tId) {
		this.sid = tSid;
		this.id = tId;
	}
	
	public ExamVO(String tSid, String tTitle, int tCount, String tId) {
		this.sid = tSid;
		this.title = tTitle;
		this.count = tCount;
		this.id = tId;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String tSid) {
		this.sid = tSid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String tTitle) {
		this.title = tTitle;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int tCount) {
		this.count = tCount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String tId) {
		this.id = tId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String tPwd) {
		this.pwd = tPwd;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String tKind) {
		this.kind = tKind;
	}
	

}
