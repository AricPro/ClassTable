package dao;

import java.util.List;

import pojo.TeacherInfo;

public interface TeacherDao {
	public List<TeacherInfo> selectList();
	public void insertTeacherList(List<TeacherInfo> list);
}
