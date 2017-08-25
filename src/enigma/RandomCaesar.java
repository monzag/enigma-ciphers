package enigma;

import services.EnigmaService;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCaesar implements EnigmaService {

    public String key;

    public RandomCaesar() {
        this.key = key;
    }

    public String encipher(String text) {
        String enciphered = "";
        int min = -20;
        int max = 20;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max);

        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);

            sign += randomNum;

            enciphered += sign;
        }
        String key_str = Integer.toString(randomNum);
        enciphered += " ----> and your key for decipher is: " + key_str;

        return enciphered;
    }

    public String decipher(String text) {
        String deciphered =  "";

        int key_int = Integer.parseInt(key);

        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);

            sign -= key_int;

            deciphered += sign;
        }
        return deciphered;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public boolean isKeyRequired() {
        return true;
    }

    public void setKey(String key) {
        if (isKeyRequired() == true) {
            this.key = key;
        }
    }

}
