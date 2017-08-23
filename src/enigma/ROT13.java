package enigma;

import services.EnigmaService;

public class ROT13 {

    public String encipher(String text) {
        String encipher_text = "";

        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);
            if ((sign >= 'a' && sign <= 'm') || (sign >= 'A' && sign <= 'M')) {
                sign += 13;
            } else if ((sign >= 'm' && sign <= 'z') || (sign >= 'M' && sign <= 'Z')) {
                sign -= 13;
            }
            encipher_text += sign;
        }
        return encipher_text;
    }

    public String decipher(String text) {
        String decipher_text = encipher(text);
        return decipher_text;
    }
}