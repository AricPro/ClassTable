package service;

import pojo.ClassDetail;

public interface CourseManager {
	public void insert(ClassDetail courseTable);
	public ClassDetail select(String courseId);
}
