package by.pvt.command.impl.car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.pvt.bean.Car;
import by.pvt.bean.constants.Roles;
import by.pvt.command.AttributeNames;
import by.pvt.command.PageNames;
import by.pvt.command.ParameterNames;
import by.pvt.command.impl.Command;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.CarService;
import by.pvt.service.factory.ServiceName;

public class AddCar extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
		
		if (role != Roles.ADMIN.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		try {
			Car car = new Car();
			car.setDriversUsersId(Integer.parseInt(request.getParameter(ParameterNames.C_DRIVER_USER_ID).trim()));
		    car.setBrandsOfCarsId(Integer.parseInt(request.getParameter(ParameterNames.C_BRAND_OF_CAR_ID).trim()));
			car.setStateNumber(request.getParameter(ParameterNames.C_STATE_NUMBER).trim());
			car.setStatus(Integer.parseInt(request.getParameter(ParameterNames.C_STATUS).trim()));
			car.setCountOfKM(Integer.parseInt(request.getParameter(ParameterNames.C_COUNT_OF_KM).trim()));
			CarService service = (CarService) serviceFactory.getOperationService(ServiceName.CAR_SERVICE);
			service.addCar(car);
			request.setAttribute(AttributeNames.MESSAGE, "Car successfully added");
		} catch (IllegalArgumentException | OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}catch (Exception e) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong input");
			return PageNames.EXCEPTION;
		}
		return PageNames.SUCCESS;
	}
}