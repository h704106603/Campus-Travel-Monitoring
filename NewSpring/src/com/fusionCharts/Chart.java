package com.fusionCharts;

import java.util.LinkedList;


import com.fusionCharts.common.Line;

public abstract class Chart {
	private String SkipOverlapLabels;
	private String caption ;
	private String bgColor = "000000";
	public String getSkipOverlapLabels() {
		return SkipOverlapLabels;
	}
	public void setSkipOverlapLabels(String skipOverlapLabels) {
		SkipOverlapLabels = skipOverlapLabels;
	}
	private String showValues = "0";
	private String clickUrl;
	
	
	private String subCaption ;
	private String formatNumberScale = "0";
	private String decimals;
	private String yAxisName;
	private String xAxisName;
	private String xAxisNamePadding;

	private String palette;
	
	private String yAxisMaxValue = "10";
	private String yAxisMinValue = "0";
	private String labelDisplay;
	private String slantLabels = "1";
	private String showBorder;
	
	private String showPercentageValues;
	private String bgAlpha = "100";
	private String baseFontSize = "12";
	//private String baseFontColor = "00FF00";
	private String baseFontColor;
	private String plotFillRatio;
	private String showZeroPies;
	private String showPlotBorder;
	private String useRoundEdges;
	private String connectNullData;
	private String rotateYAxisName;
	private String canvasBorderColor;
	private String showPercentValues;
	private String labelStep = "1";
	private String numberSuffix;
	private String legendPosition;
	private String showToolTip ;
	private String canvasBgColor = "000000,5C5C5C";
	private String borderAlpha = "100";
	private String borderColor = "FFFFFF";
	private String divLineColor = "D49B8B";
	private String showAlternateHGridColor = "0";
	private String rotateLabels = "1";
	private String legendBgColor = "000000";
	private String legendBorderColor = "415D6F";
	private String sNumberSuffix;
//	private String toolTipBgColor = "444444";
	private String toolTipBgColor = "ffffff";
	
	private String startingAngle;
	private String canvasBgAlpha;
	private String chartRightMargin;
	private String baseFont;
	private String placeValuesInside;
	private String bgRatio;
	private String overlapColumns;
	private String chartBottomMargin;
	private String chartTopMargin;
	private String chartLeftMargin;
	private String captionPadding;
	private String showLegend;
	private String outCnvBaseFontColor;
	
	private String pieRadius;
	
	public String getPieRadius() {
		return pieRadius;
	}
	public void setPieRadius(String pieRadius) {
		this.pieRadius = pieRadius;
	}
	public String getOutCnvBaseFontColor() {
		return outCnvBaseFontColor;
	}
	public void setOutCnvBaseFontColor(String outCnvBaseFontColor) {
		this.outCnvBaseFontColor = outCnvBaseFontColor;
	}
	private String yAxisValuesStep;
	private String staggerLines;
	
	public String getyAxisValuesStep() {
		return yAxisValuesStep;
	}
	public void setyAxisValuesStep(String yAxisValuesStep) {
		this.yAxisValuesStep = yAxisValuesStep;
	}
	public String getStaggerLines() {
		return staggerLines;
	}
	public void setStaggerLines(String staggerLines) {
		this.staggerLines = staggerLines;
	}
	public String getShowToolTip() {
		return showToolTip;
	}
	public void setShowToolTip(String showToolTip) {
		this.showToolTip = showToolTip;
	}
	/*
	 * 告警线
	 */
	private LinkedList<Line> line ;
	
	/*
	 * 样式
	 */
	private com.fusionCharts.common.style.Styles styles;
	
	public com.fusionCharts.common.style.Styles getStyles() {
		return styles;
	}
	public void setStyles(com.fusionCharts.common.style.Styles styles) {
		this.styles = styles;
	}
	public Chart(){
		
	}
	public Chart(String caption,String bgColor,String showValues){
		this.caption = caption;
		this.bgColor = bgColor;
		this.showValues = showValues;
	}
	
	public String getxAxisNamePadding() {
		return xAxisNamePadding;
	}
	public void setxAxisNamePadding(String xAxisNamePadding) {
		this.xAxisNamePadding = xAxisNamePadding;
	}
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getSubCaption() {
		return subCaption;
	}
	public void setSubCaption(String subCaption) {
		this.subCaption = subCaption;
	}
	public String getBgColor() {
		return bgColor;
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	public String getShowValues() {
		return showValues;
	}
	public void setShowValues(String showValues) {
		this.showValues = showValues;
	}
	public String getFormatNumberScale() {
		return formatNumberScale;
	}
	public void setFormatNumberScale(String formatNumberScale) {
		this.formatNumberScale = formatNumberScale;
	}
	public String getDecimals() {
		return decimals;
	}
	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}
	public String getYAxisName() {
		return yAxisName;
	}
	public void setYAxisName(String axisName) {
		yAxisName = axisName;
	}
	public String getXAxisName() {
		return xAxisName;
	}
	public void setXAxisName(String axisName) {
		xAxisName = axisName;
	}
	public String getPalette() {
		return palette;
	}
	public void setPalette(String palette) {
		this.palette = palette;
	}
	public Line getLine() {
		if (line == null || line.size() == 0){
			return null;
		}
		return line.get(0);
	}
	public void setLine(Line line) {
		LinkedList<Line> lineList = new  LinkedList<Line>();
		lineList.add(line);
		this.line = lineList;
	}
	public void setLine(String color, String displayvalue, String startValue) {
		Line line = new Line(color,displayvalue,startValue);
		LinkedList<Line> lineList = new  LinkedList<Line>();
		lineList.add(line);
		this.line = lineList;
	}
	public void setLine(String startValue) {
		Line line = new Line(startValue);
		LinkedList<Line> lineList = new  LinkedList<Line>();
		lineList.add(line);
		this.line = lineList;
	}
	public void setLine(String color, String startValue) {
		Line line = new Line(color,startValue);
		LinkedList<Line> lineList = new  LinkedList<Line>();
		lineList.add(line);
		this.line = lineList;
	}
	
	public String getYAxisMaxValue() {
		return yAxisMaxValue;
	}
	public void setYAxisMaxValue(String axisMaxValue) {
		yAxisMaxValue = axisMaxValue;
	}
	public String getLabelDisplay() {
		return labelDisplay;
	}
	public void setLabelDisplay(String labelDisplay) {
		this.labelDisplay = labelDisplay;
	}
	public String getSlantLabels() {
		return slantLabels;
	}
	public void setSlantLabels(String slantLabels) {
		this.slantLabels = slantLabels;
	}
	public String getShowBorder() {
		return showBorder;
	}
	public void setShowBorder(String showBorder) {
		this.showBorder = showBorder;
	}
	public String getShowPercentageValues() {
		return showPercentageValues;
	}
	public void setShowPercentageValues(String showPercentageValues) {
		this.showPercentageValues = showPercentageValues;
	}
	public String getBgAlpha() {
		return bgAlpha;
	}
	public void setBgAlpha(String bgAlpha) {
		this.bgAlpha = bgAlpha;
	}
	public String getBaseFontSize() {
		return baseFontSize;
	}
	public void setBaseFontSize(String baseFontSize) {
		this.baseFontSize = baseFontSize;
	}
	public String getBaseFontColor() {
		return baseFontColor;
	}
	public void setBaseFontColor(String baseFontColor) {
		this.baseFontColor = baseFontColor;
	}
	public String getLegendBgColor() {
		return legendBgColor;
	}
	public void setLegendBgColor(String legendBgColor) {
		this.legendBgColor = legendBgColor;
	}
	public String getCanvasBgColor() {
		return canvasBgColor;
	}
	public void setCanvasBgColor(String canvasBgColor) {
		this.canvasBgColor = canvasBgColor;
	}
	public String getPlotFillRatio() {
		return plotFillRatio;
	}
	public void setPlotFillRatio(String plotFillRatio) {
		this.plotFillRatio = plotFillRatio;
	}
	public String getShowZeroPies() {
		return showZeroPies;
	}
	public void setShowZeroPies(String showZeroPies) {
		this.showZeroPies = showZeroPies;
	}
	public String getShowPlotBorder() {
		return showPlotBorder;
	}
	public void setShowPlotBorder(String showPlotBorder) {
		this.showPlotBorder = showPlotBorder;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public String getUseRoundEdges() {
		return useRoundEdges;
	}
	public void setUseRoundEdges(String useRoundEdges) {
		this.useRoundEdges = useRoundEdges;
	}
	public String getConnectNullData() {
		return connectNullData;
	}
	public void setConnectNullData(String connectNullData) {
		this.connectNullData = connectNullData;
	}
	public String getRotateYAxisName() {
		return rotateYAxisName;
	}
	public void setRotateYAxisName(String rotateYAxisName) {
		this.rotateYAxisName = rotateYAxisName;
	}
	public String getBorderAlpha() {
		return borderAlpha;
	}
	public void setBorderAlpha(String borderAlpha) {
		this.borderAlpha = borderAlpha;
	}
	public String getToolTipBgColor() {
		return toolTipBgColor;
	}
	public void setToolTipBgColor(String toolTipBgColor) {
		this.toolTipBgColor = toolTipBgColor;
	}
	public String getDivLineColor() {
		return divLineColor;
	}
	public void setDivLineColor(String divLineColor) {
		this.divLineColor = divLineColor;
	}
	public String getShowAlternateHGridColor() {
		return showAlternateHGridColor;
	}
	public void setShowAlternateHGridColor(String showAlternateHGridColor) {
		this.showAlternateHGridColor = showAlternateHGridColor;
	}
	public String getLegendBorderColor() {
		return legendBorderColor;
	}
	public void setLegendBorderColor(String legendBorderColor) {
		this.legendBorderColor = legendBorderColor;
	}
	public String getCanvasBorderColor() {
		return canvasBorderColor;
	}
	public void setCanvasBorderColor(String canvasBorderColor) {
		this.canvasBorderColor = canvasBorderColor;
	}
	public String getShowPercentValues() {
		return showPercentValues;
	}
	public void setShowPercentValues(String showPercentValues) {
		this.showPercentValues = showPercentValues;
	}
	public String getLabelStep() {
		return labelStep;
	}
	public void setLabelStep(String labelStep) {
		this.labelStep = labelStep;
	}
	public String getNumberSuffix() {
		return numberSuffix;
	}
	public void setNumberSuffix(String numberSuffix) {
		this.numberSuffix = numberSuffix;
	}
	public String getLegendPosition() {
		return legendPosition;
	}
	public void setLegendPosition(String legendPosition) {
		this.legendPosition = legendPosition;
	}
	public String getSNumberSuffix() {
		return sNumberSuffix;
	}
	public void setSNumberSuffix(String numberSuffix) {
		sNumberSuffix = numberSuffix;
	}
	public String getStartingAngle() {
		return startingAngle;
	}
	public void setStartingAngle(String startingAngle) {
		this.startingAngle = startingAngle;
	}
	public String getCanvasBgAlpha() {
		return canvasBgAlpha;
	}
	public void setCanvasBgAlpha(String canvasBgAlpha) {
		this.canvasBgAlpha = canvasBgAlpha;
	}
	public String getChartRightMargin() {
		return chartRightMargin;
	}
	public void setChartRightMargin(String chartRightMargin) {
		this.chartRightMargin = chartRightMargin;
	}
	public String getRotateLabels() {
		return rotateLabels;
	}
	public void setRotateLabels(String rotateLabels) {
		this.rotateLabels = rotateLabels;
	}
	public String getBaseFont() {
		return baseFont;
	}
	public void setBaseFont(String baseFont) {
		this.baseFont = baseFont;
	}
	public String getPlaceValuesInside() {
		return placeValuesInside;
	}
	public void setPlaceValuesInside(String placeValuesInside) {
		this.placeValuesInside = placeValuesInside;
	}
	public String getBgRatio() {
		return bgRatio;
	}
	public void setBgRatio(String bgRatio) {
		this.bgRatio = bgRatio;
	}
	public String getOverlapColumns() {
		return overlapColumns;
	}
	public void setOverlapColumns(String overlapColumns) {
		this.overlapColumns = overlapColumns;
	}
	public String getChartBottomMargin() {
		return chartBottomMargin;
	}
	public void setChartBottomMargin(String chartBottomMargin) {
		this.chartBottomMargin = chartBottomMargin;
	}
	public String getChartTopMargin() {
		return chartTopMargin;
	}
	public void setChartTopMargin(String chartTopMargin) {
		this.chartTopMargin = chartTopMargin;
	}
	public String getChartLeftMargin() {
		return chartLeftMargin;
	}
	public void setChartLeftMargin(String chartLeftMargin) {
		this.chartLeftMargin = chartLeftMargin;
	}
	public String getCaptionPadding() {
		return captionPadding;
	}
	public void setCaptionPadding(String captionPadding) {
		this.captionPadding = captionPadding;
	}
	public String getShowLegend() {
		return showLegend;
	}
	public void setShowLegend(String showLegend) {
		this.showLegend = showLegend;
	}
	public String getClickUrl() {
		return clickUrl;
	}
	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}
	
	public String getyAxisMinValue() {
		return yAxisMinValue;
	}
	public void setyAxisMinValue(String yAxisMinValue) {
		this.yAxisMinValue = yAxisMinValue;
	}
	
	private String plotSpacePercent;
	private String numDivLines;
	
	public String getNumDivLines() {
		return numDivLines;
	}
	public void setNumDivLines(String numDivLines) {
		this.numDivLines = numDivLines;
	}
	public String getPlotSpacePercent() {
		return plotSpacePercent;
	}
	public void setPlotSpacePercent(String plotSpacePercent) {
		this.plotSpacePercent = plotSpacePercent;
	}
	public abstract String toXML();
}
