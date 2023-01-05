package br.com.bubbleSort;

public class SomaDeMultiplos {

	public static void main(String[] args) {

	    int N = 10;
	    int result = sum(3, N-1) + sum(5, N-1) - sum(15, N-1);

	    System.out.println("A soma de todos os múltiplos de 3 ou 5 , será: " + result);
	  }

	  public static int sum(int n, int N) {
	      return n * (N/n) * (N/n + 1)/2;
	  }

}
