package by.pvt.bean.constants;

public enum Roles {
	ADMIN(0), USER(1), GUEST(2), MANAGER(3),
	DRIVER(4), BANNED_USER(5);
	
	private int role;

	private Roles (int role){
		this.role = role;
	}
	
	public int getCodeRole(){
		return role;
	}
}