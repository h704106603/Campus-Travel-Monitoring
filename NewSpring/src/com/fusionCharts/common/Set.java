package com.fusionCharts.common;

public class Set {
	private String label;
	private String value;
	private String color;
	private String isSliced;
	private String tooltext;
	
	public Set(){
		
	}
	public Set(String label,String value,String color){
		this.label = label;
		this.value = value;
		this.color = color;
	}
	public Set(String value){
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getIsSliced() {
		return isSliced;
	}
	public void setIsSliced(String isSliced) {
		this.isSliced = isSliced;
	}
	/**
	 * @return the tooltext
	 */
	public String getTooltext() {
		return tooltext;
	}
	/**
	 * @param tooltext the tooltext to set
	 */
	public void setTooltext(String tooltext) {
		this.tooltext = tooltext;
	}

}
