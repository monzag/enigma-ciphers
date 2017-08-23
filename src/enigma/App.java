package enigma;

import services.EnigmaService;
import enigma.TerminalTranslator;
import enigma.ServiceRepository; // czy to trzeba importować skoro jest w tym samym folderze
import app.Module;

public class App {

    public void showHelp(){
        //tutaj ogarnąć jak to ma być. Czy inicjalizować muszę to repozytorium czy jak to wywołać
        //czy może zamienić w tym 'ServiceRepository' na static tą metode ?
        ArrayList<String> allCiphers = this.repository.listAll();
        System.out.println("Possible ciphers: ");
        for (String cipher : allCiphers) {
            System.out.println(cipher);
        }
    }

    public void initializeServiceRepository() {
        this.repository = new ServiceRepository();
    }

    public void start(String cipher, String option) {
        initializeServiceRepository();
        this.translator = new TerminalTranslator();
        this.translator.initialize(ServiceRepository this.repository);
        this.translator.setParameters(String cipher, String option); //przekazać to
    }

	public static void main(String[] args) {
        start(args[0], args[1]);
	}
}
