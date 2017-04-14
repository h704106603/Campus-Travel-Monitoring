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
import com.fusionCharts.SingleSeriesChart;
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
import com.service.CanteenService;
import com.util.ResourceUtils;


public class CanteenServiceImpl implements CanteenService{

    @javax.annotation.Resource(name="LocalOracleDao")
    private com.dao.LocalOracleDao LocalOracleDao;
    
    @Value("classpath:config/Canteen/allCanteen.sql")
    private Resource allCanteenSql;
    
    @Value("classpath:config/Canteen/eachCanteen.sql")
    private Resource eachCanteenSql;
    
    @Value("classpath:config/Canteen/canteenBar.sql")
    private Resource canteenBarSql;
    
    public Map<String, Object> Bar() {
        return this.getData(false);
        
    }
    
    public Map<String, Object> Pie() {
        return this.getPieData(false);
        
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
            String re = getBar("第一食堂近一小时人数明细",canteenBarSql,"1");
            reMap.put("FirstBathroom", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String re = getBar("第二食堂近一小时人数明细",canteenBarSql,"2");
            reMap.put("SecondBathroom", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String re = getBar("第三食堂近一小时人数明细",canteenBarSql,"2");
            reMap.put("ThirdBathroom", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return reMap;
        
    }
    
    
    public Map<String,Object> getPieData(boolean flag){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        try {
            date = df.parse(df.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Map<String, Object> reMap = new HashMap<String, Object>();
        
        try{
            String re = getPieResult("各食堂当前人数分布情况",allCanteenSql);
            reMap.put("allCanteen", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String re = getEachPieResult("第一食堂当前人数分布情况",eachCanteenSql);
            reMap.put("eachCanteen1", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String re = getEachPieResult("第二食堂当前人数分布情况",eachCanteenSql);
            reMap.put("eachCanteen2", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String re = getEachPieResult("第三食堂当前人数分布情况",eachCanteenSql);
            reMap.put("eachCanteen3", re);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return reMap;
        
    }
    
    private String getBar(String caption,Resource Rsql,String id) {
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dft = new SimpleDateFormat("yyyyMMdd");
        MultiSeriesStackedChart2 chart = new MultiSeriesStackedChart2(caption+"(刷新周期5分钟) "+format2.format(new Date()), "000000", "0");
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
            sql = sql.replaceAll("\\{id\\}", id);
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
    
    private String getPieResult(String caption,Resource Rsql) {
        SingleSeriesChart chart = new SingleSeriesChart(caption+"(刷新周期2分钟)", "000000", "0");
        setStyle(chart);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        chart.setSubCaption(df.format(new Date()));
        chart.setBgAlpha("100");
        chart.setPalette("2");
        chart.setBaseFontSize("15");
        chart.setCanvasBgColor("000000,5C5C5C");
        chart.setBorderAlpha("0");
        chart.setLegendBgColor("000000");
        chart.setLegendBorderColor("415D6F");
        chart.setBaseFontColor("00FF00");
        chart.setShowValues("1");
        
        List<Object[]>  dataList = new ArrayList<Object[]>();
        try {
            String sql = ResourceUtils.getStringFromResource(Rsql);
            dataList = this.LocalOracleDao.getResultForSql(sql);
        } catch (Exception e) {
            chart.setBgColor("668800");
            e.printStackTrace();
        }
        
        LinkedList<Set> set = new LinkedList<Set>();
        if(dataList!=null && dataList.size()>0){
            for (int i =0;i<dataList.size();i++) {
                Object[] data = dataList.get(i);
                String name = String.valueOf(data[0]==null?"":data[0]);
                name = "第"+name+"食堂";
                String value = String.valueOf(data[1]==null?"":data[1]);
                Set seet =  new Set();
                seet.setLabel(name);
                seet.setValue(value);
                set.add(seet);
            }
        }else{
            Set seet =  new Set();
            seet.setLabel("无数据");
            seet.setValue("1");
            set.add(seet);
        }
        chart.setSet(set);
        return chart.toXML();
        
    }
    
    
    
    private String getEachPieResult(String caption,Resource Rsql) {
        SingleSeriesChart chart = new SingleSeriesChart(caption+"(刷新周期2分钟)", "000000", "0");
        setStyle(chart);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        chart.setSubCaption(df.format(new Date()));
        chart.setBgAlpha("100");
        chart.setPalette("2");
        chart.setBaseFontSize("15");
        chart.setCanvasBgColor("000000,5C5C5C");
        chart.setBorderAlpha("0");
        chart.setLegendBgColor("000000");
        chart.setLegendBorderColor("415D6F");
        chart.setBaseFontColor("00FF00");
        chart.setShowValues("1");
        
        //用来匹配sql语句中的id
        String id = new String();
        String max = new String();
        if(caption.equals("第一食堂当前人数分布情况")){
            id = "1";
            max = "150";
            
        }
        else if(caption.equals("第二食堂当前人数分布情况")){
            id = "2";
            max = "150";
        }
        else if(caption.equals("第三食堂当前人数分布情况")){
            id = "3";
            max = "150";
        }
        
        List<Object[]>  dataList = new ArrayList<Object[]>();
        try {
            String sql = ResourceUtils.getStringFromResource(Rsql);
            sql = sql.replaceAll("\\{id\\}", id);
            sql = sql.replaceAll("\\{max\\}", max);
            dataList = this.LocalOracleDao.getResultForSql(sql);
        } catch (Exception e) {
            chart.setBgColor("668800");
            e.printStackTrace();
        }
        
        LinkedList<Set> set = new LinkedList<Set>();
        if(dataList!=null && dataList.size()>0){
            for (int i =0;i<dataList.size();i++) {
                Object[] data = dataList.get(i);
                String name = String.valueOf(data[0]==null?"":data[0]);
                String value = String.valueOf(data[1]==null?"":data[1]);
                Set seet =  new Set();
                seet.setLabel(name);
                seet.setValue(value);
                set.add(seet);
            }
        }else{
            Set seet =  new Set();
            seet.setLabel("无数据");
            seet.setValue("1");
            set.add(seet);
        }
        chart.setSet(set);
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
