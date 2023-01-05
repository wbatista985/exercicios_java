package br.com.bubbleSort;

public class VotacaoEleicao {

	public static void main(String[] args) {

		int totalDeEleitores = 1000;
		int votosValidos = 800;
		int votosBrancos = 150;
		int votosNulos = 50;

		percentualVotosValidosEmRelacaoTotalEleitores(totalDeEleitores, votosValidos);
		percentualVotosBrancosEmRelacaoTotalEleitores(totalDeEleitores, votosBrancos);
		percentualVotosNulosEmRelacaoTotalEleitores(totalDeEleitores, votosNulos);

	}

	private static void percentualVotosValidosEmRelacaoTotalEleitores(int totalDeEleitores, int votosValidos) {

		float porcentagem = (votosValidos * 100 / totalDeEleitores);
		System.out.println("A porcentagem de Votos Válidos é = " + porcentagem + " %");
	}

	private static void percentualVotosBrancosEmRelacaoTotalEleitores(int totalDeEleitores, int votosBrancos) {
		float porcentagem = (votosBrancos * 100 / totalDeEleitores);
		System.out.println("A porcentagem de Votos Válidos é = " + porcentagem + " %");

	}

	public static void percentualVotosNulosEmRelacaoTotalEleitores(int totalDeEleitores, int votosNulos) {

		float porcentagem = (votosNulos * 100 / totalDeEleitores);
		System.out.println("A porcentagem é Votos Nulos é = " + porcentagem + " %");
	}

}
