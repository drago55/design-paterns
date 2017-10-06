package main.behavior_design_patterns.mediator;

public interface ChatMediator {
	public void sendMessage(String msg, User user);
	void addUser(User user);
}
