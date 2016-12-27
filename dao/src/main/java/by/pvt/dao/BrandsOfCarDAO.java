package by.pvt.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import by.pvt.bean.BrandOfCar;

public interface BrandsOfCarDAO {
	void addBrandOfCar(BrandOfCar brand) throws SQLException, InterruptedException;
	List<BrandOfCar> getBrandsOfCars() throws SQLException, InterruptedException;
	Map<Integer, BrandOfCar> getBrandsOfCarsById() throws SQLException, InterruptedException;
	void deleteBrandOfCarById(int id) throws SQLException, InterruptedException;
	boolean isBrandsOfCarsExist(String brandName) throws SQLException, InterruptedException;
}
