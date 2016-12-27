package by.pvt.command.impl.brandsOfCar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.pvt.bean.BrandOfCar;
import by.pvt.command.AttributeNames;
import by.pvt.command.PageNames;
import by.pvt.command.impl.Command;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.BrandsOfCarService;
import by.pvt.service.factory.ServiceName;

public class GetBrandsOfCars extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BrandsOfCarService service = (BrandsOfCarService) serviceFactory.getOperationService(ServiceName.BRANDS_OF_CAR_SERVICE);
		
		List<BrandOfCar> list = null;
		try {
			list = service.getBrandsOfCars();
		} catch (OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		request.setAttribute(AttributeNames.LIST_BRANDS_OF_CARS, list);
		return PageNames.SHOW_BRANDS_OF_CARS;
	}
}