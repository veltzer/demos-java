package johnbryce.lab1.exercise.server;

public class RemoteClass {
	static {
		System.out.println("Hi ! I'm loaded !");
	}

	public RemoteClass() {
		aMethod();
	}

	public void aMethod() {
		System.out.println("And I can even work now !");
	}
}
