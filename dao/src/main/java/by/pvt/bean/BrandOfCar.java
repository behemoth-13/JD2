package by.pvt.bean;

import java.io.Serializable;

public class BrandOfCar implements Serializable {
	
	private static final long serialVersionUID = 6569512324194793042L;
	
	private int id;
	private String name;
	private int loadingCapacity; //грузоподъемность
	private int capacity;
	private double costPerKM;
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getLoadingCapacity() {
		return loadingCapacity;
	}
	public int getCapacity() {
		return capacity;
	}
	public double getCostPerKM() {
		return costPerKM;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLoadingCapacity(int loadingCapacity) {
		this.loadingCapacity = loadingCapacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void setCostPerKM(double costPerKM) {
		this.costPerKM = costPerKM;
	}
}