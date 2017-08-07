package registry;

import services.EnigmaService;


public interface ServiceProvider{
	public String[] listAll();
	public EnigmaService getByName(String name);
}
