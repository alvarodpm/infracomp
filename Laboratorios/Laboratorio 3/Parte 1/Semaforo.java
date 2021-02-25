public class Semaforo {
    
    private int contador;
    
    public Semaforo(int contador) {
        this.contador = contador;
    }
    
    public synchronized void P() {
        this.contador--;
        if (this.contador < 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public synchronized void V() {
        this.contador++;
        if (this.contador <= 0) {
            this.notify();
        }
    }
}
