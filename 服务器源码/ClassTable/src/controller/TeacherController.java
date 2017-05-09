package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ClassDetail;
import pojo.TeacherCourse;
import service.CourseManager;
import service.TeacherTableManager;
import util.GetClassTable;
import util.GetTeacherTable;

@ResponseBody
@Controller
@RequestMapping(value="/teacherForm")
public class TeacherController {
	@Autowired
	private TeacherTableManager tManager;
	
	@RequestMapping(value="/getTeacherTable", method=RequestMethod.GET, headers="Content-Type=application/json")
	public String getClassTable(String param, String teachervalue){
		TeacherCourse table = tManager.select(teachervalue);
		if(table == null){
			table = GetTeacherTable.getTable(param, teachervalue, table);
			tManager.insert(table);
		}
		return table.getChart();
    }
	@RequestMapping(value="/getTeacherTable/{teachervalue}/validate/{validate}",produces="text/html;charset=UTF-8", method=RequestMethod.GET, headers="Content-Type=application/json")
	public String getAClassTable(@PathVariable String teachervalue, @PathVariable String validate){
		TeacherCourse table = tManager.select(validate);
		String param = "Sel_XNXQ=20160&Sel_JS="+teachervalue+"&type=2&txt_yzm="+validate;
		if(table == null){
			table = GetTeacherTable.getTable(param, teachervalue, table);
			tManager.insert(table);
		}
		return table.getChart();
	}
}