package enigma;

import services.EnigmaService;
import app.Module;
import java.util.*;


public class App {

    TerminalTranslator translator;
    ServiceRepository repository;

    public void showHelp(){
        ArrayList<String> allCiphers = this.repository.listAll();

        System.out.println("Possible ciphers: ");
        for (String cipher : allCiphers) {
            System.out.println(cipher);
        }
    }

    public void initializeServiceRepository() {
        this.repository = new ServiceRepository();
        EnigmaService ROT13 = new ROT13();
        this.repository.register(ROT13);
        EnigmaService Atbash = new Atbash();
        this.repository.register(Atbash);
    }

    public void start(String option, String cipher) {
        this.translator = new TerminalTranslator();
        this.translator.initialize(this.repository);
        this.translator.setParameters(cipher, option);
        this.translator.start();
    }

    public void start(String option, String cipher, String key) {
        this.translator = new TerminalTranslator();
        this.translator.initialize(this.repository);
        this.translator.setParameters(cipher, option, key);
        this.translator.start();
    }

	public static void main(String[] args) {
        App app = new App();
        if (args[0].equals("-l")) { app.showHelp(); }
        app.initializeServiceRepository();
        Integer size = args.length;

        if (size.equals(2)) {
            app.start(args[0], args[1]);
        } else if (size.equals(3)) {
            app.start(args[0], args[1], args[2]);
        }
	}
}
