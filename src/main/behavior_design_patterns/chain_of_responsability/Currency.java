package main.behavior_design_patterns.chain_of_responsability;

public class Currency {
	private int amonut;
	
	public Currency(int amt) {
		this.amonut=amt;
	}
	
	public int getAmount() {
		return this.amonut;
	}
	
}
