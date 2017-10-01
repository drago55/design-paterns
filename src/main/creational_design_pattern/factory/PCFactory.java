package main.creational_design_pattern.factory;

public class PCFactory implements ComputerAbstractFactory {
	
	private String ram;
	private String hdd;
	private String cpu;
	
	@Override
	public Computer createComputer() {
		
		return new PC(ram,hdd,cpu);
	}

}
