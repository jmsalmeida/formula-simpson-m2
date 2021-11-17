public class App {
	static Double calcularValorH(int a, int b, int n) {
		Double h = ((double) b - (double) a) / (double) n;
		return h;
	}
	
	static int[] montaColunaIndice(int n) {
		int[] indices = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			indices[i] = i;
		}
		
		return indices;
	}
	
	static Double[] montaColunaX(int a, int b, Double h, int limite) {
		Double[] valoresX = new Double[limite];
		
		for (int i = 0; i < limite; i++) {
			if (i == 0) {
				valoresX[i] = (double) a;
			} else {
				// Gambiarra pra exibir duas casas decimais "Wtafucking fuck?"
				valoresX[i] = Math.round((valoresX[i-1] + h) * 100.0)/100.0;
			}
		}

		return valoresX;
	}
	
	public static void main(String[] args) throws Exception {
		int n = 20;
		int a = 1;
		int b = 3;
		
		Double h = calcularValorH(a, b, n);
		int[] indices = montaColunaIndice(n);
		Double[] colunaX = montaColunaX(a, b, h, indices.length);

		for (int i = 0; i < colunaX.length; i++) {
			System.out.println(colunaX[i]);
		}
	}
}
