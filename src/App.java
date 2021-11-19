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

  static Double calculaEquacao(Double x) {
    // 3x² + 5x - 4
    Double equacao = 3 * Math.pow(x, 2) + 5 * x - 4;
    return Math.round(equacao * 100.0)/100.0;
  }

  static Double[] montaColunaEquacoes(Double[] valoresX, int limite) {
    Double[] equacoes = new Double[limite];
    Double x;

    for (int i = 0; i < valoresX.length; i++) {
      x = valoresX[i];
      equacoes[i] = calculaEquacao(x);
    }

    return equacoes;
  }

  static Double[] montaColunaPares(Double[] equacoes, int limite) {
    Double[] pares = new Double[limite];
    pares[0] = null;
    pares[limite - 1] = null;

    for (int i = 1; i < equacoes.length -1; i++) {
      if (i % 2 == 0) {
        pares[i] = equacoes[i];
      } else {
        pares[i] = null;
      }
    }

    return pares;
  }

  static Double[] montaColunaImpares(Double[] equacoes, int limite) {
    Double[] impares = new Double[limite];
    impares[0] = null;
    impares[limite - 1] = null;

    for (int i = 1; i < equacoes.length -1; i++) {
      if (i % 2 != 0) {
        impares[i] = equacoes[i];
      } else {
        impares[i] = null;
      }
    }

    return impares;
  }

  public static void main(String[] args) throws Exception {
    int n = 20;
    int a = 1;
    int b = 3;

    Double h = calcularValorH(a, b, n);
    int[] indices = montaColunaIndice(n);
    int limite = indices.length;
    Double[] valoresX = montaColunaX(a, b, h, limite);
    Double[] equacoes = montaColunaEquacoes(valoresX, limite);
    Double[] pares = montaColunaPares(equacoes, limite);
    Double[] impares = montaColunaImpares(equacoes, limite);

    for (Double double1 : impares) {
      System.out.println(double1);
    }
  }
}
