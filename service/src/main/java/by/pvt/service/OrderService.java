package by.pvt.service;

import java.util.List;

import by.pvt.bean.Order;
import by.pvt.exception.OperationNotExecutedException;

public interface OrderService {
	void addOrder(Order order) throws OperationNotExecutedException, IllegalArgumentException;
	List<Order> getOrders() throws OperationNotExecutedException, IllegalArgumentException;
	List<Order> getOrdersByUsersId(int userId) throws OperationNotExecutedException, IllegalArgumentException;
	void updateStatusOrderByID(int orderId,  int status) throws OperationNotExecutedException, IllegalArgumentException;
	List<Order> getOrdersByStatus(int status) throws OperationNotExecutedException, IllegalArgumentException;
}