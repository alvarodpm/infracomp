
public class Persona extends Thread{
	
	//0 = izqquierda a derecha
	//1 = derecha a izquierda
	private int direccion;
	
	public static Pasarela pasarela;
	
	public Persona(int direccion) {
		this.direccion = direccion;
	}
	
	public void run() {
		pasarela.entrar(this.direccion);
		pasarela.caminar();
		pasarela.salir(this.direccion);
	}
	
	
	
	
}
