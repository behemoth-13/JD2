package by.pvt.bean.constants;

public enum OrderStatus {
    HAS_COME(0), PROCEED_DISP(1), IN_WORK(2), COMPLETED(3), REJECTED(4);
	
	private int orderStatus;

	private OrderStatus (int orderStatus){
		this.orderStatus = orderStatus;
	}
	
	public int getOrderStatus(){
		return orderStatus;
	}
}
