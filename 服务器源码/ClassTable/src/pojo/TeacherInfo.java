package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="teacherInfo")
public class TeacherInfo {
	@Id
	@SequenceGenerator(name="u_seq",sequenceName="seq_002",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="u_seq",strategy=GenerationType.SEQUENCE)
	private int id;
	private String teacherName;
	private String teacherId;
	public TeacherInfo() {
		super();
	}
	public TeacherInfo(String teacherName, String teacherId) {
		super();
		this.teacherName = teacherName;
		this.teacherId = teacherId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
}
