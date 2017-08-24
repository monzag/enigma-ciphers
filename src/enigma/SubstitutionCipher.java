package enigma;

import services.EnigmaService;
import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Character;


public class SubstitutionCipher implements EnigmaService {

    public String key;
    private static HashMap<String, String> cipherAlphabet = new HashMap<String, String>();


    private static void createCipherAlphabet() {
        cipherAlphabet.put("A", "P"); cipherAlphabet.put("B", "H"); cipherAlphabet.put("C", "Q");
    }
    //
    // C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
    // qgiumeaylnofdxjkrcvstzwb

    public SubstitutionCipher(){
        this.key = null;
    }

    public String decipher(String toCipher) {
        String cipheredWord = "";

        for (int i = 0; i < toCipher.length(); i++) {
            cipheredWord += cipherAlphabet.get(toCipher.charAt(i));
        }

        System.out.println(cipheredWord);
        return cipheredWord;
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
