package by.pvt.service.impl;

import java.sql.SQLException;
import java.util.List;

import by.pvt.bean.Car;
import by.pvt.dao.CarDAO;
import by.pvt.dao.factory.DaoName;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.CarService;
import by.pvt.service.Service;
import by.pvt.service.validation.DataValidation;

public class CarServiceImpl extends Service implements CarService{

	private static CarServiceImpl instance;
	
	private CarServiceImpl(){}
	
	public static CarServiceImpl getInstance() {
		if (instance == null) {
			instance = new CarServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void addCar(Car car) throws OperationNotExecutedException, IllegalArgumentException{
		CarDAO dao = (CarDAO) daoFactory.getOperationDAO(DaoName.CAR_DAO);
		String message = validateCar(car);
		if (message.length() != 0){
			throw new IllegalArgumentException(message);
		} else {
			try {
				dao.addCar(car);
			} catch (SQLException | InterruptedException e) {
				throw new OperationNotExecutedException("CarServiceImpl.addCar not executed");
			}
		}
	}

	/*@Override
	public void deleteCarByStateNumber(String stateNumber) throws OperationNotExecutedException, IllegalArgumentException{
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void updateCountOfKM(int driverId, int countOfKM) throws OperationNotExecutedException, IllegalArgumentException{
		CarDAO dao = (CarDAO) daoFactory.getOperationDAO(DaoName.CAR_DAO);
		if (!DataValidation.countOfKMPattern.matcher(String.valueOf(countOfKM)).matches()) {
	            throw new IllegalArgumentException("countOfKM is not valid");
	        }
		try {
			dao.updateCountOfKM(driverId, countOfKM);
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("CarServiceImpl.updateCountOfKM not executed");
		}
	}

	@Override
	public List<Car> getCars() throws OperationNotExecutedException{
		CarDAO dao = (CarDAO) daoFactory.getOperationDAO(DaoName.CAR_DAO);
		try {
			return dao.getCars();
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("CarServiceImpl.getCars not executed");
		}
	}
	
	private String validateCar(Car car) {
		StringBuilder messageException = new StringBuilder();
		if (!DataValidation.stateNumberPattern.matcher(car.getStateNumber()).matches()) {
			messageException.append("stateNumber is not valid \n");
        }
		if (!DataValidation.statusCarPattern.matcher(String.valueOf(car.getStatus())).matches()) {
			messageException.append("status is not valid \n");
        }
		if (!DataValidation.countOfKMPattern.matcher(String.valueOf(car.getCountOfKM())).matches()) {
			messageException.append("countOfKM is not valid \n");
        }
		return messageException.toString();
	}
}