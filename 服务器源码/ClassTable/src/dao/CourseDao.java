package dao;

import pojo.ClassDetail;

public interface CourseDao {
	public void insertCourse(ClassDetail couseTable);
	public ClassDetail select(String courseId);
}