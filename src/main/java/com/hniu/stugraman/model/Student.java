package com.hniu.stugraman.model;

import java.util.List;

/**
 * 学生类
 * @author bojiangzhou
 *
 */
public class Student {
	
	private int id; //ID
	
	private String number; //学号
	
	private String name; //姓名
	
	private String sex; //性别
	
	private String phone; //电话
	
	private String qq; //QQ
	
	private int clazzid; //班级ID

	private List<EScore> scores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public int getClazzid() {
		return clazzid;
	}

	public void setClazzid(int clazzid) {
		this.clazzid = clazzid;
	}

	public List<EScore> getScores() {
		return scores;
	}

	public void setScores(List<EScore> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", number='" + number + '\'' +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", phone='" + phone + '\'' +
				", qq='" + qq + '\'' +
				", clazzid=" + clazzid +
				", scores=" + scores +
				'}';
	}
}
