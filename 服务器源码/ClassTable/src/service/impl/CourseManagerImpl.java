package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CourseDao;
import pojo.ClassDetail;
import service.CourseManager;

@Service
public class CourseManagerImpl implements CourseManager{

	@Autowired
	private CourseDao courseDao;
	@Transactional
	@Override
	public void insert(ClassDetail courseTable ) {
		
		courseDao.insertCourse(courseTable);
	}
	
	@Transactional
	@Override
	public ClassDetail select(String courseId) {

		return courseDao.select(courseId);
	}
}
