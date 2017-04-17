package com.entity;

/**
 * 数据库中查到的学生出入信息的字段
 * @author Administrator
 *
 */
public class StudentLocationFromDbCommand {

	private String studentId;
	 
	private String time;
	
	private String place;
	
	private String type;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public StudentLocationFromDbCommand(String studentId, String time, String place, String type) {
		super();
		this.studentId = studentId;
		this.time = time;
		this.place = place;
		this.type = type;
	}

	public StudentLocationFromDbCommand() {
		super();
	}
	
	
}
