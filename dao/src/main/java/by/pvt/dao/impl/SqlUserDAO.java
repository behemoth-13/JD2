package by.pvt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.pvt.bean.User;
import by.pvt.bean.constants.Roles;
import by.pvt.dao.SqlDAO;
import by.pvt.dao.UserDAO;
import by.pvt.dao.sql.SqlHelper;
import by.pvt.dao.util.CodePassword;

public class SqlUserDAO extends SqlDAO implements UserDAO{
	
    private static SqlUserDAO instance;
    
    private final String COLUMN_NAME_ID = "id";
    private final String COLUMN_NAME_NAME = "name";
    private final String COLUMN_NAME_SURNAME = "surname";
    private final String COLUMN_NAME_LOGIN = "login";
    private final String COLUMN_NAME_EMAIL = "email";
    private final String COLUMN_NAME_PHONE = "phone";
    private final String COLUMN_NAME_ROLE = "role";
    private final String COLUMN_NAME_DATE = "date";
    
    private SqlUserDAO() {}

    public static SqlUserDAO getInstance() {
        if (instance == null) {
            instance = new SqlUserDAO();
        }
        return instance;
    }
    
    public void registerUser(User user, String password) throws SQLException, InterruptedException {
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_ADD_USER;
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setString(1, user.getName());
    	ps.setString(2, user.getSurname());
    	ps.setString(3, user.getLogin());
    	ps.setString(4, CodePassword.getHashCode(password));
    	ps.setString(5, user.getEmail());
    	ps.setString(6, user.getPhone());
    	ps.setInt(7, user.getRole());
    	ps.setString(8, user.getCreationDate());
    	ps.executeUpdate();
    	poolInstance.addOpenConnection(connection);
    }
    
    public User getUser(String login, String password) throws SQLException, InterruptedException {
        User user = null;
        PreparedStatement ps = null;
        String query =  SqlHelper.SQL_GET_USER;
        ps = poolInstance.take().prepareStatement(query);
        
        ps.setString(1, login);
        ps.setString(2, password);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            user = new User();
            user.setId(result.getInt(COLUMN_NAME_ID));
            user.setName(result.getString(COLUMN_NAME_NAME));
            user.setSurname(result.getString(COLUMN_NAME_SURNAME));
            user.setLogin(result.getString(COLUMN_NAME_LOGIN));
            user.setEmail(result.getString(COLUMN_NAME_EMAIL));
            user.setPhone(result.getString(COLUMN_NAME_PHONE));
            user.setRole(result.getInt(COLUMN_NAME_ROLE));
            user.setCreationDate(result.getString(COLUMN_NAME_DATE));
        }
        return user;
    }
    
    public List<User> getUsers() throws SQLException, InterruptedException {
    	List<User> list = new ArrayList<>();
    	Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_GET_USERS;
    	PreparedStatement ps = connection.prepareStatement(query);
    	ResultSet result = ps.executeQuery();
    	
    	while (result.next()) {
    		User user = new User();
    		
    		user.setId(result.getInt(COLUMN_NAME_ID));
            user.setName(result.getString(COLUMN_NAME_NAME));
            user.setSurname(result.getString(COLUMN_NAME_SURNAME));
            user.setLogin(result.getString(COLUMN_NAME_LOGIN));
            user.setEmail(result.getString(COLUMN_NAME_EMAIL));
            user.setPhone(result.getString(COLUMN_NAME_PHONE));
            user.setRole(result.getInt(COLUMN_NAME_ROLE));
            user.setCreationDate(result.getString(COLUMN_NAME_DATE));
    		
    		list.add(user);
    	}
    	poolInstance.addOpenConnection(connection);
    	return list;
    }
    
    public User getUserById(int id) throws SQLException, InterruptedException {
        User user = null;
        PreparedStatement ps = null;
        String query =  SqlHelper.SQL_GET_USER_BY_ID;
        ps = poolInstance.take().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            user = new User();
            user.setId(result.getInt(COLUMN_NAME_ID));
            user.setName(result.getString(COLUMN_NAME_NAME));
            user.setSurname(result.getString(COLUMN_NAME_SURNAME));
            user.setLogin(result.getString(COLUMN_NAME_LOGIN));
            user.setEmail(result.getString(COLUMN_NAME_EMAIL));
            user.setPhone(result.getString(COLUMN_NAME_PHONE));
            user.setRole(result.getInt(COLUMN_NAME_ROLE));
            user.setCreationDate(result.getString(COLUMN_NAME_DATE));
        }
        return user;
    }

	@Override
	public void banUserById(int id) throws SQLException, InterruptedException {
		Connection connection = poolInstance.take();
    	String query = SqlHelper.SQL_BAN_USER_BY_ID;
    	PreparedStatement ps = connection.prepareStatement(query);
    	
    	ps.setInt(1, Roles.BANNED_USER.getCodeRole());
    	ps.setInt(2, id);
    	
    	ps.executeUpdate();
    	
    	poolInstance.addOpenConnection(connection);
	}
}
