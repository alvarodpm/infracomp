
public class Pasarela {
	
	private int cantIzquierdaDerecha;
	private int cantDerechaIzquierda;
	
	public Pasarela() {
		this.cantDerechaIzquierda = 0;
		this.cantIzquierdaDerecha = 0;
	}
	
	
	//0 = izqquierda a derecha
	//1 = derecha a izquierda
	public synchronized void entrar(int direccion) {
		if(direccion == 0) {
			while (cantDerechaIzquierda != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Hubo un error en el wait()");
					e.printStackTrace();
				}
			}
			System.out.println("Entró un 0");
			this.cantIzquierdaDerecha++;
		}
		else if(direccion == 1) {
			while (cantIzquierdaDerecha != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Hubo un error en el wait()");
					e.printStackTrace();
				}
			}
			System.out.println("Entró un 1");
			this.cantDerechaIzquierda++;
		}
	}
	
	public void caminar() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Hubo un error en el sleep()");
			e.printStackTrace();
		}
	}
	
	
	//0 = izqquierda a derecha
	//1 = derecha a izquierda
	public synchronized void salir(int direccion) {
		if(direccion == 0) {
			System.out.println("Salió un 0");
			this.cantIzquierdaDerecha--;
		}
		else if(direccion == 1) {
			System.out.println("Salió un 1");
			this.cantDerechaIzquierda++;
		}
		
		notifyAll();
	}

}
