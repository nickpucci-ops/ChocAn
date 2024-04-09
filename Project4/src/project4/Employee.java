package project4;


/**
 * Employee abstract class is a generic type used by Provider, Operator, and Manager
 * @author Logan Millet
 */
public abstract class Employee {
	public static final short OPERATOR = 1;
	public static final short PROVIDER = 2;
	public static final short MANAGER = 3;
	
	protected short employeeType;
	private int id;
	private String password;
	private String username;
	
	/**
	 * Constructor for the Employee class
	 * 
	 * @param employeeType is the type of employee (operator, manager, provider)
	 * @param id is the identification number of the employee
	 * @param Username is the username of the employee
	 */
	Employee(short employeeType, int id, String Username) {
		this.employeeType = employeeType;
		this.username = Username;
		this.id = id;
		this.password = "password";
	}
	
	/**
	 * Gets the employeeType for the instance
	 */
	public short getEmployeeType() {
		return this.employeeType;
	}
	
	/**
	 * Gets the id for the instance
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Gets the password for the instance
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Gets the username for the instance
	 */
	public String getUsername() {
		return this.username;
	}
 }
