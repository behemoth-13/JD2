package by.pvt.bean;

import java.io.Serializable;

public class Trip implements Serializable{

	private static final long serialVersionUID = -2608275108633526742L;
	
	private int orderId;
	private int userId;
	private int driversUsersId;
	private int cost;
	
	public int getOrderId() {
		return orderId;
	}
	public int getUserId() {
		return userId;
	}
	public int getDriversUsersId() {
		return driversUsersId;
	}
	public int getCost() {
		return cost;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setDriversUsersId(int driversUsersId) {
		this.driversUsersId = driversUsersId;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}