package main.creational_design_pattern.factory;

public class PCFactory implements ComputerAbstractFactory {
	//We are implementing method createComputer from interface ComputerAbstractFactory  
	private String ram;
	private String hdd;
	private String cpu;
	
	
	public PCFactory(String ram, String hdd, String cpu) {
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	@Override
	public Computer createComputer() {
		
		return new PC(ram,hdd,cpu);
	}

}
