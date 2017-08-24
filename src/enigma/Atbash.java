package enigma;

import services.EnigmaService;
import java.lang.StringBuffer;

public class Atbash implements EnigmaService {

    public String key;

    public Atbash(){
        this.key = null;
    }

    public String decipher(String toCipher){
        StringBuffer deciphered = new StringBuffer();
        for(char c: toCipher.toCharArray()){
            if (Character.isLetter(c)){
                if (c >= 'A' && c <= 'Z'){
                    int newChar = ('Z' - c) + 'A';
                    deciphered.append((char) newChar);
                } else if (c >= 'a' && c <= 'z'){
                    int newChar = ('z' - c) + 'a';
                    deciphered.append((char) newChar);
                }
            } else {
                deciphered.append(c);
            }
        }
        return deciphered;
    }
    

    public String encipher(String toCipher) {
        String enciphered = decipher(toCipher);
        return enciphered;
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
