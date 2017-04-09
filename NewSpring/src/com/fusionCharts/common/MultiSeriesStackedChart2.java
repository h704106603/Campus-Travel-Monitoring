package com.fusionCharts.common;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.fusionCharts.Chart;
import com.fusionCharts.common.Category;
import com.fusionCharts.common.Dataset;
import com.fusionCharts.common.Datasets;
import com.fusionCharts.common.Line;
import com.fusionCharts.common.Lineset;
import com.fusionCharts.common.Set;
import com.fusionCharts.common.style.Apply;
import com.fusionCharts.common.style.Style;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

public class MultiSeriesStackedChart2 extends Chart {
	private String SYAxisName;
	private String PYAxisname;
	private String PYAxisMaxValue;
	private String SYAxisMaxValue;
	private String yAxisNamePadding;
	private String anchorBorderColor;
	private String anchorRadius;
	private String anchorSides;
	private String anchorBgColor;
	private String anchorAlpha;
	private String lineAlpha;
	
	public String getAnchorBorderColor() {
		return anchorBorderColor;
	}
	public void setAnchorBorderColor(String anchorBorderColor) {
		this.anchorBorderColor = anchorBorderColor;
	}
	public String getAnchorRadius() {
		return anchorRadius;
	}
	public void setAnchorRadius(String anchorRadius) {
		this.anchorRadius = anchorRadius;
	}
	public String getAnchorSides() {
		return anchorSides;
	}
	public void setAnchorSides(String anchorSides) {
		this.anchorSides = anchorSides;
	}
	public String getAnchorBgColor() {
		return anchorBgColor;
	}
	public void setAnchorBgColor(String anchorBgColor) {
		this.anchorBgColor = anchorBgColor;
	}
	public String getAnchorAlpha() {
		return anchorAlpha;
	}
	public void setAnchorAlpha(String anchorAlpha) {
		this.anchorAlpha = anchorAlpha;
	}
	public String getLineAlpha() {
		return lineAlpha;
	}
	public void setLineAlpha(String lineAlpha) {
		this.lineAlpha = lineAlpha;
	}
	public String getyAxisNamePadding() {
		return yAxisNamePadding;
	}
	public void setyAxisNamePadding(String yAxisNamePadding) {
		this.yAxisNamePadding = yAxisNamePadding;
	}
	private String showSum;
	private String showLabels;
//	private String useRoundEdges;
	
	private LinkedList<Category> category ;
	public String getShowLabels() {
		return showLabels;
	}
	public void setShowLabels(String showLabels) {
		this.showLabels = showLabels;
	}
	private LinkedList<Datasets> datasets ;
	private LinkedList<Lineset> lineset;
	
	public MultiSeriesStackedChart2(){
		super();
	}
	public MultiSeriesStackedChart2(String caption,String bgColor,String showValues){
		super(caption,bgColor,showValues);
	}
	
	public String toXML(){
		XStream xstream = new XStream();
		xstream.alias("chart", this.getClass());
		xstream.alias("category", Category.class);
		xstream.alias("dataset", Dataset.class);
		xstream.alias("dataset", Datasets.class);
		xstream.alias("lineset", Lineset.class);
		xstream.alias("set", Set.class);
		xstream.alias("line", Line.class);
		
		xstream.alias("style", Style.class);
		xstream.alias("apply", Apply.class);
		
		xstream.aliasAttribute(this.getClass(), "category", "categories");
		xstream.useAttributeFor(this.getClass(), "category");
		
		xstream.addImplicitCollection(this.getClass(), "datasets", Datasets.class);
		xstream.addImplicitCollection(Datasets.class, "dataset", Dataset.class);
		xstream.addImplicitCollection(Dataset.class, "set", Set.class);
		
		xstream.aliasAttribute(Chart.class, "line", "trendLines");
		xstream.useAttributeFor(Chart.class, "line");
		
		xstream.addImplicitCollection(this.getClass(), "lineset", Lineset.class);
		xstream.addImplicitCollection(Lineset.class, "set", Set.class);
		
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
		
		field = Datasets.class.getDeclaredFields();
		for (int i=0;i<field.length;i++){
			xstream.useAttributeFor(Datasets.class, field[i].getName());
		}
		
		field = Dataset.class.getDeclaredFields();
		for (int i=0;i<field.length;i++){
			xstream.useAttributeFor(Dataset.class, field[i].getName());
		}
		
		field = Lineset.class.getDeclaredFields();
		for (int i=0;i<field.length;i++){
			xstream.useAttributeFor(Lineset.class, field[i].getName());
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
	
	public void setDatasets(LinkedList<Datasets> datasets){
		this.datasets = datasets;
	}
	public void addDatasets(Datasets datasets){
		this.datasets.add(datasets);
	}
	public Datasets shiftDatasets(){
		Datasets datasets = this.datasets.get(0);
		this.datasets.remove(0);
		return datasets;
	}
	public void clearDatasets(){
		this.datasets = new LinkedList<Datasets>();
	}
	public List<Datasets> getDatasets(){
		return this.datasets;
	}

	public String getPYAxisMaxValue() {
		return PYAxisMaxValue;
	}
	public void setPYAxisMaxValue(String axisMaxValue) {
		PYAxisMaxValue = axisMaxValue;
	}
	public String getSYAxisMaxValue() {
		return SYAxisMaxValue;
	}
	public void setSYAxisMaxValue(String axisMaxValue) {
		SYAxisMaxValue = axisMaxValue;
	}
//	public String getUseRoundEdges() {
//		return useRoundEdges;
//	}
//	public void setUseRoundEdges(String useRoundEdges) {
//		this.useRoundEdges = useRoundEdges;
//	}
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
	public String getShowSum() {
		return showSum;
	}
	public void setShowSum(String showSum) {
		this.showSum = showSum;
	}
	public LinkedList<Lineset> getLineset() {
		return lineset;
	}
	public void setLineset(LinkedList<Lineset> lineset) {
		this.lineset = lineset;
	}
	public static void main(String args[]){
		MultiSeriesStackedChart2 chart = new MultiSeriesStackedChart2();
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
		
		
		
		LinkedList<Datasets> list2 = new LinkedList<Datasets>();
		LinkedList<Dataset> list1 = new LinkedList<Dataset>();
		
		Dataset ds = new Dataset();
		ds.setSet("1,2,3,4".split(","));
		list1.add(ds);
		ds = new Dataset("000000", "A", "1");
		ds.setSet("1,2,3,4".split(","));
		list1.add(ds);
		Datasets dss = new Datasets(list1);
		list2.add(dss);
		
		list1 = new LinkedList<Dataset>();
		ds = new Dataset();
		ds.setSet("1,2,55,4".split(","));
		ds.setParentYAxis("P");
		list1.add(ds);
		ds = new Dataset("000000", "A", "1");
		ds.setSet("1,2,3,4".split(","));
		list1.add(ds);
		dss = new Datasets(list1);
		list2.add(dss);
		
		
		chart.setDatasets(list2);
		
		LinkedList<Lineset> lslist = new LinkedList<Lineset>();
		Lineset ls = new Lineset();
		ls.setSeriesName("");
		ls.setSet("1,2,3,4".split(","));
		lslist.add(ls);
		
		ls = new Lineset();
		ls.setSeriesName("");
		ls.setSet("1,5,3,4".split(","));
		lslist.add(ls);
		
		chart.setLineset(lslist);
		
		chart.setLine("100");
		System.out.print(chart.toXML());
	}
}
