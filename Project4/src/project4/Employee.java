package project4;

public abstract class Employee {
	public static final short OPERATOR = 1;
	public static final short PROVIDER = 2;
	public static final short MANAGER = 3;
	
	protected short employeeType;
	private int id;
	private String password;
	private String username;
	
	Employee(short employeeType, int id, String Username) {
		this.employeeType = employeeType;
		this.username = Username;
		this.id = id;
		this.password = "password";
	}
	
	public short getEmployeeType() {
		return this.employeeType;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return this.username;
	}
 }
