package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="teachertable")
public class TeacherCourse {
	@Id
	@SequenceGenerator(name="u_seq",sequenceName="seq_002",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="u_seq",strategy=GenerationType.SEQUENCE)
	private int id;
	private String teacherId;
	@Column(length=1000)
	private String chart;
	
	public TeacherCourse() {
		super();
	}

	public TeacherCourse(String teacherId, String chart) {
		super();
		this.teacherId = teacherId;
		this.chart = chart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getChart() {
		return chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}
}
