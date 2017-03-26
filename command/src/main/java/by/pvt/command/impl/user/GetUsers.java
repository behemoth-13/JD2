package by.pvt.command.impl.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.pvt.bean.User;
import by.pvt.bean.constants.Roles;
import by.pvt.command.AttributeNames;
import by.pvt.command.PageNames;
import by.pvt.command.impl.Command;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.UserService;
import by.pvt.service.factory.ServiceName;

public class GetUsers extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserService service = (UserService) serviceFactory.getOperationService(ServiceName.USER_SERVICE);
        Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
		
		if (role != Roles.ADMIN.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		List<User> list = null;
		try {
			list = service.getUsers();
			request.setAttribute(AttributeNames.LIST_USERS, list);
		} catch (OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		return PageNames.SHOW_USERS;
	}
}