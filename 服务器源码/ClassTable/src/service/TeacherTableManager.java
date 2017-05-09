package service;

import pojo.TeacherCourse;

public interface TeacherTableManager {
	public void insert(TeacherCourse courseTable);
	public TeacherCourse select(String teacherId);
}
