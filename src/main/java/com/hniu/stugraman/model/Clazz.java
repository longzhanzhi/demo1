package com.hniu.stugraman.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 班级类
 * @author bojiangzhou
 *
 */
public class Clazz {
	
	private int id; //ID
	
	private String name; //名称

	private List<Student> studentList = new LinkedList<>();// 学生集合

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
