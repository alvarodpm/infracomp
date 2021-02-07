
public class Main {

	public static void main(String[] args) {
		Persona.pasarela = new Pasarela();
		
		for (int i = 0; i < 6000; i++) {
			new Persona(i%2).start();
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
