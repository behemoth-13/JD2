package by.pvt.dao;


import by.pvt.dao.pool.ConnectionPool;

public class SqlDAO {
	protected static ConnectionPool poolInstance;
	
	protected SqlDAO() {
		poolInstance = ConnectionPool.getInstance();
	}
}
