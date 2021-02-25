public class Signaling {
    
    private int variable;
    private final Semaforo semaforo;
    
    public Signaling() {
        this.variable = 0;
        this.semaforo = new Semaforo(0);
    }
    
    public void a() {
        System.out.println("A: Voy a modificar la variable");
        this.variable += 1000;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A: Modifiqué la variable");
        this.semaforo.v();
    }
    
    public void b() {
        this.semaforo.p();
        System.out.println("B: Voy a modificar la variable");
        this.variable += 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B: Modifiqué la variable");
        this.semaforo.v();
    }
    
}
