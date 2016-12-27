package by.pvt.dao;

import java.sql.SQLException;
import java.util.List;

import by.pvt.bean.Trip;

public interface TripDAO {
	void addTrip(Trip trip) throws SQLException, InterruptedException;
	List<Trip> getTrips() throws SQLException, InterruptedException;
	Trip getTripByOrdersId(int orderId) throws SQLException, InterruptedException;
}