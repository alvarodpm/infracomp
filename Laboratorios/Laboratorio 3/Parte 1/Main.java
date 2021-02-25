public class Main {
    
    public static void main(String[] args) {
        
        MutexThread.mutex = new Mutex();
        MutexThread a = new MutexThread("A");
        MutexThread b = new MutexThread("B");
        
        int orden = (int) (Math.random() * 100) % 2;
        if (orden == 0) {
            System.out.println("Inicia a");
            a.start();
            b.start();
        }
        else {
            System.out.println("Inicia b");
            b.start();
            a.start();
        }
    }
    
}
