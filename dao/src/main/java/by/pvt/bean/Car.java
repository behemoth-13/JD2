package by.pvt.bean;

import java.io.Serializable;

public class Car implements Serializable {
	
	private static final long serialVersionUID = -3358801222619017880L;
	
	private int driversUsersId;
	private int brandsOfCarsId;
	private String stateNumber;
	private int status;
	private int countOfKM;
	
	
	public int getDriversUsersId() {
		return driversUsersId;
	}
	public int getBrandsOfCarsId() {
		return brandsOfCarsId;
	}
	public String getStateNumber() {
		return stateNumber;
	}
	public int getStatus() {
		return status;
	}
	public int getCountOfKM() {
		return countOfKM;
	}
	
	
	public void setDriversUsersId(int driversUsersId) {
		this.driversUsersId = driversUsersId;
	}
	public void setBrandsOfCarsId(int brandsOfCarsId) {
		this.brandsOfCarsId = brandsOfCarsId;
	}
	public void setStateNumber(String stateNumber) {
		this.stateNumber = stateNumber;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setCountOfKM(int countOfKM) {
		this.countOfKM = countOfKM;
	}
}
