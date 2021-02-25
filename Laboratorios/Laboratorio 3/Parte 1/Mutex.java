public class Mutex {
    
    private int variable;
    private final Semaforo semaforo;
    
    public Mutex() {
        this.variable = 0;
        this.semaforo = new Semaforo(1);
    }
    
    public void a() {
        this.semaforo.P();
        System.out.println("A: Voy a modificar la variable");
        this.variable += 1000;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A: Modifiqué la variable");
        this.semaforo.V();
    }
    
    public void b() {
        this.semaforo.P();
        System.out.println("B: Voy a modificar la variable");
        this.variable += 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B: Modifiqué la variable");
        this.semaforo.V();
    }
    
}
