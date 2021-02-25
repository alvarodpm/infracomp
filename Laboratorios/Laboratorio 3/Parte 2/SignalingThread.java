public class SignalingThread extends Thread {
    
    private final String tipo;
    public static Signaling signaling;
    
    public SignalingThread(String tipo) {
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
            SignalingThread.signaling.a();
            this.esperaAleatoria();
        }
        else if (this.tipo.equals("B")) {
            SignalingThread.signaling.b();
            this.esperaAleatoria();
        }
    }
    
}
