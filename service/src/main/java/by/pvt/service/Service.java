package by.pvt.service;

import by.pvt.dao.factory.DaoFactory;

public class Service {
	protected static DaoFactory daoFactory;
	
	protected Service() {
		daoFactory = DaoFactory.getInstance();
	}
}