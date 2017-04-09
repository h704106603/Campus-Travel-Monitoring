package com.fusionCharts;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fusionCharts.common.Line;
import com.fusionCharts.common.Set;
import com.fusionCharts.common.style.AnimationStyle;
import com.fusionCharts.common.style.Apply;
import com.fusionCharts.common.style.FontStyle;
import com.fusionCharts.common.style.Style;
import com.fusionCharts.common.style.Styles;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

public class SingleSeriesChart extends Chart {
	private LinkedList<Set> set ;
	public SingleSeriesChart(){
		super();
	}
	public SingleSeriesChart(String caption,String bgColor,String showValues){
		super(caption,bgColor,showValues);
	}
	
	public String toXML(){
		XStream xstream = new XStream();
		xstream.alias("chart", this.getClass());
		xstream.alias("set", Set.class);
		xstream.alias("line", Line.class);
		xstream.addImplicitCollection(this.getClass(), "set", Set.class);
		
		xstream.aliasAttribute(Chart.class, "line", "trendLines");
		xstream.useAttributeFor(Chart.class, "line");
		
//		xstream.alias("style", FontStyle.class);
		xstream.alias("style", Style.class);
		xstream.alias("apply", Apply.class);
		
		Field [] field = this.getClass().getDeclaredFields();
		for (int i=0;i<field.length;i++){
			xstream.useAttributeFor(this.getClass(), field[i].getName());
		}
		field = Chart.class.getDeclaredFields();
		for (int i=0;i<field.length;i++){
			xstream.useAttributeFor(Chart.class, field[i].getName());
		}
		field = Set.class.getDeclaredFields();
		for (int i=0;i<field.length;i++){
			xstream.useAttributeFor(Set.class, field[i].getName());
		}
		field = Line.class.getDeclaredFields();
		for (int i=0;i<field.length;i++){
			xstream.useAttributeFor(Line.class, field[i].getName());
		}
		field = Style.class.getDeclaredFields();
		for (int i=0;i<field.length;i++) {
			xstream.useAttributeFor(Style.class, field[i].getName());
		}
//		field = FontStyle.class.getDeclaredFields();
//		for (int i=0;i<field.length;i++) {
//			xstream.useAttributeFor(FontStyle.class, field[i].getName());
//		}
		try {
			for (Style style : this.getStyles().getDefinition()) {
				xstream.alias("style", style.getClass());
				field = style.getClass().getDeclaredFields();
				for (int i=0;i<field.length;i++) {
					xstream.useAttributeFor(style.getClass(), field[i].getName());
				}
			}
		} catch (Exception e) {
		}
		field = Apply.class.getDeclaredFields();
		for (int i=0;i<field.length;i++) {
			xstream.useAttributeFor(Apply.class, field[i].getName());
		}
		StringWriter sw = new StringWriter();
		xstream.marshal(this, new PrettyPrintWriter(sw));
		return sw.toString().replaceAll("\"", "'").replaceAll("\r\n", "").replaceAll("\n", "");
	}
	
	public void setSet(LinkedList<Set> set){
		this.set = set;
	}
	public void addSet(Set set){
		this.set.add(set);
	}
	public Set shiftSet(){
		Set set = this.set.get(0);
		this.set.remove(0);
		return set;
	}
	public void clearSet(){
		this.set = new LinkedList<Set>();
	}
	public List<Set> getSet(){
		return this.set;
	}
	
	
	public static void main(String args[]){
		SingleSeriesChart chart = new SingleSeriesChart();
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
		chart.setSet(list);
		
		chart.setLine("00FF00", "告警", "111");
		List<Style> definition = new ArrayList<Style>();
		FontStyle dataLabelFont = new FontStyle("dataLabelFont");
		dataLabelFont.setSize("12");
		dataLabelFont.setColor("00FF00");
		dataLabelFont.setBold("1");
		definition.add(dataLabelFont);
		definition.add(new AnimationStyle("electronic", AnimationStyle.Param._x.value, "0", "1", "elastic"));
		
		List<Apply> application = new ArrayList<Apply>();
		Apply dataLabels = new Apply("DATALABELS", dataLabelFont.getName());
		application.add(dataLabels);
		application.add(new Apply("DATAPLOT", "electronic"));
		
		Styles styles = new Styles(definition, application);
		chart.setStyles(styles);
		
		System.out.print(chart.toXML());
		
	}
}
