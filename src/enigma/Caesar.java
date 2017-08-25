package enigma;

import services.EnigmaService;

public class Caesar implements EnigmaService {

    public String key;

    public Caesar() {
        this.key = null;
    }

    public String encipher(String text) {
        String enciphered = "";

        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);

            sign += 1;

            enciphered += sign;
        }
        return enciphered;
    }

    public String decipher(String text) {
        String deciphered =  "";

        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);

            sign -= 1;

            deciphered += sign;
        }
        return deciphered;
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
