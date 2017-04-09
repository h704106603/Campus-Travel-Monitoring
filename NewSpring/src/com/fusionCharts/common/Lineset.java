package com.fusionCharts.common;

import java.util.LinkedList;

public class Lineset extends Dataset {

	public Lineset() {
		super();
	}

	public Lineset(String color, String seriesName, LinkedList<Set> set,
			String showValues) {
		super(color, seriesName, set, showValues);
	}

	public Lineset(String color, String seriesName, String showValues) {
		super(color, seriesName, showValues);
	}
	
}
