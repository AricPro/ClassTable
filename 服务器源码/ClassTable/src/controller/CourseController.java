package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import pojo.ClassDetail;
import service.CourseManager;
import util.GetClassTable;

@ResponseBody
@Controller
@RequestMapping(value="/getInfo")
public class CourseController {
	@Autowired
	private CourseManager courseManager;
	
	@RequestMapping(value="/getClassTable", method=RequestMethod.GET, headers="Content-Type=application/json")
	public String getClassTable(String param, String coursevalue){
		ClassDetail table = courseManager.select(coursevalue);
		if(table == null){
			table = GetClassTable.getTable(param, coursevalue, table);
			courseManager.insert(table);
		}
		return table.getChart();
    }
	@RequestMapping(value="/getTable/{coursevalue}/validate/{validate}", method=RequestMethod.GET,produces="text/html;charset=UTF-8", headers="Content-Type=application/json")
	public String getAClassTable(@PathVariable String coursevalue, @PathVariable String validate){
		ClassDetail table = courseManager.select(validate);
		String param = "Sel_XNXQ=20160&Sel_KC="+coursevalue+"&gs=2&txt_yzm="+validate;
		if(table == null){
			table = GetClassTable.getTable(param, coursevalue, table);
			courseManager.insert(table);
		}
		return table.getChart();
	}
}