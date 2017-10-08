package main.behavior_design_patterns.state;

public class TVContext implements State {

	private State tvState;

	public State getTvState() {
		return tvState;
	}

	public void setTvState(State state) {
		this.tvState = state;
	}

	@Override
	public void doAction() {
		this.tvState.doAction();
	}

}
