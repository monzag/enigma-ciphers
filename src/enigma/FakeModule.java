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



		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			view.print(enigma.encipher(scan.nextLine()));
		}
	}
}
	

