package enigma;

import services.EnigmaService;

public class ROT13 implements EnigmaService {

    public static int[] getAscii() {
        int ascii_amount = 256;
        int[] values = new int[ascii_amount];

        for (int i = 0; i < ascii_amount; i++) {
            char temp = i;
            values[i] = temp;
        
        return values;
        }
    }
}