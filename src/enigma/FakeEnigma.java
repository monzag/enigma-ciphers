package enigma;

import services.EnigmaService;

public class FakeEnigma implements EnigmaService {

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

	public void initialize(){
	}


}
