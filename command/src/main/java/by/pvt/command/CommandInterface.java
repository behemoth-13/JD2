package by.pvt.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface CommandInterface {
	String execute(HttpServletRequest request, HttpServletResponse response);
}