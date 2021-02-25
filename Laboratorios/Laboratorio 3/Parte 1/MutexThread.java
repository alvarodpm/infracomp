public class MutexThread extends Thread {
    
    private final String tipo;
    public static Mutex mutex;
    
    public MutexThread(String tipo) {
        this.tipo = tipo;
    }
    
    private void esperaAleatoria() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        if (this.tipo.equals("A")) {
            for (int i = 0; i < 1000; i++) {
                MutexThread.mutex.a();
                this.esperaAleatoria();
            }
        }
        else if (this.tipo.equals("B")){
            for (int i = 0; i < 1000; i++) {
                MutexThread.mutex.b();
                this.esperaAleatoria();
            }
        }
    }
    
}
