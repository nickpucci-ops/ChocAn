package project4;

public class Operator extends Employee {
	
	Operator(int id) {
		super(Employee.OPERATOR, id);
		
	}
	
	public void addMember(Terminal terminal, Member member) {
		terminal.getMembers().add(member);
	}
	
	public void editMember(Terminal terminal, Member member) {
		for(Member memberItem : terminal.getMembers()) {
			if(memberItem.getMemberNumber() == member.getMemberNumber()) {
				terminal.getMembers().set(terminal.getMembers().indexOf(memberItem), member);
				return;
			}
		}
	}
	
	public void removeMember(Terminal terminal, Member member) {
		terminal.getMembers().remove(member);
	}
	
	public void addProvider(Terminal terminal, Provider provider) {
		terminal.getEmployees().add(provider);
	}
	
	public void editProvider(Terminal terminal, Provider provider) {
		for(Employee employee : terminal.getEmployees()) {
			if(employee.getId() == provider.getId()) {
				employee = provider;
				return;
			}
		}
	}
	
	public void removeProvider(Terminal terminal, Provider provider) {
		terminal.getEmployees().remove(provider);
	}
	
	
}
