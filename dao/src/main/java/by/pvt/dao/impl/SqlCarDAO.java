package by.pvt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.pvt.bean.Car;
import by.pvt.dao.CarDAO;
import by.pvt.dao.SqlDAO;
import by.pvt.dao.sql.SqlHelper;

public class SqlCarDAO extends SqlDAO implements CarDAO{
	
	private static SqlCarDAO instance;
	
	private final static String COLUMN_NAME_DRIVERS_USERS_ID = "drivers_users_id";
	private final static String COLUMN_NAME_BRANDS_OF_CARS_ID = "brands_of_cars_id";
	private final static String COLUMN_NAME_STATE_NUMBER = "state_number";
	private final static String COLUMN_NAME_STATUS = "status";
	private final static String COLUMN_NAME_COUNT_OF_KM = "count_of_km";
	
	private SqlCarDAO(){}
	
	public static SqlCarDAO getInstance() {
		if (instance == null) {
			instance = new SqlCarDAO();
		}
		return instance;
	}

	@Override
	public void addCar(Car car) throws SQLException, InterruptedException {
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_ADD_CAR;
    	PreparedStatement ps = connection.prepareStatement(query);
    	
    	ps.setInt(1, car.getDriversUsersId());
    	ps.setInt(2, car.getBrandsOfCarsId());
    	ps.setString(3, car.getStateNumber());
    	ps.setInt(4, car.getStatus());
    	ps.setInt(5, car.getCountOfKM());
    	ps.executeUpdate();
    	
    	poolInstance.addOpenConnection(connection);
    }
	
	/*public void deleteCarByStateNumber(String stateNumber) throws SQLException, InterruptedException {
    	Connection connection = poolInstance.take();
    	String query = sqlManager.getProperty(SqlHelper.SQL_DELETE_CAR_BY_STATE_NUMBER);
    	PreparedStatement ps = connection.prepareStatement(query);
    	
    	ps.setString(1, stateNumber);
    	//TODO  DELETE FROM `avtobase`.`brands_of_cars` WHERE `id`='номер';
    	
    	ps.executeQuery();
    	
    	poolInstance.addOpenConnection(connection);
    }*/
	
	@Override
	public void updateCountOfKM(int driverId, int countOfKM) throws SQLException, InterruptedException {
		Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_UPDATE_COUNT_OF_KM_BY_DRIVER_ID;
    	PreparedStatement ps = connection.prepareStatement(query);
    	
    	ps.setInt(1, countOfKM);
    	ps.setInt(2, driverId);
    	
    	ps.executeUpdate();
    	
    	poolInstance.addOpenConnection(connection);
	}
	
	@Override
	public List<Car> getCars() throws SQLException, InterruptedException {
    	List<Car> list = new ArrayList<>();
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_GET_CARS;
    	PreparedStatement ps = connection.prepareStatement(query);
    	ResultSet set = ps.executeQuery();
    	
    	while (set.next()) {
    		Car car = new Car();
    		
    		car.setDriversUsersId(set.getInt(COLUMN_NAME_DRIVERS_USERS_ID));
    		car.setBrandsOfCarsId(set.getInt(COLUMN_NAME_BRANDS_OF_CARS_ID));
    		car.setStateNumber(set.getString(COLUMN_NAME_STATE_NUMBER));
    		car.setStatus(set.getInt(COLUMN_NAME_STATUS));
    		car.setCountOfKM(set.getInt(COLUMN_NAME_COUNT_OF_KM));
    		
    		list.add(car);
    	}
    	poolInstance.addOpenConnection(connection);
    	return list;
    }
	
	public Car getCarByStateNumber(String stateNumber) throws SQLException, InterruptedException {
        Car car = null;
        PreparedStatement ps = null;
        String query =  SqlHelper.SQL_GET_CAR_BY_STATE_NUMBER;
        ps = poolInstance.take().prepareStatement(query);
        ps.setString(1, stateNumber);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            car = new Car();
            car.setDriversUsersId(result.getInt(COLUMN_NAME_DRIVERS_USERS_ID));
    		car.setBrandsOfCarsId(result.getInt(COLUMN_NAME_BRANDS_OF_CARS_ID));
    		car.setStateNumber(result.getString(COLUMN_NAME_STATE_NUMBER));
    		car.setStatus(result.getInt(COLUMN_NAME_STATUS));
    		car.setCountOfKM(result.getInt(COLUMN_NAME_COUNT_OF_KM));
        }
        return car;
    }
}
