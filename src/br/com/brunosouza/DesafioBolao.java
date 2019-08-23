package br.com.brunosouza;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class DesafioBolao implements Bolao {

	public static void main(String[] args) {
		DesafioBolao desafio = new DesafioBolao();

		Placar oficial = desafio.obterPlacarOficial();
		Placar aposta = desafio.lancarPalpites();

		desafio.obterDetalhesPontuacao(oficial, aposta);

	}

	private Placar obterPlacarOficial() {

		Random random = new Random();

		int resultadoOficialTime1 = random.nextInt(5) + 0;
		int resultadoOficialTime2 = random.nextInt(5) + 0;

		Placar oficial = new Placar(resultadoOficialTime1, resultadoOficialTime2);
		return oficial;
	}

	private Placar lancarPalpites() {

		int time1 = 0, time2 = 0;
		Placar placar = null;

		System.out.println("##### Bolao da Empresa #####\n");

		try (Scanner entrada = new Scanner(System.in)) {
			try {
				System.out.println("Digite o placar do time1: ");
				time1 = entrada.nextInt();

				System.out.println("Digite o placar do time2: ");
				time2 = entrada.nextInt();

				placar = new Placar(time1, time2);

				System.out.println("A sua aposta foi: ");
				System.out.println("Time1 : " + time1);
				System.out.println("Time2 : " + time2);

			} catch (InputMismatchException e) {
				System.out.println("Agradecemos por participar do nosso bolao...");
			}
		}
		return placar;
	}

	private void obterDetalhesPontuacao(Placar oficial, Placar aposta) {
		System.out.println("O Placar oficial foi: Time1: " + oficial.getTime1());
		System.out.println("O Placar oficial foi: Time2: " + oficial.getTime2());
		System.out.println("Sua pontuacao foi: " + calcularPontuacao(aposta, oficial));
	}

	@Override
	public int calcularPontuacao(Placar aposta, Placar oficial) {
		int pontos = 0;
		if ((aposta).equals(oficial)) {
			return pontos + 20;
		}

		if (aposta.obterVencedor() == oficial.obterVencedor() || oficial.obterVencedor() == 0) {
			pontos = 10;
		}

		if (aposta.getTime1() == oficial.getTime1() || aposta.getTime2() == oficial.getTime2()) {
			pontos = pontos + 5;
		}

		return pontos;
	}
}
