package com.entity;


public class Student {

	private String id;
	private String name;
	private String grade;//这里指班级
	private String password;
	
	public Student(String id, String name, String grade, String password) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.password = password;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, String grade) {

		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
