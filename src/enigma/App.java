package enigma;

import services.EnigmaService;
import app.Module;

public class App {

    TerminalTranslator translator = null;
    ServiceRepository repository = null;

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
        // tutaj wklepać z tej metody dodającej na sztywno wszystkie szyfry
    }

    public void start(String cipher, String option) {
        initializeServiceRepository();
        this.translator = new TerminalTranslator();
        this.translator.initialize(this.repository);
        this.translator.setParameters(cipher, option); //przekazać to
    }

	public static void main(String[] args) {
        App app = new App();
        app.start(args[0], args[1]);
	}
}
