package enigma

import registry.ServiceProvider;
import registry.ServiceRegistry;

public class ServiceRepository {

    // <EnigmaService>??
    public List<EnigmaService> services;

    public ServiceRepository() {
        services = new List<EnigmaService>();
        this.services = services;
    
    }

    public void register(EnigmaService service) {
        services.add(service)
    }

    public List<String> listAll() {

    }

    public EnigmaService getByName(String name) {

    }

}