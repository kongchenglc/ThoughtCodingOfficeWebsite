package com.tc.tccp.web.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tc.tccp.core.entity.User;
import com.tc.tccp.web.dao.UserDao;
import com.tc.tccp.web.service.UserService;

/**
 * @author wangpei
 * @version 创建时间：2016年12月12日 下午6:45:43 类说明 s
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User findRegist(String user_name, String password) {
		try {

			return userDao.findRegist(user_name, password);

		} catch (Exception e) {

			return null;
		}
	}

	public boolean addUser(User stu) {
		try {

			return userDao.addUser(stu);
			// return us;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean changeStatus(String user_id, String status) {
		try {

			return userDao.changeStatus(user_id, status);

		} catch (Exception e) {

			return false;
		}
	}

	public boolean changeDirection(String user_id, String direction) {
		try {

			return userDao.changeDirection(user_id, direction);

		} catch (Exception e) {

			return false;
		}
	}
  //任意用户根据学号返回用户状态
	public User findAllByUserId(String user_id) {
		try {

			return userDao.findAllByUserId(user_id);

		} catch (Exception e) {

			return null;
		}
	}

	 

	public List<User> findUserByDirection(String direction) {
		try {

			return userDao.findUserByDirection(direction);

		} catch (Exception e) {

			return null;
		}
	}

	public List<User> findAllUserOfStudent() {
		try {

			return userDao.findAllUserOfStudent();

		} catch (Exception e) {

			return null;
		}
	}

	public List<User> findAllUserByUserStatus(String status) {
		try {

			return userDao.findAllUserByUserStatus(status);

		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<User> findAllUserByStatusAndDirectioon(String status,
			String direction) {
		try {

			return userDao.findAllUserByStatusAndDirectioon(status, direction);

		} catch (Exception e) {

			return null;
		}	}

	  
 
}
