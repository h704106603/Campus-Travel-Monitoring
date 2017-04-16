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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

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
import com.service.ClassroomService;
import com.util.ResourceUtils;

public class ClassroomServiceImpl implements ClassroomService {

    @javax.annotation.Resource(name="LocalOracleDao")
    private com.dao.LocalOracleDao LocalOracleDao;
    
    
    @Value("classpath:config/Classroom/Classroom.sql")
    private Resource ClassroomSql;
    
    @Value("classpath:config/Classroom/AcademicBuilding1.sql")
    private Resource AcademicBuilding1Sql;
    
    @Value("classpath:config/Classroom/AcademicBuilding2.sql")
    private Resource AcademicBuilding2Sql;
    
    /**
     * 根据教室来查这间教室的近一小时明细情况
     * @param classroom
     * @return
     */
    public Map<String, Object> ClassroomBar(String classroom) {
        return this.getClassroomBarData(classroom);
        
    }
    
    /**
     * 根据教学楼查询当前教学楼内所有教室的当前使用人数柱状图
     * @param AcademicBuilding
     * @return
     */
    public Map<String, Object> AcademicBuildingBar(){
        return this.getAcademicBuildingBarData();
        
    }
    
    public Map<String,Object> getClassroomBarData(String classroom){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        try {
            date = df.parse(df.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Map<String, Object> reMap = new HashMap<String, Object>();
        
        try{
            String re = getClassroomBar(ClassroomSql,classroom);
            reMap.put("ClassroomBar", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return reMap;
        
    }
    
    public Map<String,Object> getAcademicBuildingBarData(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        try {
            date = df.parse(df.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Map<String, Object> reMap = new HashMap<String, Object>();
        
        try{
            String re = getAcademicBuildingBar(AcademicBuilding1Sql,"1");
            reMap.put("AcademicBuilding1", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String re = getAcademicBuildingBar(AcademicBuilding2Sql,"2");
            reMap.put("AcademicBuilding2", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return reMap;
        
    }
    
    
    private String getClassroomBar(Resource Rsql,String classroom) {
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dft = new SimpleDateFormat("yyyyMMdd");
        MultiSeriesStackedChart2 chart = new MultiSeriesStackedChart2(classroom+"教室近一小时情况"+"(刷新周期5分钟) "+format2.format(new Date()), "000000", "0");
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
        
        Lineset DataSet1 = new Lineset(color1, "昨日"+name+"量", new LinkedList<Set>(), "0");
        Dataset DataSet2 = new Dataset(color2, "今日"+name+"量", new LinkedList<Set>(), "0");
        //DataSet1.setRenderAs("Line");
        //DataSet4.setRenderAs("Line");
        LinkedList<Dataset> datasets_1 = new LinkedList<Dataset>();
        LinkedList<Datasets> datasets1 = new LinkedList<Datasets>();
        LinkedList<Lineset> Linesets = new LinkedList<Lineset>();
        Datasets dts1 = new Datasets(datasets_1);
        dts1.addDataset(DataSet2);
        datasets1.add(dts1);
        
        Linesets.add(DataSet1);
        
        try {
            String sql = ResourceUtils.getStringFromResource(Rsql);
            sql = sql.replaceAll("\\{id\\}", classroom);
            List<Object[]> list = LocalOracleDao.getResultForSql(sql);
            if(list!=null && list.size()>0){
                for (Object[] objData : list) {
                    String time = objData[0]==null ? "" : String.valueOf(objData[0]);
                    String value1 = objData[1]==null ? "0" : String.valueOf(objData[1]); //今日
                    String value2 = objData[2]==null ? "0" : String.valueOf(objData[2]); //昨日
                    
                    categories.add(new Category(time));
                    DataSet1.getSet().add(new Set(value2));
                    DataSet2.getSet().add(new Set(value1));
                }
            }

        } catch (Exception e) {
            chart.setBgColor("668800");
            e.printStackTrace();
        }
        datasets_1.add(DataSet2);
        chart.setCategory(categories);
        chart.setDatasets(datasets1);
        chart.setLineset(Linesets);
        return chart.toXML();
    }
    
    
    private String getAcademicBuildingBar(Resource Rsql,String AcademicBuilding) {
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dft = new SimpleDateFormat("yyyyMMdd");
        MultiSeriesStackedChart2 chart = new MultiSeriesStackedChart2(AcademicBuilding+"号楼当前教室情况"+"(刷新周期5分钟) "+format2.format(new Date()), "000000", "0");
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
        
        Dataset DataSet2 = new Dataset(color2, "教室人数", new LinkedList<Set>(), "0");
        //DataSet1.setRenderAs("Line");
        //DataSet4.setRenderAs("Line");
        LinkedList<Dataset> datasets_1 = new LinkedList<Dataset>();
        LinkedList<Datasets> datasets1 = new LinkedList<Datasets>();
        Datasets dts1 = new Datasets(datasets_1);
        dts1.addDataset(DataSet2);
        datasets1.add(dts1);
        
        
        try {
            String sql = ResourceUtils.getStringFromResource(Rsql);
            sql = sql.replaceAll("\\{AcademicBuilding\\}", AcademicBuilding);
            List<Object[]> list = LocalOracleDao.getResultForSql(sql);
            for (Object[] objects : list) {
            	System.out.println(objects[0]);;
			}
            if(list!=null && list.size()>0){
                for (Object[] objData : list) {
                    String time = objData[0]==null ? "" : String.valueOf(objData[0]);
                    String value1 = objData[1]==null ? "0" : String.valueOf(objData[1]); //今日
                    //String value2 = objData[2]==null ? "0" : String.valueOf(objData[2]); //昨日
                    
                    categories.add(new Category(time));
                    DataSet2.getSet().add(new Set(value1));
                }
            }

        } catch (Exception e) {
            chart.setBgColor("668800");
            e.printStackTrace();
        }
        datasets_1.add(DataSet2);
        chart.setCategory(categories);
        chart.setDatasets(datasets1);
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
