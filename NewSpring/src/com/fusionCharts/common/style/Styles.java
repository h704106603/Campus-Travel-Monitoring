package com.fusionCharts.common.style;

import java.util.List;

public class Styles {

	private List<Style> definition;
	private List<Apply> application;

	public Styles() {
		super();
	}

	public Styles(List<Style> definition, List<Apply> application) {
		super();
		this.definition = definition;
		this.application = application;
	}

	public List<Style> getDefinition() {
		return definition;
	}

	public void setDefinition(List<Style> definition) {
		this.definition = definition;
	}

	public List<Apply> getApplication() {
		return application;
	}

	public void setApplication(List<Apply> application) {
		this.application = application;
	}

}
