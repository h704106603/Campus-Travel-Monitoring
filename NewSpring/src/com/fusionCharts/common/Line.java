package com.fusionCharts.common;

public class Line {
	private String startValue;
	private String color = "FF0000";
	private String displayvalue;
	private String parentYAxis= "";
	private String showOnTop = "1";
	
	
	public Line() {
		super();
	}
	public Line(String color, String displayvalue, String startValue) {
		super();
		this.color = color;
		this.displayvalue = displayvalue;
		this.startValue = startValue;
	}
	public Line(String startValue) {
		super();
		this.startValue = startValue;
	}
	public Line(String color, String startValue) {
		super();
		this.color = color;
		this.startValue = startValue;
	}
	public String getStartValue() {
		return startValue;
	}
	public void setStartValue(String startValue) {
		this.startValue = startValue;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDisplayvalue() {
		return displayvalue;
	}
	public void setDisplayvalue(String displayvalue) {
		this.displayvalue = displayvalue;
	}
	public String getParentYAxis() {
		return parentYAxis;
	}
	public void setParentYAxis(String parentYAxis) {
		this.parentYAxis = parentYAxis;
	}
	public String getShowOnTop() {
		return showOnTop;
	}
	public void setShowOnTop(String showOnTop) {
		this.showOnTop = showOnTop;
	}
	
	
}
