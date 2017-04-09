package com.fusionCharts;

import java.util.LinkedList;

import com.fusionCharts.common.Set;

public class MyChart extends SingleSeriesChart {
	private String aaa="" ;
	public String bbbbb ="dddd";
	
	public static void main(String args[]){
		MyChart chart = new MyChart();
		chart.setCaption("标题");
		chart.setSubCaption("子标题");
		LinkedList<Set> list = new LinkedList<Set>();
		Set set = new Set("A","10","000000");
		list.add(set);
		set = new Set("B","10","00FF00");
		list.add(set);
		set = new Set("C","13","0000FF");
		list.add(set);
		set = new Set("D","14","FF0000");
		list.add(set);
		set = new Set();
		list.add(set);
		chart.setSet(list);
		//chart.toXML();
		chart.setLine("100");
		System.out.print(chart.toXML().replaceAll("\"", "'"));
	}
}
