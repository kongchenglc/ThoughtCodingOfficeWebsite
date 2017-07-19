package com.tc.tccp.web.controller; 

 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tc.tccp.core.entity.User;
import com.tc.tccp.core.util.ResponseUtil;
import com.tc.tccp.web.service.UserService;
 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月12日 下午6:32:51 
 * 学生类控制层
 */

@Controller
@RequestMapping("/student")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,HttpServletResponse response) {//管理员根据工号密码登录登录
		System.out.println("进入用户登录界面");
		JSONObject json = new JSONObject();
		String user_id = request.getParameter("student_name");
		String password = request.getParameter("password");
		User stu = userService.findRegist(user_id, password);
		if (stu == null) {
			json.put("result", false);

		} else {
			json.put("result", true);
			// request.getSession().setAttribute("user_id", stu.getUser_id());
			// request.getSession().setAttribute("authority",
			// stu.getUser_type());
			// request.getSession().setMaxInactiveInterval(900);

		}

		return json.toString();
		}
	
	/**
	 * 登出
	 */
	@RequestMapping("logout")
	public void loginOut(HttpServletRequest request, HttpServletResponse response){
		request.getSession().removeAttribute("user_id");
		request.getSession().removeAttribute("authority");
		//CookieUtils.removeCookie(request, response, "user_id");
		//CookieUtils.removeCookie(request, response, "user_name");
		//CookieUtils.removeCookie(request, response, "lab_name");
		//CookieUtils.removeCookie(request, response, "lab_id");	
	}
	
	@ResponseBody
 	@RequestMapping(value = "/regist")
	public String regist(HttpServletRequest request,HttpServletResponse response) {//普通用户注册
		JSONObject json=new JSONObject();
		String user_id=request.getParameter("student_id");
		String user_name=request.getParameter("student_name");
		String user_class=request.getParameter("student_class");
		String phone_number=request.getParameter("phone_number");
		String direction=request.getParameter("direction");
		User stu=new User();
		stu.setDirection(direction);
		stu.setPhone_number(phone_number);
		stu.setStatus("0");
		stu.setUser_class(user_class);
		stu.setUser_id(user_id);
		stu.setUser_name(user_name);
		stu.setUser_password("0");
		stu.setUser_type(0);//注册普通用户
		if(userService.addUser(stu)==true)
			json.put("result",true);
		else
			json.put("result",false);
		
		return json.toString();
		}
	
	// @Authority(authority=AuthorityType.ADMIN)
	@ResponseBody
	@RequestMapping(value = "/returnStatus")//// 任意用户根据学生学号返回学生面试的状态
	public String returnStatus(HttpServletRequest request,HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String user_id = request.getParameter("student_id"); 
		User stu = userService.findAllByUserId(user_id);
		json.put("status", stu.getStatus());
		return json.toString();
	}
	
	@RequestMapping(value = "/returnList")//获得某个方向的学生信息
	public void returnList(HttpServletRequest request,HttpServletResponse response){
		JSONObject json=new JSONObject();
 		String direction=request.getParameter("direction");
		 List<User> student=userService.findUserByDirection(direction);
		int i=1;
		for(User stu:student){
			stu.setUser_password(null);
			json.put("user"+i, stu);
			i++;
		}
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
		
 	}
	
	@ResponseBody
	@RequestMapping(value = "/returnByStatus")//获得某个状态的学生信息
	public String returnByStatus(HttpServletRequest request,HttpServletResponse response){//任意用户根据学生学号返回学生面试的状态
		JSONObject json=new JSONObject();
 		String status=request.getParameter("status");
		 List<User> student=userService.findAllUserByUserStatus(status);
		int i=1;
		for(User stu:student){
			stu.setUser_password(null);
			json.put("user"+i, stu);
			i++;
		}
		return  json.toString();
		
 	}
	
	@ResponseBody
	@RequestMapping(value = "/returnOneStudent")//获得某个学生信息
	public String returnOneStudent(HttpServletRequest request,HttpServletResponse response){ 
		JSONObject json = new JSONObject();
		String user_id = request.getParameter("student_id");// 学生学号
		System.out.println(user_id);
		User student = userService.findAllByUserId(user_id);
		
		if(student!=null){
			json.put("direction", student.getDirection());
		json.put("phone_number", student.getPhone_number());
		json.put("status", student.getStatus());
		json.put("user_id", student.getUser_id());
		json.put("user_name", student.getUser_name());
		json.put("student_class", student.getUser_class());
		json.put("user_type", student.getUser_type());	
		}
		else
           json.put("status", false);
		

		return json.toString();
		
 	}
	

	@ResponseBody
	@RequestMapping(value = "/returnByStatusAndDirection")//获得某个状态，某个方向的学生信息
	public String returnByStatusAndDirectioon(HttpServletRequest request,HttpServletResponse response){//任意用户根据学生学号返回学生面试的状态
		JSONObject json=new JSONObject();
 		String status=request.getParameter("status");//状态
 		String direction=request.getParameter("direction");//方向
 		System.out.println("status="+status);
 		System.out.println("direction="+direction);
 		List<User> student=new ArrayList<User>();
		if(status.equals("5")&&direction.equals("7")){
 			  student=userService.findAllUserOfStudent();
		}	
		else if(status.equals("5")&&!direction.equals("7")){
 			  student=userService.findUserByDirection(direction);
		}
		else if(direction.equals("7")&&!status.equals("5") ){
 			  student=userService.findAllUserByUserStatus(status);
		}
		else {
 			 student=userService.findAllUserByStatusAndDirectioon(status,direction);
		}
		System.out.println("--"+student.size());
		 if(student.size()>=1){
 			int i=1;
			for(User stu:student){
				stu.setUser_password(null);
				json.put("user"+i, stu);
				i++;
			}
			}
		 
		 
		return  json.toString();
 	}
	
	@ResponseBody
	@RequestMapping(value = "/returnAllList")//返回所有学生的信息
	public String returnAllList(HttpServletRequest request,HttpServletResponse response){
		JSONObject json=new JSONObject();
		List<User> student=userService.findAllUserOfStudent();
		int i=1;
		for(User stu:student){
			stu.setUser_password(null);
			json.put("student"+i, stu);
			i++;
		}
		return json.toString();
		
 	}

	
	@ResponseBody
	@RequestMapping(value = "/changeStudentStatus")//更改用户的状态
	public String changeStudentStatus(HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		String user_id = request.getParameter("student_id");
		String status = request.getParameter("status");
		int type = Integer.parseInt(request.getParameter("access_type"));
		if (status.equals("1") && type == 1) {// 一面通过
			status = "1";

		} else if (status.equals("2") && type == 1) {// 一面待定
			status = "3";
		}

		else if (status.equals("1") && type == 2) {// 二面通过
			status = "2";

		} else if (status.equals("2") && type == 2) {// 二面待定
			status = "4";
		} else if (Integer.parseInt(status) ==3) {// 未过
			System.out.println("未过，未过");
			status = "-1";

		}
		boolean b = userService.changeStatus(user_id,status);

		json.put("result", b);
		return json.toString();

 	}
	}

