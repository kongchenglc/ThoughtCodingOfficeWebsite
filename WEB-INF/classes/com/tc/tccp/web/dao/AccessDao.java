package com.tc.tccp.web.dao; 

import java.util.List;

import org.springframework.stereotype.Repository;


import com.tc.tccp.core.entity.Access;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月12日 下午6:44:23 
 * 类说明 
 */
 
public interface AccessDao {
	public boolean addAccess(Access as);//添加评价信息
	public List<Access> returnMessage(String student_id);//查找学生的所有评价信息
	//public List<Access> returnMessage(String student_id);//查找学生的所有评价信息
	
}
 