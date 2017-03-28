package by.pvt.service.impl;

import java.sql.SQLException;
import java.util.List;

import by.pvt.bean.User;
import by.pvt.bean.constants.Roles;
import by.pvt.dao.UserDAO;
import by.pvt.dao.factory.DaoName;
import by.pvt.dao.util.CodePassword;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.Service;
import by.pvt.service.UserService;
import by.pvt.service.validation.DataValidation;

public class UserServiceImpl  extends Service implements UserService{

	private static UserServiceImpl instance;
	
	private UserServiceImpl(){}
	
	public static UserServiceImpl getInstance() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void registerUser(User user, String password) throws OperationNotExecutedException, IllegalArgumentException{
		
		String message = validateUser(user, password);
		if (message.length() != 0){
			throw new IllegalArgumentException(message);
		}
		
		UserDAO dao = (UserDAO) daoFactory.getOperationDAO(DaoName.USER_DAO);
		String newLogin = user.getLogin();
		try {
			User userFromDao = dao.getUser(newLogin, password);
			if (userFromDao == null) {
				dao.registerUser(user, password);
			} else {
				throw new IllegalArgumentException("User is already exist");
			}
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("UserServiceImpl.registerUser not executed");
		}
	}

	@Override
	public List<User> getUsers() throws OperationNotExecutedException{
		UserDAO dao = (UserDAO) daoFactory.getOperationDAO(DaoName.USER_DAO);
		try {
			return dao.getUsers();
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("UserServiceImpl.getUsers not executed");
		}
	}

	@Override
	public void banUserById(int id) throws OperationNotExecutedException, IllegalArgumentException {
		UserDAO dao = (UserDAO) daoFactory.getOperationDAO(DaoName.USER_DAO);
		User userFromDao = null;
		try {
			userFromDao = dao.getUserById(id);
		} catch (SQLException | InterruptedException e) {
			throw new IllegalArgumentException("User is not exist");
		}
		if (userFromDao.getRole() == Roles.ADMIN.getCodeRole()) {
			throw new IllegalArgumentException("Cannot ban admin");
		} else {
			try {
				dao.banUserById(id);
			} catch (SQLException | InterruptedException e) {
				throw new OperationNotExecutedException("UserServiceImpl.banUserById not executed");
			}
		}
	}
	
	@Override
		public User getUser(String login, String password) throws OperationNotExecutedException {
		UserDAO dao = (UserDAO) daoFactory.getOperationDAO(DaoName.USER_DAO);
		User user = null;
		try {
				user = dao.getUser(login, CodePassword.getHashCode(password));
			} catch (SQLException | InterruptedException e) {
				throw new OperationNotExecutedException("User is not exist");
			}
			return user;
		}

	@Override
	public void updateUserRole(int userId, int userRole) throws OperationNotExecutedException, IllegalArgumentException {
		UserDAO dao = (UserDAO) daoFactory.getOperationDAO(DaoName.USER_DAO);
		Roles[] roles = Roles.values();
		if (userRole < roles[0].getCodeRole() || userRole > roles[roles.length -1].getCodeRole()) {
			throw new IllegalArgumentException("Role is not exist");
		}
		try {
			dao.updateUserRole(userId, userRole);
		} catch (SQLException | InterruptedException e) {
			throw new OperationNotExecutedException("Role is not changed");
		}
	}

	private String validateUser(User user, String password) {
		StringBuilder messageException = new StringBuilder();
		if (!DataValidation.namePattern.matcher(user.getName()).matches()) {
			messageException.append("name is not valid \n");
        }
		if (!DataValidation.surnamePattern.matcher(user.getSurname()).matches()) {
			messageException.append("surname is not valid \n");
        }
		if (!DataValidation.loginPattern.matcher(user.getLogin()).matches()) {
			messageException.append("login is not valid \n");
        }
		if (!DataValidation.emailPattern.matcher(user.getEmail()).matches()) {
			messageException.append("email is not valid \n");
        }
		if (!DataValidation.phonePattern.matcher(user.getPhone()).matches()) {
			messageException.append("phone is not valid \n");
        }
		if (!DataValidation.passwordPattern.matcher(password).matches()) {
			messageException.append("password is not valid \n");
        }
		return messageException.toString();
	}

	
}
