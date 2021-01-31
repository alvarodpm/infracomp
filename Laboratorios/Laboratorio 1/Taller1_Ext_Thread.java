import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Taller1_Ext_Thread extends Thread{
	
	public static int MAX = 0;
	
	private int num;
	
	public Taller1_Ext_Thread(int num) {
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
			Taller1_Ext_Thread.MAX = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
     
		
		Taller1_Ext_Thread t1 = new Taller1_Ext_Thread(1);
		Taller1_Ext_Thread t2 = new Taller1_Ext_Thread(2);
		
		t1.start();
		t2.start();
			
	}
}
