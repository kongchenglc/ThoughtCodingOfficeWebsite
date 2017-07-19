package com.tc.tccp.web.controller; 


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tc.tccp.core.entity.Access;
import com.tc.tccp.core.entity.User;
import com.tc.tccp.web.service.AccessService;
import com.tc.tccp.web.service.UserService;


 
@Controller
@RequestMapping("/access") 
public class AccessController {

	
	@Autowired
 	private AccessService accessService;
	
	@Autowired
	private UserService studentService;
	
	@Transactional
	@ResponseBody
	@RequestMapping(value = "/addAccess")
	public String addAccess(HttpServletRequest request,HttpServletResponse response) {// 管理员添加评价信息

		JSONObject json = new JSONObject();
		int type = Integer.parseInt(request.getParameter("access_type"));// 第几面评价
		String student_id = request.getParameter("student_id");// 学生学号
		String supplement = request.getParameter("supplement");// 补充说明
		int basescore = Integer.parseInt(request.getParameter("basescore"));// 基础分数
		int technicalscore = Integer.parseInt(request
				.getParameter("technicalscore"));// 技术分数
		int studyability = Integer.parseInt(request
				.getParameter("studyability"));// 学习能力
		int attitude = Integer.parseInt(request.getParameter("attitude"));// 态度
		String status = request.getParameter("status");// 通过与否(1:过一面，0：未面试，)
		String direction = request.getParameter("direction");// 方向（1,2,3,4）
		if(status.equals("1") &&type==1){//一面通过
			status="1";
			
		}
		else if(status.equals("2") &&type==1){//一面待定
			status="3";
		}
//		else if(status.equals("3") &&type==1){//一面未过
//			
//		}
		else if(status.equals("1") &&type==2){//二面通过
			status="2";
			
		}else if(status.equals("2") &&type==2){//二面待定
			status="4";
		}
		else if(Integer.parseInt(status)<0){//二面未过
			status="-1";
			
		}
		Access c = new Access();
		c.setType(type);
		c.setUser_id(student_id);
		c.setSupplement(supplement);
		c.setBasescore(basescore);
		c.setTechnicalscore(technicalscore);
		c.setStudyability(studyability);
		c.setAttitude(attitude);

		boolean b1 = accessService.addAccess(c);// 添加评价信息
		boolean b2 = studentService.changeStatus(student_id, status);// 根据学生学号改变学生的面试状态
		 
		//boolean b3=studentService.changeDirection(student_id,direction);//根据学生学号改变学生的面试方向
		if (b1 == true && b2 == true) {
			json.put("result", true);
		} else {
			json.put("result", false);
		}
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/returnMessage")//返回学生的评价信息
	public String returnMessage(HttpServletRequest request,HttpServletResponse response)  {//管理员根据学生学号返回学生信息及面试的评价信息
		 
		JSONObject  json=new JSONObject();
		JSONObject  access1=new JSONObject();
		JSONObject  access2=new JSONObject();
		JSONObject  access=new JSONObject();
		String student_id=request.getParameter("student_id");//学生学号
		User stu=new User();
		try {
			List<Access> as=accessService.returnMessage(student_id);
			stu=studentService.findAllByUserId(student_id);
			if(as.size()>=1){
				for(Access r:as){	
					if(r.getType()==1){
				
						access1.put("supplement",r.getSupplement());
						access1.put("basescore",r.getBasescore());
						access1.put("technicalscore",r.getTechnicalscore());
						access1.put("studyability",r.getStudyability());
						access1.put("attitude",r.getAttitude());
						access1.put("type",r.getType());
					}
					else if(r.getType()==2){
			
						access2.put("supplement",r.getSupplement());
						access2.put("basescore",r.getBasescore());
						access2.put("technicalscore",r.getTechnicalscore());
						access2.put("studyability",r.getStudyability());
						access2.put("attitude",r.getAttitude());
						access2.put("type",r.getType());
				}
		 
			}
		}
 				access.put("first", access1);
 				access.put("second", access2);
				json.put("student_id",stu.getUser_id());
				json.put("student_name", stu.getUser_name());
				json.put("student_class", stu.getUser_class());
				json.put("phone_number",stu.getPhone_number());
				json.put("direction", stu.getDirection());
				json.put("status", stu.getStatus());
				json.put("access", access);	
				 
 				 
 				 
	}catch (Exception e) {
		e.printStackTrace();
	}
	return json.toString();
		
	}
		 
		 
		 
		

	 
	 

}
 