package pojo;

public class Course_Info {
	private String course_id;
	private String teacher_name;
	private String class_num;
	private String num;
	private String course_name;
	private String checkway;
	private String constitute;
	private String week_time;
	private String class_time;
	private String site;
	
	public Course_Info() {
		super();
	}
	public Course_Info(String course_id, String teacher_name, String class_num, String num, String course_name, String checkway,
			String constitute, String week_time, String class_time, String site) {
		super();
		this.course_id = course_id;
		this.teacher_name = teacher_name;
		this.class_num = class_num;
		this.num = num;
		this.course_name = course_name;
		this.checkway = checkway;
		this.constitute = constitute;
		this.week_time = week_time;
		this.class_time = class_time;
		this.site = site;
	}
	
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getClass_num() {
		return class_num;
	}
	public void setClass_num(String class_num) {
		this.class_num = class_num;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCheckway() {
		return checkway;
	}
	public void setCheckway(String checkway) {
		this.checkway = checkway;
	}
	public String getConstitute() {
		return constitute;
	}
	public void setConstitute(String constitute) {
		this.constitute = constitute;
	}
	public String getWeek_time() {
		return week_time;
	}
	public void setWeek_time(String week_time) {
		this.week_time = week_time;
	}
	public String getClass_time() {
		return class_time;
	}
	public void setClass_time(String class_time) {
		this.class_time = class_time;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
}
