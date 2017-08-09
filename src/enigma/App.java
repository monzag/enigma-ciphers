package enigma;

import services.EnigmaService;
import app.Module;

public class App {

	public static void main(String... args){

		FakeServiceRepository repo = new FakeServiceRepository();
		repo.register(new FakeEnigma());

		Module module = new FakeModule();
		module.initialize(repo);
		module.start();

	}
}
