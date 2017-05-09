package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.User;
import service.UserManager;

@ResponseBody
@Controller
public class UserController {
	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value="/users",method=RequestMethod.POST,headers="Content-Type=application/json")
	public User addUser(@RequestBody User u){
		return userManager.regist(u);
	}
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> findAllUser(){
		return userManager.findAllUser();
	}
	
}
