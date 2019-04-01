package com.driving.User;

public class Agency {
	private int aid; // 主键
	private int agent_level; // 等级
	private String agent_name; // 名字
	private String agent_passwd; // 密码
	private String agent_phone; // 手机号
	private String agent_id; // 身份证
	private String agent_school; // 学校
	private String agent_email; // 邮箱
	private int agent_stucount; // 学员个数
	private int agent_todaystu;//今日新增学员个数
	
	public int getAgent_todaystu() {
		return agent_todaystu;
	}

	public void setAgent_todaystu(int agent_todaystu) {
		this.agent_todaystu = agent_todaystu;
	}

	private String agent_iamgeurl; // 图片

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAgent_level() {
		return agent_level;
	}

	public void setAgent_level(int agent_level) {
		this.agent_level = agent_level;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public String getAgent_passwd() {
		return agent_passwd;
	}

	public void setAgent_passwd(String agent_passwd) {
		this.agent_passwd = agent_passwd;
	}

	public String getAgent_phone() {
		return agent_phone;
	}

	public void setAgent_phone(String agent_phone) {
		this.agent_phone = agent_phone;
	}

	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

	public String getAgent_school() {
		return agent_school;
	}

	public void setAgent_school(String agent_school) {
		this.agent_school = agent_school;
	}

	public String getAgent_email() {
		return agent_email;
	}

	public void setAgent_email(String agent_email) {
		this.agent_email = agent_email;
	}

	public int getAgent_stucount() {
		return agent_stucount;
	}

	public void setAgent_stucount(int agent_stucount) {
		this.agent_stucount = agent_stucount;
	}

	public String getAgent_iamgeurl() {
		return agent_iamgeurl;
	}

	public void setAgent_iamgeurl(String agent_iamgeurl) {
		this.agent_iamgeurl = agent_iamgeurl;
	}

	@Override
	public String toString() {
		return "Agency [aid=" + aid + ", agent_level=" + agent_level + ", agent_name=" + agent_name + ", agent_passwd="
				+ agent_passwd + ", agent_phone=" + agent_phone + ", agent_id=" + agent_id + ", agent_school="
				+ agent_school + ", agent_email=" + agent_email + ", agent_stucount=" + agent_stucount
				+ ", agent_todaystu=" + agent_todaystu + ", agent_iamgeurl=" + agent_iamgeurl + "]";
	}


	
	

}
