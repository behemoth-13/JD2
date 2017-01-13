package by.pvt.service;

import java.util.List;

import by.pvt.bean.BrandOfCar;
import by.pvt.exception.OperationNotExecutedException;

public interface BrandsOfCarService {
	void addBrandOfCar(BrandOfCar brand) throws OperationNotExecutedException, IllegalArgumentException;
	List<BrandOfCar> getBrandsOfCars() throws OperationNotExecutedException;
}