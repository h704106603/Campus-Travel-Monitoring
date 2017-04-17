package com.entity;

public class TheatreShowDetails {
	
	private String id;

	private String name;
	
	private String imgSrc;
	
	private String time;
	
	private String count;

	
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

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public TheatreShowDetails(String id, String name, String imgSrc, String time, String count) {
		super();
		this.id = id;
		this.name = name;
		this.imgSrc = imgSrc;
		this.time = time;
		this.count = count;
	}

	public TheatreShowDetails() {
		super();
	}
	
	
	
}
