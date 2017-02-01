package by.pvt.command.impl.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.pvt.bean.Order;
import by.pvt.bean.constants.Roles;
import by.pvt.command.AttributeNames;
import by.pvt.command.PageNames;
import by.pvt.command.impl.Command;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.OrderService;
import by.pvt.service.factory.ServiceName;

public class GetOrdersByUsersId extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		OrderService service = (OrderService) serviceFactory.getOperationService(ServiceName.ORDER_SERVICE);
        int role = (int) session.getAttribute(AttributeNames.ROLE);
        
		if (role != Roles.USER.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		List<Order> list = null;
		int userId = (int) session.getAttribute(AttributeNames.USER_ID);
		try {
			list = service.getOrdersByUsersId(userId);
			request.setAttribute(AttributeNames.LIST_ORDERS, list);
		} catch (OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		return PageNames.SHOW_ORDERS;
	}
}