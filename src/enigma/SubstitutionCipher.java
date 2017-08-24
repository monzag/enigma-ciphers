package enigma;

import services.EnigmaService;
import java.lang.StringBuffer;
import java.util.ArrayList;

public class SubstitutionCipher implements EnigmaService {

    public String key;
    public ArrayList<String> generatedKey;

    public SubstitutionCipher(){
        this.generatedKey = generateRandomKey();
    }

    private ArrayList<String> generateRandomKey() {
        ArrayList<String> ascii = new ArrayList<String>();
        return ascii;
    }

    public String decipher(String toCipher) {
        return "  ";
    }


    public String encipher(String toCipher) {
        return "  ";
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public boolean isKeyRequired() {
        return false;
    }

    public void setKey(String key) {
        if (isKeyRequired() == true) {
            this.key = key;
        }
    }
}
