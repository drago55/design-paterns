package main.behavior_design_patterns.iterator;

public interface ChannelCollection {
	
	public void addChannel(Channel c);
	public void removeChannel(Channel c);
	public ChannelIterator iterator(ChannelTypeEnum type);
	
	
}
