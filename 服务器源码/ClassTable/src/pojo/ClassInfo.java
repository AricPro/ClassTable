package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="classinfo")
public class ClassInfo {
	@Id
	@SequenceGenerator(name="u_seq",sequenceName="seq_002",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="u_seq",strategy=GenerationType.SEQUENCE)
	private int id;
	private String courseName;
	private String courseId;
	
	public ClassInfo() {
		super();
	}
	
	public ClassInfo(String courseId, String courseName) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
}
