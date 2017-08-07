package enigma;

import services.EnigmaService;

public class FakeEnigma implements EnigmaService {

	public static final boolean KEY_REQUIRED = false;

	public FakeEnigma(){
	}

	public String encipher(String text){
		return "###### ciphered: "+text+" #####";
	}

	public String decipher(String text){
		return "###### deciphered: "+text+" #####";
	}

	public String getName(){
		return "FakeEnigma";
	}

	public boolean isKeyRequired(){
		return KEY_REQUIRED;
	}

	public void setKey(String key) {}


}
