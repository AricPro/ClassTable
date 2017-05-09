package service;

import java.util.List;

import pojo.TeacherInfo;

public interface TeacherListManager {
	public List<TeacherInfo> selectList();
	public void insertTeacherList(List<TeacherInfo> list);
}
