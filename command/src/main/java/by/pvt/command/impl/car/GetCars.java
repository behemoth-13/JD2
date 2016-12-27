package by.pvt.command.impl.car;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.pvt.bean.Car;
import by.pvt.bean.constants.Roles;
import by.pvt.command.AttributeNames;
import by.pvt.command.PageNames;
import by.pvt.command.impl.Command;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.CarService;
import by.pvt.service.factory.ServiceName;

public class GetCars extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		CarService service = (CarService) serviceFactory.getOperationService(ServiceName.CAR_SERVICE);
        Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
		
		if ((role != Roles.ADMIN.getCodeRole()) && (role != Roles.MANAGER.getCodeRole())) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		List<Car> list = null;
		try {
			list = service.getCars();
			request.setAttribute(AttributeNames.LIST_BRANDS_OF_CARS, list);
		} catch (OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		return PageNames.SHOW_CARS;
	}
}