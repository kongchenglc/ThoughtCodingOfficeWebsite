package com.tc.tccp.web.service;

import java.util.List;

import com.tc.tccp.core.entity.Access;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月12日 下午6:46:55 
 * 类说明 
 */
public interface AccessService {
	public boolean addAccess(Access as);//添加评价信息
	public List<Access> returnMessage(String student_id);//查找学生的所有评价信息
}
 