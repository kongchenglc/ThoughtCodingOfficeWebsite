package com.tc.tccp.core.entity;

/**
 * @author wangpei
 * @version 创建时间：2016年12月12日 下午6:25:37 类说明
 */

public class Access {

	private int access_id;
	private String user_id;
	private String supplement;
	private int basescore;
	private int technicalscore;
	private int studyability;
	private int attitude;
	private int type;

	public Access() {
	}

	public Access(String user_id, String supplement, int basescore,
			int technicalscore, int studyability, int attitude, int type) {
		this.user_id = user_id;
		this.supplement = supplement;
		this.basescore = basescore;
		this.technicalscore = technicalscore;
		this.studyability = studyability;
		this.attitude = attitude;
		this.type = type;

	}

	public int getAccess_id() {
		return access_id;
	}

	public void setAccess_id(int access_id) {
		this.access_id = access_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSupplement() {
		return supplement;
	}

	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}

	public int getBasescore() {
		return basescore;
	}

	public void setBasescore(int basescore) {
		this.basescore = basescore;
	}

	public int getTechnicalscore() {
		return technicalscore;
	}

	public void setTechnicalscore(int technicalscore) {
		this.technicalscore = technicalscore;
	}

	public int getStudyability() {
		return studyability;
	}

	public void setStudyability(int studyability) {
		this.studyability = studyability;
	}

	public int getAttitude() {
		return attitude;
	}

	public void setAttitude(int attitude) {
		this.attitude = attitude;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
