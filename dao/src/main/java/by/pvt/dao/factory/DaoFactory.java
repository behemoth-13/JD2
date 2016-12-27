package by.pvt.dao.factory;

import java.util.HashMap;
import java.util.Map;

import by.pvt.SourceInit;
import by.pvt.dao.SqlDAO;
import by.pvt.dao.impl.SqlBrandsOfCarDAO;
import by.pvt.dao.impl.SqlCarDAO;
import by.pvt.dao.impl.SqlOrderDAO;
import by.pvt.dao.impl.SqlTripDAO;
import by.pvt.dao.impl.SqlUserDAO;
import by.pvt.exception.InitException;

public class DaoFactory implements SourceInit{
	private static final DaoFactory instance = new DaoFactory();
	public static Map<DaoName, SqlDAO> map = new HashMap<>();
	
	private DaoFactory(){}
	
	public static DaoFactory getInstance() {
		return instance;
	}

	@Override
	public void init() throws InitException {
		try {
			map.put(DaoName.USER_DAO, SqlUserDAO.getInstance());
			map.put(DaoName.ORDER_DAO, SqlOrderDAO.getInstance());
			map.put(DaoName.TRIP_DAO, SqlTripDAO.getInstance());
			map.put(DaoName.BRANDS_OF_CAR_DAO, SqlBrandsOfCarDAO.getInstance());
			map.put(DaoName.CAR_DAO, SqlCarDAO.getInstance());
		} catch (RuntimeException e) {
			throw new InitException("ConnectionPool init not executed");
		}
	}

	@Override
	public void destroy() {
		map.clear();
	}
	
	public SqlDAO getOperationDAO(DaoName daoName) {
		return map.get(daoName);
	}
}