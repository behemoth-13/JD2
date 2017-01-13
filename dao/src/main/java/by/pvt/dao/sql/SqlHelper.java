package by.pvt.dao.sql;

public class SqlHelper {
    //USERS
	public static final String SQL_ADD_USER = "INSERT INTO users(name, surname, login, password, email, phone, role, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_GET_USER = "SELECT * FROM users WHERE login = ? AND password = ?";
    public static final String SQL_GET_USERS = "SELECT * FROM users";
    public static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String SQL_BAN_USER_BY_ID = "UPDATE users SET role = ? WHERE id = ?";
    
    //DRIVERS
    
    //ORDERS
    public static final String SQL_ADD_ORDER = "INSERT INTO orders(users_id, weight, capacity, distance, status_order, time_status_order, creation_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_GET_ORDERS = "SELECT * FROM orders";
    public static final String SQL_GET_ORDERS_BY_USERS_ID = "SELECT * FROM orders WHERE users_id = ?";
    public static final String SQL_UPDATE_STATUS_ORDER_BY_ID = "UPDATE orders SET status_order = ? WHERE id = ?";
    public static final String SQL_GET_ORDERS_BY_STATUS = "SELECT * FROM orders WHERE status_order = ?";
    
    //TRIPS
    public static final String SQL_ADD_TRIP = "INSERT INTO trips(orders_id, users_id, drivers_users_id, cost) VALUES (?, ?, ?, ?)";
    public static final String SQL_GET_TRIPS = "SELECT * FROM trips";
    public static final String SQL_GET_TRIP_BY_ORDERS_ID = "SELECT * FROM trips WHERE id = ?";
    
    //BRANDS_OF_CARS
    public static final String SQL_ADD_BRAND_OF_CAR = "INSERT IGNORE INTO brands_of_cars(brand_of_car, loading_capacity, capacity, cost_per_km) VALUES (?, ?, ?, ?)";
    public static final String SQL_GET_BRANDS_OF_CAR = "SELECT * FROM brands_of_cars";
    public static final String SQL_DELETE_BRAND_OF_CAR_BY_ID = "DELETE FROM brands_of_cars WHERE id = ?";
    public static final String SQL_GET_BRANDS_OF_CAR_BY_NAME = "SELECT * FROM brands_of_cars WHERE brand_of_car = ?";
    
    //CARS
    public static final String SQL_ADD_CAR = "INSERT INTO cars(drivers_users_id, brands_of_cars_id, state_number, status, count_of_km) VALUES (?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE_COUNT_OF_KM_BY_DRIVER_ID = "UPDATE cars SET count_of_km = ? WHERE drivers_users_id = ?";
    public static final String SQL_GET_CARS = "SELECT * FROM cars";
    public static final String SQL_GET_CAR_BY_STATE_NUMBER = "SELECT * FROM cars WHERE state_number = ?";
    //public static final String SQL_DELETE_CAR_BY_STATE_NUMBER = "SQL_DELETE_CAR_BY_STATE_NUMBER";
}