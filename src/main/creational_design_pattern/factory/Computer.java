package main.creational_design_pattern.factory;


/*Factory design pattern is used when we have super class with multiple sub-classes 
* and based on input we need to return one of the sub-class
*/

public abstract class Computer {
	 
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	
	@Override
	public String toString() {
		
		return  "RAM= "+ this.getRAM()+ ", HDD="+this.getHDD()+", CPU="+this.getCPU();
	}
	
	
}
