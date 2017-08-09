package app;

import registry.ServiceProvider;


public interface Module{
	public void initialize(ServiceProvider provider);
	public String getName();
	public void start();
}
