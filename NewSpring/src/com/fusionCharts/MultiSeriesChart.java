package com.fusionCharts;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fusionCharts.common.Category;
import com.fusionCharts.common.Dataset;
import com.fusionCharts.common.Line;
import com.fusionCharts.common.Set;
import com.fusionCharts.common.style.Apply;
import com.fusionCharts.common.style.FontStyle;
import com.fusionCharts.common.style.Style;
import com.fusionCharts.common.style.Styles;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

public class MultiSeriesChart extends Chart {
	private String SYAxisName;
	private String PYAxisname;
	
	private String ShowLabels;
	
	private String SYAxisMaxValue;
	private String PYAxisMaxValue;
	
	private String AnchorRadius;
	
	private String ZeroPlaneColor;
	private String zeroPlaneAlpha;
	private String zeroPlaneBorderColor;
	
	
	public String getZeroPlaneColor() {
		return ZeroPlaneColor;
	}
	public void setZeroPlaneColor(String zeroPlaneColor) {
		ZeroPlaneColor = zeroPlaneColor;
	}
	public String getZeroPlaneAlpha() {
		return zeroPlaneAlpha;
	}
	public void setZeroPlaneAlpha(String zeroPlaneAlpha) {
		this.zeroPlaneAlpha = zeroPlaneAlpha;
	}
	public String getZeroPlaneBorderColor() {
		return zeroPlaneBorderColor;
	}
	public void setZeroPlaneBorderColor(String zeroPlaneBorderColor) {
		this.zeroPlaneBorderColor = zeroPlaneBorderColor;
	}
	public String getAnchorRadius() {
		return AnchorRadius;
	}
	public void setAnchorRadius(String anchorRadius) {
		AnchorRadius = anchorRadius;
	}
	private LinkedList<Category> category ;
	private LinkedList<Dataset> dataset ;
	public MultiSeriesChart(){
		super();
	}
	public String getShowLabels() {
		return ShowLabels;
	}
	public void setShowLabels(String showLabels) {
		ShowLabels = showLabels;
	}
	public MultiSeriesChart(String caption,String bgColor,String showValues){
		super(caption,bgColor,showValues);
	}
	
	public String toXML(){
		XStream xstream = new XStream();
		xstream.alias("chart", this.getClass());
		xstream.alias("category", Category.class);
		xstream.alias("dataset", Dataset.class);
		xstream.alias("set", Set.class);
		xstream.alias("line", Line.class);
		
		xstream.aliasAttribute(Chart.class, "line", "trendLines");
		xstream.useAttributeFor(Chart.class, "line");
		
		xstream.aliasAttribute(this.getClass(), "category", "categories");
		xstream.useAttributeFor(this.getClass(), "category");
		
		xstream.addImplicitCollection(this.getClass(), "dataset", Dataset.class);
		xstream.addImplicitCollection(Dataset.class, "set", Set.class);
		
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
		field = Category.class.getDeclaredFields();
		for (int i=0;i<field.length;i++){
			xstream.useAttributeFor(Category.class, field[i].getName());
		}
		
		field = Dataset.class.getDeclaredFields();
		for (int i=0;i<field.length;i++){
			xstream.useAttributeFor(Dataset.class, field[i].getName());
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
	
	public void setDataset(LinkedList<Dataset> dataset){
		this.dataset = dataset;
	}
	public void addDataset(Dataset dataset){
		this.dataset.add(dataset);
	}
	public Dataset shiftDataset(){
		Dataset category = this.dataset.get(0);
		this.dataset.remove(0);
		return category;
	}
	public void clearDataset(){
		this.dataset = new LinkedList<Dataset>();
	}
	public List<Dataset> getDataset(){
		return this.dataset;
	}
	public void setCategory(LinkedList<Category> category){
		this.category = category;
	}
	public void addCategory(Category category){
		this.category.add(category);
	}
	public Category shiftCategory(){
		Category category = this.category.get(0);
		this.category.remove(0);
		return category;
	}
	public void clearCategory(){
		this.category = new LinkedList<Category>();
	}
	public List<Category> getCategory(){
		return this.category;
	}
	public String getSYAxisName() {
		return SYAxisName;
	}
	public void setSYAxisName(String axisName) {
		SYAxisName = axisName;
	}
	public String getPYAxisname() {
		return PYAxisname;
	}
	public void setPYAxisname(String axisname) {
		PYAxisname = axisname;
	}
	public String getSYAxisMaxValue() {
		return SYAxisMaxValue;
	}
	public void setSYAxisMaxValue(String axisMaxValue) {
		SYAxisMaxValue = axisMaxValue;
	}
	public String getPYAxisMaxValue() {
		return PYAxisMaxValue;
	}
	public void setPYAxisMaxValue(String axisMaxValue) {
		PYAxisMaxValue = axisMaxValue;
	}
	public static void main(String args[]){
		MultiSeriesChart chart = new MultiSeriesChart();
		chart.setCaption("标题");
		chart.setSubCaption("子标题");
		LinkedList<Category> list = new LinkedList<Category>();
		Category ca = new Category("aaa");
		list.add(ca);
		ca = new Category("bbb");
		list.add(ca);
		ca = new Category("ccc");
		list.add(ca);
		ca = new Category("adddaa");
		list.add(ca);
		chart.setCategory(list);
		
		
		
		LinkedList<Dataset> list2 = new LinkedList<Dataset>();
		Dataset ds = new Dataset("000000", "A", "1");
		ds.setSet("1,2,3,4".split(","));
		list2.add(ds);
		ds = new Dataset("000000", "A", "1");
		ds.setSet("1,2,3,4".split(","));
		list2.add(ds);
		
		ds = new Dataset("000000", "A", "1");
		ds.setSet("1,2,3,4".split(","));
		list2.add(ds);
		
		ds = new Dataset("000000", "A", "1");
		ds.setSet("1,2,3,4".split(","));
		list2.add(ds);
		
		ds = new Dataset("000000", "A", "1");
		ds.setSet("1,2,3,4".split(","));
		list2.add(ds);
		chart.setDataset(list2);
		
		chart.setLine("100");
		
		List<Style> definition = new ArrayList<Style>();
		FontStyle dataLabelFont = new FontStyle("dataLabelFont");
		dataLabelFont.setSize("12");
		dataLabelFont.setColor("00FF00");
		dataLabelFont.setBold("1");
		definition.add(dataLabelFont);
		
		List<Apply> application = new ArrayList<Apply>();
		Apply dataLabels = new Apply("DATALABELS", dataLabelFont.getName());
		application.add(dataLabels);
		
		Styles styles = new Styles();
		styles.setDefinition(definition);
		styles.setApplication(application);
		chart.setStyles(styles);
		
		System.out.print(chart.toXML());
	}
}
