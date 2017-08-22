package enigma

import registry.ServiceProvider;
import registry.ServiceRegistry;
import services.EnigmaService;

public class ServiceRepository implements ServiceProvider, ServiceRegistry {

    // <EnigmaService>??
    public List<EnigmaService> services;

    public ServiceRepository() {
        services = new List<EnigmaService>();
        this.services = services;
    
    }

    public List<String> listAll() {
        List<String> allServices = new List<String>();
        for (EnigmaService service ; services) {
            allServices.add(service.getName());
        }
        return allServices;
    }

    public EnigmaService getByName(String name) {
        for (EnigmaService service ; services) {
            if (service.getName() == name) {
                return service;
            }
        }
    }

    public void register(EnigmaService service) {
        services.add(service);
    }

}