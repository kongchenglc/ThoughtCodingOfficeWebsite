package com.tc.tccp.web.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tc.tccp.core.entity.Access;
import com.tc.tccp.web.dao.AccessDao;
import com.tc.tccp.web.service.AccessService;

/**
 * @author wangpei
 * @version 创建时间：2016年12月12日 下午6:46:28 类说明
 */
@Service
@Transactional
public class AccessServiceImpl implements AccessService {

	@Autowired
	private AccessDao accessDao;

	public boolean addAccess(Access as) {
		try {

			return accessDao.addAccess(as);
		} catch (Exception e) {
			return false;
		}
	}

	public List<Access> returnMessage(String student_id) {
		try {

			return accessDao.returnMessage(student_id);
			// return us;
		} catch (Exception e) {

			return null;
		}
	}

}
