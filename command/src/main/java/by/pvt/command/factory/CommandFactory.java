package by.pvt.command.factory;

import java.util.HashMap;
import java.util.Map;

import by.pvt.SourceInit;
import by.pvt.command.impl.Command;
import by.pvt.command.impl.brandsOfCar.AddBrandOfCar;
import by.pvt.command.impl.brandsOfCar.GetBrandsOfCars;
import by.pvt.command.impl.car.AddCar;
import by.pvt.command.impl.car.GetCars;
import by.pvt.command.impl.car.UpdateCountOfKM;
import by.pvt.command.impl.localization.Localization;
import by.pvt.command.impl.order.AddOrder;
import by.pvt.command.impl.order.GetOrders;
import by.pvt.command.impl.order.GetOrdersByStatus;
import by.pvt.command.impl.order.GetOrdersByUsersId;
import by.pvt.command.impl.order.UpdateStatusOrderByID;
import by.pvt.command.impl.trip.GetTrips;
import by.pvt.command.impl.trip.UpdateStatusTripByID;
import by.pvt.command.impl.user.BanUserById;
import by.pvt.command.impl.user.Exit;
import by.pvt.command.impl.user.GetUsers;
import by.pvt.command.impl.user.Logination;
import by.pvt.command.impl.user.RegisterUser;
import by.pvt.exception.InitException;

public class CommandFactory implements SourceInit {

	private static CommandFactory instance = new CommandFactory();
	private static Map<String, Command> map = new HashMap<>();
	
	private CommandFactory(){}
	
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public Command getCommand(String commandName) {
		//System.out.println(commandName);
		if (map.containsKey(commandName)) {
			return map.get(commandName);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public void init() throws InitException {
		map.put("ba", new AddBrandOfCar());
		map.put("bg", new GetBrandsOfCars());
		map.put("ca", new AddCar());
		map.put("cg", new GetCars());
		map.put("cu", new UpdateCountOfKM());
		map.put("oa", new AddOrder());
		map.put("og", new GetOrders());
		map.put("ob", new GetOrdersByStatus());
		map.put("ou", new GetOrdersByUsersId());
		map.put("os", new UpdateStatusOrderByID());
		map.put("tg", new GetTrips());
		map.put("tu", new UpdateStatusTripByID());
		map.put("ub", new BanUserById());
		map.put("ug", new GetUsers());
		map.put("ur", new RegisterUser());
		map.put("ul", new Logination());
		map.put("ue", new Exit());
		map.put("ll", new Localization());
	}

	@Override
	public void destroy() {
		map.clear();		
	}

}
