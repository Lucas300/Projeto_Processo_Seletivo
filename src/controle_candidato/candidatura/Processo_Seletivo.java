package controle_candidato.candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Processo_Seletivo {
	public static void main(String[] args) {
		String[] candidatos = { "Lucas", "Marta", "Julia", "Paulo", "Augusto" };
		for (String candidato : candidatos) {			
			entrandoEmContato(candidato);
		}
	}

	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando) {
				tentativasRealizadas++;				
			}else {
				System.out.println("Contato realizado com sucesso");
			}
		}while(continuarTentando == true && tentativasRealizadas < 3);
		if (atendeu) {
			System.out.println("Conseguimos contato com "+ candidato + " na "+tentativasRealizadas + " Tentativa");
		}else {
			System.out.println("Não conseguimos contato com "+ candidato + " numero maximo de tentativas "+tentativasRealizadas );			
		}
	}
	
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}

	static void imprimirSelecionados() {
		String[] candidatos = { "Lucas", "Marta", "Julia", "Paulo", "Augusto" };
		System.out.println("Imprimindo a lista de candidatos, informando o indice do elemento");
		for (int i = 0; i < candidatos.length; i++) {
			System.out.println("O candidato de nº " + (i + 1) + " é o " + candidatos[i]);
		}

	}

	static void selecaoCandidatos() {
		String[] candidatos = { "Lucas", "Marta", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Daniela",
				"Jorge" };
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();

			System.out.println("O candidato " + candidato + " Solicitou este valor de salario " + salarioPretendido);
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " Foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}

	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}

	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if (salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
		} else if (salarioBase == salarioPretendido) {
			System.out.println("Ligar para o candidato com contra proposta");
		} else {
			System.out.println("Aguardando o Resultado dos demais candidatos");
		}
	}
}
