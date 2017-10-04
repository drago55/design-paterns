package main.structural_design_patterns.adapter;

public class Volt {
    
	//object volts 
	
	private int volts;

	public Volt(int v) {

		this.volts = v;

	}
	
	public int getVolts() {
		return volts;
	}
	public void setVolts(int volts) {
		this.volts=volts;
	}
}
