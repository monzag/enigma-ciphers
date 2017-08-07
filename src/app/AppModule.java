package app;

import registry.ServiceProvider;


public interface AppModule{
	public void start(ServiceProvider provider);
	public void getName();
}
