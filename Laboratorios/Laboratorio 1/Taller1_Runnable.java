import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Taller1_Runnable implements Runnable{
	
	public static int MAX = 0;
	
	private int num;
	
	public Taller1_Runnable(int num) {
		this.num = num;
	}
	
	public void run() {
		while(this.num <= MAX) {
			System.out.println(this.num);
			num+=2;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in));
		
		try {
			Taller1_Runnable.MAX = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
     
		
		Thread t1 = new Thread(new Taller1_Runnable(1));
		Thread t2 = new Thread(new Taller1_Runnable(2));
		
		t1.start();
		t2.start();
			
	}
}