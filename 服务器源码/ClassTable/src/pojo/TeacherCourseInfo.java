package pojo;


public class TeacherCourseInfo {
	private String teacherId;  //教师编号
	private String numId;//序号
    private String course;//课程名
    private String score;
    private String stduyway;
    private String lesson;
    private String class_id;
    private String class_num;
    private String stu_count;
    private String time;
    private String site;
    
	public TeacherCourseInfo() {
		super();
	}
	
	public TeacherCourseInfo(String teacherId,String numId, String course, String score, String stduyway, String lesson,
			String class_id, String class_num, String stu_count, String time, String site) {
		super();
		this.teacherId = teacherId;
		this.numId = numId;
		this.course = course;
		this.score = score;
		this.stduyway = stduyway;
		this.lesson = lesson;
		this.class_id = class_id;
		this.class_num = class_num;
		this.stu_count = stu_count;
		this.time = time;
		this.site = site;
	}
	
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getNumId() {
		return numId;
	}

	public void setNumId(String numId) {
		this.numId = numId;
	}

	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getStduyway() {
		return stduyway;
	}
	public void setStduyway(String stduyway) {
		this.stduyway = stduyway;
	}
	public String getLesson() {
		return lesson;
	}
	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getClass_num() {
		return class_num;
	}
	public void setClass_num(String class_num) {
		this.class_num = class_num;
	}
	public String getStu_count() {
		return stu_count;
	}
	public void setStu_count(String stu_count) {
		this.stu_count = stu_count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	@Override
	public String toString() {
		return teacherId+"-"+"-"+numId+"-"+course+"-"+score+"-"+stduyway+"-"+lesson+"-"+class_id+"-"+class_num+"-"+stu_count+"-"+time+"-"+site;
	}
}
