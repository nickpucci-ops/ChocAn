package project4;

public abstract class Employee {
	public static final short OPERATOR = 1;
	public static final short PROVIDER = 2;
	public static final short MANAGER = 3;
	
	protected Terminal terminal;
	protected short employeeType;
	private int id;
	private String password;
	
	Employee(Terminal terminal, short employeeType, int id) {
		this.terminal = terminal;
		this.employeeType = employeeType;
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
}
