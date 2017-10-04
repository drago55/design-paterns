package main.structural_design_patterns.adapter;

public class Socket {
	
	//we have a socket with 120 volts
	
	public Volt getVolt() {
		return new Volt(120);
	}
}
