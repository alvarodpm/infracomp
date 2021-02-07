
public class T extends Thread{
	
	private static Identificar objId;
	private static Maximo m;
	private static int[][] mat;
	
	public void run() {
		int locMax = 0;
		int id = objId.darNumId();
		for (int j = 0; j < mat[id].length; j++) {
			if (mat[id][j] > locMax) {
				locMax = mat[id][j];
			}
		}
		if (m.anotar(locMax)) {
			System.out.println("El máximo de la matriz es " + m.darMaximo());
		}
	}
	
	public static void main(String[] args) {
		int n = 10;
		
		mat = new int[n][n];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = j*10;
			}
		}
		
		objId = new Identificar();
		
		m = new Maximo(n);
		
		for (int i = 0; i < n; i++) {
			new T().start();
		}
	}

}
