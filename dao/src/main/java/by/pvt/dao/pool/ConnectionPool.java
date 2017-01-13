package by.pvt.dao.pool;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.pvt.exception.InitException;
import by.pvt.SourceInit;
import by.pvt.dao.util.ConfigParser;

public class ConnectionPool implements Closeable, SourceInit{
	private final static  ConnectionPool instance = new ConnectionPool();
	private final static String CONFIG_XML = "config/config.xml";
	private BlockingQueue<Connection> freeConnections;
	private BlockingQueue<Connection> busyConnections;
	//command-1.0-SNAPSHOT
	//src/main/java/by/pvt/resource/config/config.xml
	private ConnectionPool(){}
	
	public static ConnectionPool getInstance() {
		return instance;
	}
	
	@Override
	public void init() throws InitException {
		try{
			String driverName, url , login, password;
			int poolSize;
			ConfigParser parser = new ConfigParser();
			parser.parseConfig(CONFIG_XML);
			
			driverName = parser.getDriver();
			url = parser.getUrl();
			login = parser.getLogin();
			password = parser.getPassword();
			poolSize = parser.getPoolSize();
			Driver driver;
		
			driver = (Driver) Class.forName(driverName).newInstance();
			DriverManager.registerDriver(driver);
			freeConnections = new ArrayBlockingQueue<>(poolSize);
			busyConnections = new ArrayBlockingQueue<>(poolSize);
			
			for(int i=0; i<poolSize; i++){
				freeConnections.add(DriverManager.getConnection(url, login, password));
			}
		} catch (SQLException | ParserConfigurationException | SAXException | IOException | 
				InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new InitException("ConnectionPool init not executed");
		}
	}
	
	@Override
	public void destroy() {
		try {
			close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public Connection take() throws InterruptedException{
		Connection con = freeConnections.take();
		busyConnections.put(con);
		return con;
	}
	
	public void addOpenConnection(Connection con) throws InterruptedException{
		if(con == null){
			throw new RuntimeException("Connection is NULL");
		}
		
		Connection tempCon = con;
		con = null;
		busyConnections.remove(tempCon);
		freeConnections.put(tempCon);
	}
	
	@Override
	public void close() throws IOException {
		if (freeConnections != null) {
			BlockingQueue<Connection> free = freeConnections;
			freeConnections = null;
			for (Connection con : free) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new IOException();
				}
			}
			free.clear();
			BlockingQueue<Connection> busy = busyConnections;
			freeConnections = null;
			for (Connection con : busy) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new IOException();
				}
			}
			busy.clear();
		}
	}
}
