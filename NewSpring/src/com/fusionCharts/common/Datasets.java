package com.fusionCharts.common;

import java.util.LinkedList;
import java.util.List;

public class Datasets {
	private LinkedList<Dataset> dataset;
	
	public Datasets() {
		super();
	}
	public Datasets(LinkedList<Dataset> dataset) {
		super();
		this.dataset = dataset;
	}
	public void setDataset(LinkedList<Dataset> dataset) {
		this.dataset = dataset;
	}
	public void addDataset(Dataset dataset){
		this.dataset.add(dataset);
	}
	public Dataset shiftDataset(){
		Dataset dataset = this.dataset.get(0);
		this.dataset.remove(0);
		return dataset;
	}
	public void clearDataset(){
		this.dataset = new LinkedList<Dataset>();
	}
	public List<Dataset> getDataset(){
		return this.dataset;
	}

}
