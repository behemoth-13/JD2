package by.pvt.service;

import java.util.List;

import by.pvt.bean.Car;
import by.pvt.exception.OperationNotExecutedException;

public interface CarService {
	void addCar(Car car) throws OperationNotExecutedException, IllegalArgumentException;
	//void deleteCarByStateNumber(String stateNumber) throws OperationNotExecutedException, IllegalArgumentException;
	void updateCountOfKM(int driverId, int countOfKM) throws OperationNotExecutedException, IllegalArgumentException;
	List<Car> getCars() throws OperationNotExecutedException;
}