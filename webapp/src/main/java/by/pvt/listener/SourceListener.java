package by.pvt.listener;

import by.pvt.SourceInit;
import by.pvt.command.factory.CommandFactory;
import by.pvt.dao.factory.DaoFactory;
import by.pvt.dao.pool.ConnectionPool;
import by.pvt.exception.InitException;
import by.pvt.service.factory.ServiceFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class SourceListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		SourceInit connectionPool = ConnectionPool.getInstance();
		SourceInit daoFactory = DaoFactory.getInstance();
		SourceInit serviceFactory = ServiceFactory.getInstance();
		SourceInit commandFactory = CommandFactory.getInstance();
		connectionPool.destroy();
		daoFactory.destroy();
		serviceFactory.destroy();
		commandFactory.destroy();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		SourceInit connectionPool = ConnectionPool.getInstance();
		SourceInit daoFactory = DaoFactory.getInstance();
		SourceInit serviceFactory = ServiceFactory.getInstance();
		SourceInit commandFactory = CommandFactory.getInstance();
		
		try {
			connectionPool.init();
			daoFactory.init();
			serviceFactory.init();
			commandFactory.init();
		} catch (InitException e) { }
	}
}
