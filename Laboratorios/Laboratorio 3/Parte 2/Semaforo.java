import java.util.LinkedList;

public class Semaforo {
    private int contador;
    private final LinkedList<Object> colaEspera;
    
    public Semaforo(int contador) {
        this.contador = contador;
        this.colaEspera = new LinkedList<>();
    }
    
    // Solicitar turno
    public void p() {
        contador--;
        while (contador < 0) {
            try {
                Object o = new Object();
                colaEspera.add(o);
                synchronized (o) {
                    System.out.println("hi" + colaEspera.size());
                    o.wait();
                }
            } catch (InterruptedException e) {
            }
        }
    }
    
    // Liberar turno
    public void v() {
        contador++;
        //Vuelve a haber recurso y había alguien en espera
        if (contador <= 0) {
            Object o = colaEspera.poll();
            synchronized (o) {
                o.notifyAll();
            }
        }
    }
}

