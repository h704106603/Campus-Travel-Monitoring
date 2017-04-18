package com.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.LineStyle;
import com.service.EchartsClassroomService;
import com.util.ResourceUtils;


public class EchartsClassroomServiceImpl implements EchartsClassroomService{

    //本地测试Dao
    @javax.annotation.Resource(name="LocalOracleDao")
    private com.dao.LocalOracleDao LocalOracleDao;
    
    @Value("classpath:config/Classroom/Classroom.sql")
    private Resource classroomSql;
    
    public String ClassroomBar(String classroom){
        
        return showBar("教室人数明细",classroomSql,classroom);
         
        
    }

    public String showBar(String caption,Resource Rsql,String id){
        
        Option option = new GsonOption();
        Map<String,String> map1 = new HashMap<String,String>();
        map1.put("type", "max");
        map1.put("name", "最大值");
        Map<String,String> map2 = new HashMap<String,String>();
        map2.put("type", "min");
        map2.put("name", "最小值");
        MarkPoint markPoint = new MarkPoint();
        markPoint.data(map1,map2);
        MarkLine markLine = new MarkLine();
        Map<String,String> map3 = new HashMap<String,String>();
        map3.put("type", "average");
        map3.put("name", "平均值");
        markLine.data(map3).itemStyle().normal().color("red");
        markPoint.itemStyle().normal().color("#00FF00");
        markPoint.itemStyle().normal().textStyle().fontSize(8);

        //option.title().text("内存使用情况(刷新周期2分钟)").subtext(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())).x(X.center);
        option.title().text(caption).borderColor("#00FF00").x(X.left);
        //设置时间颜色
        //option.title().subtextStyle().color("#00FF00");
        option.title().textStyle().color("#00FF00").fontSize(12);
        option.tooltip().trigger(Trigger.valueOf("axis"));
        option.calculable(true);
        //option.backgroundColor("#00FF00");
        //option.grid().x(40).y(60).x2(30).y2(25);
        option.grid().left("0%").containLabel(true);
        option.grid().width("70%").height("46%");
        
        //设置虚线
        LineStyle linestyle = new LineStyle();
        linestyle.type(LineType.solid).color("gray");
        SplitLine split = new SplitLine();
        split.lineStyle(linestyle);

        ValueAxis valueAxis = new ValueAxis();
        valueAxis.splitLine().show(false);
        valueAxis.axisLine().show(false);
        valueAxis.type(AxisType.valueOf("category"));
        valueAxis.axisLabel().textStyle().color("#00FF00");
        option.xAxis(valueAxis);

        ValueAxis values = new ValueAxis();
        values.splitLine(split);
        values.axisLabel().textStyle().color("#00FF00");
        values.axisLabel().formatter("{value}");
        ////values.max(100);
        option.yAxis(values);

        ItemStyle placeHolderStyle = new ItemStyle();
        placeHolderStyle.normal().color("#33CC33").label(new Label().show(false)).labelLine().show(false);
        placeHolderStyle.emphasis().color("#33CC33");

//      Bar bar1 = new Bar("已使用");
//      bar1.markPoint(markPoint).itemStyle(placeHolderStyle);
        Bar  line1 = new Bar("昨日人数");
        ItemStyle dataStyl1 = new ItemStyle();
        dataStyl1.normal().color("#FF9900").label().show(false);
        dataStyl1.normal().labelLine().show(false);
        line1.itemStyle(dataStyl1);
        Bar  line2 = new Bar("今日人数");
        ItemStyle dataStyl2 = new ItemStyle();
        dataStyl1.normal().color("#00FF00").label().show(false);
        dataStyl1.normal().labelLine().show(false);
        line2.itemStyle(dataStyl2);
        //line.markPoint(markPoint).itemStyle(placeHolderStyle);
        /*Bar  line1 = new Bar("昨日次数");
        ItemStyle dataStyl2 = new ItemStyle();
        dataStyl2.normal().color("#00ffff").label().show(false);
        dataStyl2.normal().labelLine().show(false);
        line1.itemStyle(dataStyl2);*/
        try {
            Date dt=new Date();
            String sql = ResourceUtils.getStringFromResource(Rsql);
            sql = sql.replaceAll("\\{id\\}", id);
            List<Object[]> list = LocalOracleDao.getResultForSql(sql);
            if(list!=null && list.size()>0){
                
                for(Object[] obj:list){ 
                    String time = obj[0] == null? "0" : obj[0].toString() ; 
                    double value1 = obj[1] == null? 0 : Double.valueOf(obj[1].toString()) ;
                    double value2 = obj[2] == null? 0 : Double.valueOf(obj[2].toString()) ;
                    valueAxis.data(time);
                    line1.data(value1);
                    line2.data(value2);
                }
            }
            else{
                String time = "无数据" ;   
                double value1 = 0 ;
                double value2 = 0 ;
                valueAxis.data(time);
                line1.data(value1);
                line2.data(value2);
            }
            
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
        option.legend().orient(Orient.vertical)
        .x(X.right)
        .data(line1,line2).textStyle().color("#00FF00");
        
        option.series(line1,line2);
        return option.toString();
    }
    
    
}
