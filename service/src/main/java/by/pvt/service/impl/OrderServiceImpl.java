package by.pvt.service.impl;

import java.sql.SQLException;
import java.util.List;

import by.pvt.bean.Order;
import by.pvt.bean.User;
import by.pvt.bean.constants.Roles;
import by.pvt.dao.OrderDAO;
import by.pvt.dao.UserDAO;
import by.pvt.dao.factory.DaoName;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.OrderService;
import by.pvt.service.Service;

public class OrderServiceImpl  extends Service implements OrderService{

	private static OrderServiceImpl instance;
	
	private OrderServiceImpl(){}
	
	public static OrderServiceImpl getInstance() {
		if (instance == null) {
			instance = new OrderServiceImpl();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) throws OperationNotExecutedException, IllegalArgumentException {
		String message = validateOrder(order);
		if (message.length() != 0){
			throw new IllegalArgumentException(message);
		}
		OrderDAO dao = (OrderDAO) daoFactory.getOperationDAO(DaoName.ORDER_DAO);
		try {
			dao.addOrder(order);
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("OrderServiceImpl.addOrder not executed");
		}
	}

	@Override
	public List<Order> getOrders() throws OperationNotExecutedException, IllegalArgumentException {
		OrderDAO dao = (OrderDAO) daoFactory.getOperationDAO(DaoName.ORDER_DAO);
		try {
			return dao.getOrders();
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("OrderServiceImpl.getOrders not executed");
		}
	}

	@Override
	public List<Order> getOrdersByUsersId(int userId) throws OperationNotExecutedException, IllegalArgumentException {
		List<Order> result = null;
		UserDAO userDao = (UserDAO) daoFactory.getOperationDAO(DaoName.USER_DAO);
		User user = null;
		try {
			user = userDao.getUserById(userId);
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("OrderServiceImpl.getOrdersByUsersId not executed");
		}
		if ((user == null) || (user.getRole() != Roles.USER.getCodeRole()) || (user.getRole() != Roles.DRIVER.getCodeRole())){
			throw new IllegalArgumentException("User is not exist");
		}
		
		OrderDAO orderDao = (OrderDAO) daoFactory.getOperationDAO(DaoName.ORDER_DAO);
		try {
			result = orderDao.getOrders();
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("OrderServiceImpl.getOrdersByUsersId not executed");
		}
		return result;
	}

	@Override
	public void updateStatusOrderByID(int orderId, int status) throws OperationNotExecutedException, IllegalArgumentException {
		OrderDAO orderDao = (OrderDAO) daoFactory.getOperationDAO(DaoName.ORDER_DAO);
		if (status < 0 || status > 4) {
			throw new IllegalArgumentException("Wrong status");
		}
		try {
			orderDao.updateStatusOrderByID(orderId, status);
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("OrderServiceImpl.updateStatusOrderByID not executed");
		}
	}

	@Override
	public List<Order> getOrdersByStatus(int status) throws OperationNotExecutedException, IllegalArgumentException {
		List<Order> result = null;
		OrderDAO orderDao = (OrderDAO) daoFactory.getOperationDAO(DaoName.ORDER_DAO);
		if (status < 0 || status > 4) {
			throw new IllegalArgumentException("Wrong status");
		}
		try {
			result = orderDao.getOrdersByStatus(status);
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("OrderServiceImpl.updateStatusOrderByID not executed");
		}
		return result;
	}
	
	private String validateOrder(Order order) {
		StringBuilder messageException = new StringBuilder();
		if (order.getWeight() <= 1 || order.getWeight() >= 200) {
			messageException.append("weight is not valid \n");
        }
		if (order.getCapacity() <= 1 || order.getWeight() >= 40) {
			messageException.append("capacity is not valid \n");
        }
		if (order.getDistance() <= 20 || order.getWeight() >= 10000) {
			messageException.append("distance is not valid \n");
        }
		return messageException.toString();
	}
}
