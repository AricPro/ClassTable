package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.TeacherDao;
import pojo.TeacherInfo;
/**
 * 教师列表
 * @author Aric
 *
 */
@Repository
public class TeacherDaoImpl implements TeacherDao {
	
	@PersistenceContext(name="mysql")
	private EntityManager manager;
	@Override
	public List<TeacherInfo> selectList() {
		String jpql = "from TeacherInfo t";
		List<TeacherInfo> teacherList = manager.createQuery(jpql).getResultList();
		System.out.println("selectList:"+teacherList);
		return teacherList;
	}

	@Override
	public void insertTeacherList(List<TeacherInfo> list) {
		for (TeacherInfo classInfo : list) {
			manager.persist(classInfo);
		}
	}
}
