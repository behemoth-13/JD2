package by.pvt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.pvt.command.PageNames;
import by.pvt.command.ParameterNames;
import by.pvt.command.factory.CommandFactory;
import by.pvt.command.impl.Command;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 6574185461734484712L;

    public Controller() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response);		
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        CommandFactory factory = CommandFactory.getInstance();
        String commandParameter = request.getParameter(ParameterNames.COMMAND);
        Command command = factory.getCommand(commandParameter);
		String page = command.execute(request, response);
        if(page == null) {
            page = PageNames.START_PAGE;
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			
		}
	}
}
