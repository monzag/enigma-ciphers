package enigma;

import services.EnigmaService;
import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.Character;


public class SubstitutionCipher implements EnigmaService {

    public String key;
    private static HashMap<String, String> cipherAlphabet = new HashMap<String, String>();

    public SubstitutionCipher(){
        createCipherAlphabet();
        this.key = null;
    }

    private static void createCipherAlphabet() {
        cipherAlphabet.put("A", "P"); cipherAlphabet.put("B", "H"); cipherAlphabet.put("C", "Q");
        cipherAlphabet.put("D", "G"); cipherAlphabet.put("E", "I"); cipherAlphabet.put("F", "U");
        cipherAlphabet.put("G", "M"); cipherAlphabet.put("H", "E"); cipherAlphabet.put("I", "A");
        cipherAlphabet.put("J", "Y"); cipherAlphabet.put("K", "L"); cipherAlphabet.put("L", "N");
        cipherAlphabet.put("M", "O"); cipherAlphabet.put("N", "F"); cipherAlphabet.put("O", "D");
        cipherAlphabet.put("P", "X"); cipherAlphabet.put("Q", "J"); cipherAlphabet.put("R", "K");
        cipherAlphabet.put("S", "R"); cipherAlphabet.put("T", "C"); cipherAlphabet.put("U", "V");
        cipherAlphabet.put("V", "S"); cipherAlphabet.put("W", "T"); cipherAlphabet.put("X", "Z");
        cipherAlphabet.put("Y", "W"); cipherAlphabet.put("Z", "B"); cipherAlphabet.put("U", "Q");

        cipherAlphabet.put("1", "&"); cipherAlphabet.put("2", "\\"); cipherAlphabet.put("3", "%");
        cipherAlphabet.put("4", "^"); cipherAlphabet.put("5", "|"); cipherAlphabet.put("6", "@");
        cipherAlphabet.put("7", "#"); cipherAlphabet.put("8", "$"); cipherAlphabet.put("9", "!");

        cipherAlphabet.put("`", "["); cipherAlphabet.put("~", "/"); cipherAlphabet.put("!", "8");
        cipherAlphabet.put("@", ")"); cipherAlphabet.put("#", "]"); cipherAlphabet.put("$", "2");
        cipherAlphabet.put("%", "-"); cipherAlphabet.put("^", "4"); cipherAlphabet.put("&", ",");
        cipherAlphabet.put("*", "1"); cipherAlphabet.put("(", ">"); cipherAlphabet.put(")", "{");
        cipherAlphabet.put("-", "?"); cipherAlphabet.put("_", "}"); cipherAlphabet.put("+", ":");
        cipherAlphabet.put("=", "6"); cipherAlphabet.put("[", "("); cipherAlphabet.put("]", "=");
        cipherAlphabet.put("|", "9"); cipherAlphabet.put("\\", "0"); cipherAlphabet.put(":", ";");
        cipherAlphabet.put(";", "."); cipherAlphabet.put("\"", "+"); cipherAlphabet.put("'", "5");
        cipherAlphabet.put("?", "3"); cipherAlphabet.put("/", "7"); cipherAlphabet.put(",", "<");
        cipherAlphabet.put(".", "_"); cipherAlphabet.put("<", "'"); cipherAlphabet.put(">", "\"");
    }

    public static Object getKeyFromValue(HashMap cipherAlphabet, String value) {
        for (Object sign : cipherAlphabet.keySet()) {
            if (cipherAlphabet.get(sign).equals(value)) {
                return sign;
            }
        }
        return null;
    }

    public String decipher(String toDecipher) {
        String decipheredWord = "";

        for (int i = 0; i < toDecipher.length(); i++) {
            String letter = Character.toString(toDecipher.charAt(i)).toUpperCase();

            if (cipherAlphabet.containsValue(letter)) {
                decipheredWord += getKeyFromValue(cipherAlphabet, letter);
            } else {
                decipheredWord += letter;
            }
        }
        return decipheredWord;
    }


    public String encipher(String toCipher) {
        String cipheredWord = "";

        for (int i = 0; i < toCipher.length(); i++) {
            String letter = Character.toString(toCipher.charAt(i)).toUpperCase();

            if (cipherAlphabet.containsKey(letter)) {
                cipheredWord += cipherAlphabet.get(letter);
            } else {
                cipheredWord += letter;
            }
        }
        return cipheredWord;
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
