package by.pvt.service.impl;

import java.sql.SQLException;
import java.util.List;

import by.pvt.bean.BrandOfCar;
import by.pvt.dao.BrandsOfCarDAO;
import by.pvt.dao.factory.DaoName;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.BrandsOfCarService;
import by.pvt.service.Service;

public class BrandsOfCarServiceImpl  extends Service implements BrandsOfCarService {
	private static BrandsOfCarServiceImpl instance;
	
	private BrandsOfCarServiceImpl(){}
	
	public static BrandsOfCarServiceImpl getInstance() {
		if (instance == null) {
			instance = new BrandsOfCarServiceImpl();
		}
		return instance;
	}

	@Override
	public void addBrandOfCar(BrandOfCar brand) throws OperationNotExecutedException, IllegalArgumentException{
		BrandsOfCarDAO dao = (BrandsOfCarDAO) daoFactory.getOperationDAO(DaoName.BRANDS_OF_CAR_DAO);

		if (brand.getName().length() > 45 || brand.getName().length() < 3) {
			throw new IllegalArgumentException("Length of name is not valid");
		}
		if (brand.getLoadingCapacity() > 44000 || brand.getLoadingCapacity() < 1) {
			throw new IllegalArgumentException("LoadingCapacity is higher then 44000 kg");
		}
		if (brand.getCapacity() > 200 || brand.getCapacity() <1) {
			throw new IllegalArgumentException("!Capacity is higher then 200 m3");
		}
		try {
			if (dao.isBrandsOfCarsExist(brand.getName())) {
				throw new IllegalArgumentException("Brand is exist");
			}
				dao.addBrandOfCar(brand);
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("BrandsOfCarServiceImpl.addBrandOfCar not executed");
		}
	}

	@Override
	public List<BrandOfCar> getBrandsOfCars() throws OperationNotExecutedException{
		BrandsOfCarDAO dao = (BrandsOfCarDAO) daoFactory.getOperationDAO(DaoName.BRANDS_OF_CAR_DAO);
		try {
			return dao.getBrandsOfCars();
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("BrandsOfCarServiceImpl.getBrandsOfCars not executed");
		}
	}
}