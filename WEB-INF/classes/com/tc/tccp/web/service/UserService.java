package com.tc.tccp.web.service; 

import java.util.List;

import com.tc.tccp.core.entity.User;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月12日 下午6:45:20 
 * 类说明 
 */
public interface UserService {

	public User findRegist(String user_id, String password);//管理员根据工号密码登录
	public boolean addUser(User stu);//学生报名,注册学生
	public User findAllByUserId(String user_id);//根据学号查找学生的情况
	public List<User> findUserByDirection(String direction);//查找某个方向的学生信息
	public List<User> findAllUserByUserStatus(String status);//查找某个状态的所有学生信息
	public List<User> findAllUserOfStudent();//查找所有学生的信息
 	
	public boolean changeStatus(String user_id,String status);//改变学生面试状态状态
	public boolean changeDirection(String user_id,String direction);//改变学生面试方向
	public List<User> findAllUserByStatusAndDirectioon(String status,String direction);//查找某个方向，某个状态的学生信息

	 
	 
	 
	 

}
 