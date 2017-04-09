package com.fusionCharts.common;

import java.util.LinkedList;

public class Dataset {
	private String showValues;
	private String color;
	private String seriesName;
	private LinkedList<Set> set;
	
	private String parentYAxis;
	private String renderAs;
	private String lineThickness;
	private String includeInLegend;
	
	public Dataset(){
		
	}
	public Dataset(String color, String seriesName, String showValues) {
		super();
		this.color = color;
		this.seriesName = seriesName;
		this.showValues = showValues;
	}
	public Dataset(String color, String seriesName, LinkedList<Set> set, String showValues) {
		super();
		this.color = color;
		this.seriesName = seriesName;
		this.set = set;
		this.showValues = showValues;
	}
	public Dataset(String seriesName, LinkedList<Set> set, String showValues) {
		super();
		this.seriesName = seriesName;
		this.set = set;
		this.showValues = showValues;
	}


	public String getShowValues() {
		return showValues;
	}
	public void setShowValues(String showValues) {
		this.showValues = showValues;
	}
	public String getIncludeInLegend() {
		return includeInLegend;
	}
	public void setIncludeInLegend(String includeInLegend) {
		this.includeInLegend = includeInLegend;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public String getParentYAxis() {
		return parentYAxis;
	}
	public void setParentYAxis(String parentYAxis) {
		this.parentYAxis = parentYAxis;
	}
	public String getRenderAs() {
		return renderAs;
	}
	public void setRenderAs(String renderAs) {
		this.renderAs = renderAs;
	}
	public String getLineThickness() {
		return lineThickness;
	}
	public void setLineThickness(String lineThickness) {
		this.lineThickness = lineThickness;
	}
	public LinkedList<Set> getSet() {
		return set;
	}
	public void setSet(String [] valueList) {
		LinkedList<Set> sett = new LinkedList<Set>();
		for (int i=0;i<valueList.length;i++){
			if (valueList[i].equals("")){
				Set set = new Set();
				sett.add(set);
			}else{
				Set set = new Set(valueList[i]);
				sett.add(set);
			}
		}
		this.set = sett;
	}
	public void setSet(LinkedList<Set> set) {
		this.set = set;
	}
	
}
