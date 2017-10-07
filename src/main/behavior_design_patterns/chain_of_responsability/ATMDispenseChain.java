package main.behavior_design_patterns.chain_of_responsability;

public class ATMDispenseChain {

	public DispenseChain c1;

	public ATMDispenseChain() {
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();

		c1.setNextChain(c2);
		c2.setNextChain(c3);

	}

}
