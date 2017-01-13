package by.pvt.service;

import java.util.List;

import by.pvt.bean.Trip;
import by.pvt.exception.OperationNotExecutedException;

public interface TripService {
	List<Trip> getTrips() throws OperationNotExecutedException, IllegalArgumentException;
	void updateStatusTripByID(int orderId,  int status) throws OperationNotExecutedException, IllegalArgumentException;
}