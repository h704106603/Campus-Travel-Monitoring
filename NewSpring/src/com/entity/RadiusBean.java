package com.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RadiusBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String NOW_TIME;
	private long COST_TIME;
	private String TYPE;

	public String getNOW_TIME() {
		return NOW_TIME;
	}

	public void setNOW_TIME(String nOW_TIME) {
		NOW_TIME = nOW_TIME;
	}

	public long getCOST_TIME() {
		return COST_TIME;
	}

	public void setCOST_TIME(long cOST_TIME) {
		COST_TIME = cOST_TIME;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
