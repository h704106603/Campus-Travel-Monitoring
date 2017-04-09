package com.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fusionCharts.Chart;
import com.fusionCharts.common.Category;
import com.fusionCharts.common.Dataset;
import com.fusionCharts.common.Datasets;
import com.fusionCharts.common.Lineset;
import com.fusionCharts.common.MultiSeriesStackedChart2;
import com.fusionCharts.common.Set;
import com.fusionCharts.common.style.AnimationStyle;
import com.fusionCharts.common.style.Apply;
import com.fusionCharts.common.style.FontStyle;
import com.fusionCharts.common.style.Style;
import com.fusionCharts.common.style.Styles;
import com.service.FushionChartsTestService;

@Service("fushionChartsTestService")
public class FushionChartsTestServiceImpl implements FushionChartsTestService{

	@javax.annotation.Resource(name="LocalOracleDao")
	private com.dao.LocalOracleDao LocalOracleDao;
	
	public Map<String, Object> init() {
		return this.getData(false);
		
	}
	
	public Map<String,Object> getData(boolean flag){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		try {
			date = df.parse(df.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> reMap = new HashMap<String, Object>();
		
		try{
			String re = bar("微厅登录");
			reMap.put("fushion", re);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return reMap;
		
	}
	
	private String bar(String caption) {
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat dft = new SimpleDateFormat("yyyyMMdd");
		MultiSeriesStackedChart2 chart = new MultiSeriesStackedChart2(caption+"小时量(刷新周期5分钟) "+format2.format(new Date()), "000000", "0");
		setStyle(chart);
		chart.setBgAlpha("100");
		//chart.setSubCaption(format2.format(new Date()));
		chart.setPalette("3");
		chart.setToolTipBgColor("000000");
		chart.setShowBorder("1");
		chart.setBaseFontSize("14");
		chart.setShowPlotBorder("1");
		chart.setLabelStep("1");
		chart.setSlantLabels("1");
		chart.setCanvasBgColor("000000");
		chart.setBorderAlpha("100");
		chart.setBorderColor("FFFFFF");
		chart.setDivLineColor("D49B8B");
		chart.setLegendBgColor("000000");
		chart.setLegendBorderColor("415D6F");
		chart.setBaseFontColor("00FF00");
		LinkedList<Category> categories = new LinkedList<Category>();
		
		//控制三个图颜色区分
		String color1 = "1369C7";
		String color2 = "FFF200";
		String color3 = "00ff00";
		
		String name = new String();
		
		Lineset DataSet1 = new Lineset(color1, "平日"+name+"量", new LinkedList<Set>(), "0");
		
		Dataset DataSet2 = new Dataset(color2, "今日"+name+"量", new LinkedList<Set>(), "0");
		Dataset DataSet3 = new Dataset(color3, "去年同时刻"+name+"量", new LinkedList<Set>(), "0");
		//DataSet1.setRenderAs("Line");
		//DataSet4.setRenderAs("Line");
		LinkedList<Dataset> datasets_1 = new LinkedList<Dataset>();
		LinkedList<Datasets> datasets1 = new LinkedList<Datasets>();
		LinkedList<Lineset> Linesets = new LinkedList<Lineset>();
		Datasets dts1 = new Datasets(datasets_1);
		dts1.addDataset(DataSet2);
		datasets1.add(dts1);
		
		LinkedList<Dataset> datasets2 = new LinkedList<Dataset>();
		Datasets dts2 = new Datasets(datasets2);
		dts2.addDataset(DataSet3);
		datasets1.add(dts2);
		
		Linesets.add(DataSet1);
		
		try {
			
			/*List<Object[]> list = new ArrayList<Object[]>();
			Object[] area1={"01","30","20","23"};
			Object[] area2={"02","32","11","23"};
			Object[] area3={"03","4","34","24"};
			Object[] area4={"04","55","21","25"};
			Object[] area5={"05","66","30","20"};
			Object[] area6={"06","44","20","20"};
			Object[] area7={"07","21","23","20"};
			Object[] area8={"08","33","23","21"};
			Object[] area9={"09","44","43","12"};
			Object[] area10={"10","21","32","18"};
			list.add(area1);
			list.add(area2);
			list.add(area3);
			list.add(area4);
			list.add(area5);
			list.add(area6);
			list.add(area7);
			list.add(area8);
			list.add(area9);
			list.add(area10);*/
			String sql = "select time,value1,value2,value3 from bigdataexceptionpie t";
			List<Object[]> list = LocalOracleDao.getResultForSql(sql);
			if(list!=null && list.size()>0){
				for (Object[] objData : list) {
					String time = objData[0]==null ? "" : String.valueOf(objData[0]);
					String value1 = objData[1]==null ? "0" : String.valueOf(objData[1]); //今日
					String value2 = objData[2]==null ? "0" : String.valueOf(objData[2]); //平日
					String value3 = objData[3]==null ? "0" : String.valueOf(objData[3]); //预测
					
					categories.add(new Category(time));
					DataSet1.getSet().add(new Set(value2));
					DataSet2.getSet().add(new Set(value1));
					DataSet3.getSet().add(new Set(value3));
				}
			}

		} catch (Exception e) {
			chart.setBgColor("668800");
			e.printStackTrace();
		}
		datasets_1.add(DataSet2);
		datasets2.add(DataSet3);
		chart.setCategory(categories);
		chart.setDatasets(datasets1);
		chart.setLineset(Linesets);
		return chart.toXML();
	}
	
	
	private void setStyle(Chart chart) {
		String captionFont = "captionFont";
		String subcaptionFont = "subcaptionFont";
		String anchorsAnimation = "anchorsAnimation";
		
		List<Style> definition = new ArrayList<Style>();
		definition.add(new FontStyle(captionFont, "15", "00FF00", "1"));
		definition.add(new FontStyle(subcaptionFont, "12", "00FF00", "1"));
		definition.add(new AnimationStyle(anchorsAnimation));
		
		List<Apply> application = new ArrayList<Apply>();
		application.add(new Apply("CAPTION", captionFont));
		application.add(new Apply("SUBCAPTION", subcaptionFont));
		application.add(new Apply("ANCHORS", anchorsAnimation));
		
		Styles styles = new Styles(definition, application);
		chart.setStyles(styles);
	}
}
