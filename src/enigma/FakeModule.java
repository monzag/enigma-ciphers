package enigma;

import app.AppModule;
import services.EnigmaService;
import registry.ServiceProvider;

import java.util.Scanner;

public class FakeModule implements AppModule{

	private ServiceProvider provider;

	public void initialize(ServiceProvider provider){
		this.provider = provider;
	}

	public String getName(){
		return "FakeModule";
	}

	public void start(){
		System.out.println("Module started!");
		EnigmaService enigma = provider.getByName("FakeEnigma");

		Scanner in = new Scanner(System.in);

		String text = in.next();
	        System.out.println(enigma.encipher(text));
                System.out.println(enigma.decipher("#NCIPH#$#d"));
	}
}
	

