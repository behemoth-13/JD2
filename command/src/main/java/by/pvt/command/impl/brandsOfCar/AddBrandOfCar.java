package by.pvt.command.impl.brandsOfCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.pvt.bean.BrandOfCar;
import by.pvt.bean.constants.Roles;
import by.pvt.command.AttributeNames;
import by.pvt.command.PageNames;
import by.pvt.command.ParameterNames;
import by.pvt.command.impl.Command;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.BrandsOfCarService;
import by.pvt.service.factory.ServiceName;

public class AddBrandOfCar extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		BrandsOfCarService service = (BrandsOfCarService) serviceFactory.getOperationService(ServiceName.BRANDS_OF_CAR_SERVICE);
		Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
		
		if (role != Roles.ADMIN.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		try {
			BrandOfCar brandOfCar = new BrandOfCar();
			brandOfCar.setName(request.getParameter(ParameterNames.BOC_NAME).trim());
			brandOfCar.setLoadingCapacity(Integer.parseInt(request.getParameter(ParameterNames.BOC_LOADING_CAPACITY).trim()));
			brandOfCar.setCapacity(Integer.parseInt(request.getParameter(ParameterNames.BOC_CAPACITY).trim()));
			brandOfCar.setCostPerKM(Double.parseDouble(request.getParameter(ParameterNames.BOC_COST_PER_KM).trim()));
			service.addBrandOfCar(brandOfCar);
			request.setAttribute(AttributeNames.MESSAGE, "Brand of car successfully added");
		} catch (IllegalArgumentException | OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		} catch (Exception e) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong input");
			return PageNames.EXCEPTION;
		}
		return PageNames.SUCCESS;
	}
}