package enigma;

import services.EnigmaService;
import enigma.TerminalTranslator;
import enigma.ServiceRepository; // czy to trzeba importować skoro jest w tym samym folderze
import app.Module;

public class App {

    private static termianlTranslator = new TerminalTranslator();
    private static serviceRepository = new ServiceRepository();

    public void showHelp(){
        //tutaj ogarnąć jak to ma być. Czy inicjalizować muszę to repozytorium czy jak to wywołać
        //czy może zamienić w tym 'ServiceRepository' na static tą metode ?
        ArrayList<String> allCiphers = this.serviceRepository.listAll();
        System.out.println("Possible ciphers: ");
        for (String cipher : allCiphers) {
            System.out.println(cipher);
        }
    }

    public void initializeServiceRepository() {
        // this.repository = new ServiceRepository();
        // repository.register
    }

    public void start() {
        termianlTranslator.setParameters(EnigmaService cipher, String args[1]);

    }

	public static void main(String[] args) {
        start();
	}
}
