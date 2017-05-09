package dao;

import java.util.List;

import pojo.ClassInfo;

public interface ClassDao {
	public List<ClassInfo> selectList();
	public void insertClassList(List<ClassInfo> list);
}
