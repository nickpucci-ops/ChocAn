package project4;

public class Operator extends Employee {
	
	Operator(Terminal terminal, int id) {
		super(terminal, Employee.OPERATOR, id);
		
	}
	
	public void addMember(Member member) {
		terminal.getMembers().add(member);
	}
	
	public void editMember(Member member) {
		for(Member memberItem : terminal.getMembers()) {
			if(memberItem.getMemberNumber() == member.getMemberNumber()) {
				memberItem = member;
				return;
			}
		}
	}
	
	public void removeMember(Member member) {
		terminal.getMembers().remove(member);
	}
	
	public void addProvider(Provider provider) {
		terminal.getEmployees().add(provider);
	}
	
	public void editProvider(Provider provider) {
		for(Employee employee : terminal.getEmployees()) {
			if(employee.getId() == provider.getId()) {
				employee = provider;
				return;
			}
		}
	}
	
	public void removeProvider(Provider provider) {
		terminal.getEmployees().remove(provider);
	}
	
	
}
