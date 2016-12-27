package by.pvt.service.impl;

import java.sql.SQLException;
import java.util.List;

import by.pvt.bean.Trip;
import by.pvt.dao.OrderDAO;
import by.pvt.dao.TripDAO;
import by.pvt.dao.factory.DaoName;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.Service;
import by.pvt.service.TripService;

public class TripServiceImpl  extends Service implements TripService{
	
	private static TripServiceImpl instance;
	
	private TripServiceImpl(){}
	
	public static TripServiceImpl getInstance() {
		if (instance == null) {
			instance = new TripServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<Trip> getTrips() throws OperationNotExecutedException, IllegalArgumentException{
		TripDAO dao = (TripDAO) daoFactory.getOperationDAO(DaoName.TRIP_DAO);
		try {
			return dao.getTrips();
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("UserServiceImpl.getUsers not executed");
		}
	}

	@Override// Duplicate OrderServiceImpl.updateStatusOrderByID
	public void updateStatusTripByID(int orderId, int status) throws OperationNotExecutedException, IllegalArgumentException{
		OrderDAO orderDao = (OrderDAO) daoFactory.getOperationDAO(DaoName.ORDER_DAO);
		if (status < 0 || status > 4) {
			throw new IllegalArgumentException("Wrong status");
		}
		try {
			orderDao.updateStatusOrderByID(orderId, status);
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("TripServiceImpl.updateStatusTripByID not executed");
		}
	}
}