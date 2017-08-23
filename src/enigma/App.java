package enigma;

import services.EnigmaService;
import app.Module;
import java.util.*;


public class App {

    TerminalTranslator translator;
    ServiceRepository repository;

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
        this.translator = new TerminalTranslator();
        this.translator.initialize(this.repository);
        this.translator.setParameters(cipher, option); //przekazać to
    }

    public void start(String cipher, String option, String key) {
        this.translator = new TerminalTranslator();
        this.translator.initialize(this.repository);
        this.translator.setParameters(cipher, option, key); //przekazać to
    }

	public static void main(String[] args) {
        App app = new App();
        app.initializeServiceRepository();
        Integer size = args.length;

        if (size.equals(2)) {
            app.start(args[0], args[1]);
        } else if (size.equals(3)) {
            app.start(args[0], args[1], args[2]);
        }
	}
}
