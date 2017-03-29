package by.pvt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.pvt.bean.BrandOfCar;
import by.pvt.dao.BrandsOfCarDAO;
import by.pvt.dao.SqlDAO;
import by.pvt.dao.sql.SqlHelper;

public class SqlBrandsOfCarDAO extends SqlDAO implements BrandsOfCarDAO{

private static SqlBrandsOfCarDAO instance;
    
    private final String COLUMN_NAME_ID = "id";
    private final String COLUMN_NAME_BRAND_OF_CAR = "brand_of_car";
    private final String COLUMN_NAME_LOADING_CAPACITY = "loading_capacity";
    private final String COLUMN_NAME_CAPACITY = "capacity";
    private final String COLUMN_NAME_COST_PER_KM = "cost_per_km";
    
    private SqlBrandsOfCarDAO() {}

    public static SqlBrandsOfCarDAO getInstance() {
        if (instance == null) {
            instance = new SqlBrandsOfCarDAO();
        }
        return instance;
    }
    
    public void addBrandOfCar(BrandOfCar brand) throws SQLException, InterruptedException {
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_ADD_BRAND_OF_CAR;
    	PreparedStatement ps = connection.prepareStatement(query);
    	
    	ps.setString(1, brand.getName());
    	ps.setInt(2, brand.getLoadingCapacity());
    	ps.setInt(3, brand.getCapacity());
    	ps.setInt(4, brand.getCostPerKM());
    	ps.executeUpdate();
    	
    	poolInstance.addOpenConnection(connection);
    }
    
    public List<BrandOfCar> getBrandsOfCars() throws SQLException, InterruptedException {
    	List<BrandOfCar> list = new ArrayList<>();
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_GET_BRANDS_OF_CAR;
    	PreparedStatement ps = connection.prepareStatement(query);
    	ResultSet set = ps.executeQuery();
    	
    	while (set.next()) {
    		BrandOfCar brand = new BrandOfCar();
    		
    		brand.setId(set.getInt(COLUMN_NAME_ID));
    		brand.setName(set.getString(COLUMN_NAME_BRAND_OF_CAR));
    		brand.setLoadingCapacity(set.getInt(COLUMN_NAME_LOADING_CAPACITY));
    		brand.setCapacity(set.getInt(COLUMN_NAME_CAPACITY));
    		brand.setCostPerKM(set.getInt(COLUMN_NAME_COST_PER_KM));
    		
    		list.add(brand);
    	}
    	poolInstance.addOpenConnection(connection);
    	return list;
    }
    
    public Map<Integer, BrandOfCar> getBrandsOfCarsById() throws SQLException, InterruptedException {
    	Map<Integer, BrandOfCar> map = new HashMap<>();
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_GET_BRANDS_OF_CAR;
    	PreparedStatement ps = connection.prepareStatement(query);
    	ResultSet set = ps.executeQuery();
    	
    	while (set.next()) {
    		int id = set.getInt(COLUMN_NAME_ID);
    		BrandOfCar brand = new BrandOfCar();
    		
    		brand.setId(set.getInt(COLUMN_NAME_ID));
    		brand.setName(set.getString(COLUMN_NAME_BRAND_OF_CAR));
    		brand.setLoadingCapacity(set.getInt(COLUMN_NAME_LOADING_CAPACITY));
    		brand.setCapacity(set.getInt(COLUMN_NAME_CAPACITY));
    		brand.setCostPerKM(set.getInt(COLUMN_NAME_COST_PER_KM));
    		
    		map.put(id, brand);
    	}
    	poolInstance.addOpenConnection(connection);
    	return map;
    }
    
    public void deleteBrandOfCarById(int id) throws SQLException, InterruptedException {
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_DELETE_BRAND_OF_CAR_BY_ID;
    	PreparedStatement ps = connection.prepareStatement(query);
    	
    	ps.setInt(1, id);
    	//TODO  DELETE FROM `avtobase`.`brands_of_cars` WHERE `fid`='номер';
    	
    	ps.executeQuery();
    	
    	poolInstance.addOpenConnection(connection);
    }

	@Override
	public boolean isBrandsOfCarsExist(String brandName) throws SQLException, InterruptedException {
		Connection connection = poolInstance.take();
    	PreparedStatement ps;
        String query =  SqlHelper.SQL_GET_BRANDS_OF_CAR_BY_NAME;
        ps = connection.prepareStatement(query);

        ps.setString(1, brandName);
        ResultSet result = ps.executeQuery();
		poolInstance.addOpenConnection(connection);
		return result.next();
	}
}