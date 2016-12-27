package by.pvt.command.impl.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.pvt.command.PageNames;
import by.pvt.command.impl.Command;

public class Localization  extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.setAttribute("local", request.getParameter("local"));
		return PageNames.START_PAGE;
	}
}