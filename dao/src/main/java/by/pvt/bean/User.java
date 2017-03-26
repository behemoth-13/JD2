package by.pvt.bean;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -6331985382165408876L;
	
	private int id;
	private String name;
	private String surname;
	private String login;
	private String email;
	private String phone;
	private int role;
	private String creationDate;
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getLogin() {
		return login;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public int getRole() {
		return role;
	}
	public String getCreationDate() {
		return creationDate;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
}