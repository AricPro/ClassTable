package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="classdetail")
public class ClassDetail {
	
	@Id
	@SequenceGenerator(name="u_seq",sequenceName="seq_002",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="u_seq",strategy=GenerationType.SEQUENCE)
	private int id;
	private String classId;
	@Column(length=1000)
	private String chart;
	
	public ClassDetail() {
		super();
	}
	
	public ClassDetail(String classId, String chart) {
		super();
		this.classId = classId;
		this.chart = chart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getChart() {
		return chart;
	}
	public void setChart(String chart) {
		this.chart = chart;
	}
	
}
