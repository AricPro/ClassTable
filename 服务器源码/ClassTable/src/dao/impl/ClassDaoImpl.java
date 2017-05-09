package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.ClassDao;
import pojo.ClassInfo;

/**
 * ©нЁлап╠М
 * @author Aric
 *
 */
@Repository
public class ClassDaoImpl implements ClassDao{

	@PersistenceContext(name="mysql")
	private EntityManager manager;
	
	@Override
	public List<ClassInfo> selectList() {
		String jpql = "from ClassInfo cll";
		List<ClassInfo> classList = manager.createQuery(jpql).getResultList();
		System.out.println("selectList:"+classList);
		return classList;
	}

	@Override
	public void insertClassList(List<ClassInfo> list) {
		for (ClassInfo classInfo : list) {
			manager.persist(classInfo);
		}
	}
}
