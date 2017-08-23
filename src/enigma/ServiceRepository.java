package enigma;

import registry.ServiceProvider;
import registry.ServiceRegistry;
import services.EnigmaService;
import java.util.ArrayList;

public class ServiceRepository implements ServiceProvider, ServiceRegistry {

    // <EnigmaService>??
    public ArrayList<EnigmaService> services;

    public ServiceRepository() {
        services = new ArrayList<EnigmaService>();
        this.services = services;
<<<<<<< HEAD
    
=======

>>>>>>> Application
    }

    public ArrayList<String> listAll() {
        ArrayList<String> allServices = new ArrayList<String>();
        for (EnigmaService service : services) {
            allServices.add(service.getName());
        }
        return allServices;
    }

    public EnigmaService getByName(String name) {
        EnigmaService result = null;
        for (EnigmaService service : services) {
            if (service.getName() == name) {
                result = service;
            }
        }
        return result;
<<<<<<< HEAD
    } 
=======
    }
>>>>>>> Application


    public void register(EnigmaService service) {
        services.add(service);
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> Application
