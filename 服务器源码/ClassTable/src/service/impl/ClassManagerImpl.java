package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ClassDao;
import pojo.ClassInfo;
import service.ClassManager;

@Service
public class ClassManagerImpl implements ClassManager{

	@Autowired
	private ClassDao classDao;
	
	@Transactional
	@Override
	public List<ClassInfo> selectList() {
		return classDao.selectList();
	}
	
	@Transactional
	@Override
	public void insertClassList(List<ClassInfo> list) {
		classDao.insertClassList(list);
	}

}
