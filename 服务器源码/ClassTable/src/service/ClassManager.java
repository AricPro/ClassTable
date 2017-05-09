package service;

import java.util.List;

import pojo.ClassInfo;

public interface ClassManager {

	public List<ClassInfo> selectList();
	public void insertClassList(List<ClassInfo> list);
}
