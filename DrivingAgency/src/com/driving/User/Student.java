package com.driving.User;

public class Student {
	private String sid;
	private String stu_name; // 名字
	private String stu_id; // 身份证
	private String stu_phone; // 手机号
	private String stu_school; // 学校
	private String stu_imageurl; // 身份证图片
	private int aid; // 外键

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_phone() {
		return stu_phone;
	}

	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}

	public String getStu_school() {
		return stu_school;
	}

	public void setStu_school(String stu_school) {
		this.stu_school = stu_school;
	}

	public String getStu_imageurl() {
		return stu_imageurl;
	}

	public void setStu_imageurl(String stu_imageurl) {
		this.stu_imageurl = stu_imageurl;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", stu_name=" + stu_name + ", stu_id=" + stu_id + ", stu_phone=" + stu_phone
				+ ", stu_school=" + stu_school + ", stu_imageurl=" + stu_imageurl + ", aid=" + aid + "]";
	}
	

}
