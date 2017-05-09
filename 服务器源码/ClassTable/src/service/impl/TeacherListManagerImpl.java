package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.TeacherDao;
import pojo.TeacherInfo;
import service.TeacherListManager;

@Service
public class TeacherListManagerImpl implements TeacherListManager {

	@Autowired
	private TeacherDao tDao;
	
	@Transactional
	@Override
	public List<TeacherInfo> selectList() {
		// TODO Auto-generated method stub
		return tDao.selectList();
	}

	@Transactional
	@Override
	public void insertTeacherList(List<TeacherInfo> list) {
		tDao.insertTeacherList(list);
		
	}
}
