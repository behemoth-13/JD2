package by.pvt.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.pvt.command.CommandInterface;
import by.pvt.service.factory.ServiceFactory;

public abstract class Command implements CommandInterface{

	protected static ServiceFactory serviceFactory;
	
	protected Command() {
		serviceFactory = ServiceFactory.getInstance();
	}
	
	@Override
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);
}
