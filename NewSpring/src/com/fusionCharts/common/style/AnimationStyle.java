package com.fusionCharts.common.style;

public class AnimationStyle extends Style {

	private String param = Param._y.value;
	private String start = "0";
	private String duration = "1";
	private String easing = Easing.Elastic.value;

	public AnimationStyle(String name) {
		this.type = "animation";
		this.name = name;
	}

	public AnimationStyle(String name, String param, String start,
			String duration, String easing) {
		this.type = "animation";
		this.name = name;
		this.param = param;
		this.start = start;
		this.duration = duration;
		this.easing = easing;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getEasing() {
		return easing;
	}

	public void setEasing(String easing) {
		this.easing = easing;
	}

	public static enum Param {
		_x("_x"), _y("_y"), _xScale("_xScale"), _yScale("_yScale"), _alpha(
				"_alpha"), _rotation("_rotation");
		public String value;
		private Param(String value) {
			this.value = value;
		}
	}
	
	public static enum Easing {
		Elastic("Elastic"), Bounce("Bounce"), Strong("Strong"), Regular("Regular"), None("None");
		public String value;
		private Easing(String value) {
			this.value = value;
		}
	}

}
