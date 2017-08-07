package app;

import registry.ServiceProvider;


public interface AppModule{
	public void initialize(ServiceProvider provider);
	public String getName();
	public void start();
}
