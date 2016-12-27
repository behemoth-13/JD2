package by.pvt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.pvt.bean.Trip;
import by.pvt.dao.SqlDAO;
import by.pvt.dao.TripDAO;
import by.pvt.dao.sql.SqlHelper;

public class SqlTripDAO extends SqlDAO implements TripDAO{

	private static SqlTripDAO instance;
    
    private final String COLUMN_NAME_ORDERS_ID = "orders_id";
    private final String COLUMN_NAME_USERS_ID = "users_id";
    private final String COLUMN_NAME_DRIVERS_USERS_ID = "drivers_users_id";
    private final String COLUMN_NAME_COST = "cost";
    
    
    private SqlTripDAO() {}

    public static SqlTripDAO getInstance() {
        if (instance == null) {
            instance = new SqlTripDAO();
        }
        return instance;
    }
    
    public void addTrip(Trip trip) throws SQLException, InterruptedException {
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_ADD_TRIP;
    	PreparedStatement ps = connection.prepareStatement(query);
    	
    	ps.setInt(1, trip.getOrderId());
    	ps.setInt(2, trip.getUserId());
    	ps.setInt(3, trip.getDriversUsersId());
    	ps.setInt(4, trip.getCost());
    	ps.executeUpdate();
    	
    	poolInstance.addOpenConnection(connection);
    }
    
    public List<Trip> getTrips() throws SQLException, InterruptedException {
    	List<Trip> list = new ArrayList<>();
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_GET_TRIPS;
    	PreparedStatement ps = connection.prepareStatement(query);
    	ResultSet set = ps.executeQuery();
    	
    	while (set.next()) {
    		Trip trip = new Trip();
    		
    		trip.setOrderId(set.getInt(COLUMN_NAME_ORDERS_ID));
    		trip.setUserId(set.getInt(COLUMN_NAME_USERS_ID));
    		trip.setDriversUsersId(set.getInt(COLUMN_NAME_DRIVERS_USERS_ID));
    		trip.setCost(set.getInt(COLUMN_NAME_COST));
    		
    		list.add(trip);
    	}
    	poolInstance.addOpenConnection(connection);
    	return list;
    }
    
    public Trip getTripByOrdersId(int orderId) throws SQLException, InterruptedException {
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_GET_TRIP_BY_ORDERS_ID;
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setInt(1, orderId);
    	ResultSet set = ps.executeQuery();
    	set.next();
    	
		Trip trip = new Trip();
		
		trip.setOrderId(set.getInt(COLUMN_NAME_ORDERS_ID));
		trip.setUserId(set.getInt(COLUMN_NAME_USERS_ID));
		trip.setDriversUsersId(set.getInt(COLUMN_NAME_DRIVERS_USERS_ID));
		trip.setCost(set.getInt(COLUMN_NAME_COST));
    	
    	poolInstance.addOpenConnection(connection);
    	return trip;
    }
}
