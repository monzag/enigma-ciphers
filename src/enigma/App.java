package enigma;

import services.EnigmaService;
import app.AppModule;

public class App {

	public static void main(String... args){

		FakeServiceRepository repo = new FakeServiceRepository();
		repo.register(new FakeEnigma());

		AppModule module = new FakeModule();
		module.initialize(repo);
		module.start();

	}
}
