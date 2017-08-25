package enigma;

import services.EnigmaService;
import app.Module;
import java.util.ArrayList;


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
        allCiphers = this.repository.listAll();

        for (String cipher : allCiphers) {
            if (cipher.equals(toCheck)) { doesCipherExists = true; }
        }
        return doesCipherExists;
    }

    public void initializeServiceRepository() {
        this.repository = new ServiceRepository();

        EnigmaService Caesar = new Caesar();
        EnigmaService RandomCaesar = new RandomCaesar();
        EnigmaService Atbash = new Atbash();
        EnigmaService ROT13 = new ROT13();
        EnigmaService SubstitutionCipher = new SubstitutionCipher();

        this.repository.register(Caesar);
        this.repository.register(RandomCaesar);
        this.repository.register(Atbash);
        this.repository.register(ROT13);
        this.repository.register(SubstitutionCipher);
    }

    public void initializeTranslator() {
        this.translator = new TerminalTranslator();
        this.translator.initialize(this.repository);
    }

    public void start(String option, String cipher) {
        initializeTranslator();
        this.translator.setParameters(cipher, option);
        this.translator.start();
    }

    public void start(String option, String cipher, String key) {
        initializeTranslator();
        this.translator.setParameters(cipher, option, key);
        this.translator.start();
    }

    public void handleWithWrongInputAndStart(App app, String[] args) {
        Integer size = args.length;

        if (size.equals(0)) {
            System.out.println("Missing data. Type: '-l', '-e CIPHER [KEY]' or '-d CIPHER [KEY]'");
        } else if (size.equals(1)) {
            if (args[0].equals("-l")) { app.showHelp(); }
            else { System.out.println("Wrong Parameter or missing data");
                   System.out.println("Type '-l', '-e CIPHER [KEY]' or '-d CIPHER [KEY]'"); }
        } else if (size.equals(2)) {
            if (app.isCipherPossible(args[1])) { app.start(args[0], args[1]); }
            else { System.out.println("No such cipher. Enter '-l' to list possible ciphers"); }
        } else if (size.equals(3)) {
            if (app.isCipherPossible(args[1])) { app.start(args[0], args[1], args[2]); }
            else { System.out.println("No such cipher. Enter '-l' to list possible ciphers"); }
        }
    }

	public static void main(String[] args) {
        App app = new App();
        app.initializeServiceRepository();
        app.handleWithWrongInputAndStart(app, args);
	}
}
