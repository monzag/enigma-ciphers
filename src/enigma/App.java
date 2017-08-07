package enigma;

import services.EnigmaService;

public class App {

	public static void main(String... args){

		EnigmaService enigma = new FakeEnigma();

		System.out.println(enigma.encipher("Text"));
		System.out.println(enigma.decipher("#NCIPH#$#d"));

	}
}
