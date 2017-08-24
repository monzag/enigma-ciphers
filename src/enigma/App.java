package enigma;

import services.EnigmaService;
import app.Module;
import java.util.*;


public class App {

    TerminalTranslator translator;
    ServiceRepository repository;
    ArrayList<String> allCiphers;

    public void showHelp(){
        allCiphers = this.repository.listAll();

        System.out.println("Possible ciphers: ");
        for (String cipher : allCiphers) {
            System.out.println(cipher);
        }
    }

    public boolean isCipherPossible(String toCheck) {
        boolean doesCipherExists = false;

        for (String cipher : allCiphers) {
            if (cipher.equals(toCheck)) { doesCipherExists = true; }
        }

        return doesCipherExists;
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
        Integer size = args.length;
        app.initializeServiceRepository();

        if (size.equals(0)) {
            System.out.println("Give at least one parameter.");
        } else if (size.equals(1)) {
            if (args[0].equals("-l")) { app.showHelp(); }
            else { System.out.println("Wrong Parameter. Type '-l', '-e' or '-d'"); }
        } else if (size.equals(2)) {
            app.start(args[0], args[1]);
        } else if (size.equals(3)) {
            app.start(args[0], args[1], args[2]);
        }
	}
}
