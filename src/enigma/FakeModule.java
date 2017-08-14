package enigma;

import app.Module;
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
		EnigmaService enigma = provider.getByName("FakeEnigma");


		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			System.out.println(enigma.encipher(scan.nextLine()));
		}
	}
}
