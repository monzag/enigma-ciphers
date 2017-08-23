package app;

import registry.ServiceProvider;
import enigma.TerminalTranslator;


public interface Module{
	public void initialize(ServiceProvider provider);
	public String getName();
	public void start();
}
