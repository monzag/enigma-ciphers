package enigma;

import app.Module;
import app.View;
import services.EnigmaService;
import registry.ServiceProvider;

import java.util.Scanner;

public class FakeModule implements Module{

	private ServiceProvider provider;

	public void initialize(ServiceProvider provider){
		this.provider = provider;
	}

	public String getName(){
		return "FakeModule";
	}

	public void start(){
		View view = new ConsoleView();
		view.print("Module started!");
		EnigmaService enigma = provider.getByName("FakeEnigma");


		String text = view.input("your secret msg: ");
		view.print(enigma.encipher(text));
		view.print(enigma.decipher("#NCIPH#$#d"));
	}
}
	

