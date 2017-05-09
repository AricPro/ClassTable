package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.CourseDao;
import pojo.ClassInfo;
import pojo.ClassDetail;

@Repository
public class CourseDaoImpl implements CourseDao{

	@PersistenceContext(name="mysql")
	private EntityManager manager;
	
	@Override
	public void insertCourse(ClassDetail courseTable) {
		manager.persist(courseTable);
	}

	@Override
	public ClassDetail select(String courseId) {
		String sql = "from ClassDetail detail where detail.classId=:classid";
		List<ClassDetail> table =  manager.createQuery(sql).setParameter("classid", courseId).getResultList();
		System.out.println("table:" + table);
		return table.size() == 0 ? null:table.get(0);
	}
	public List<ClassInfo> selectList(){
		
		return null;
	}
}
