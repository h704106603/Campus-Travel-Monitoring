package com.entity;

/**
 * 数据库中查到的学生出入信息的字段
 * @author Administrator
 *
 */
public class StudentLocationFromDbCommand {

	//学生id
	private String studentId;
	 
	//出入时间
	private String time;
	
	//出入地点
	private String place;
	
	//出入类型
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
