package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        List<String> candidatos = selecaoCandidatos();

        System.out.println("  -- Candidatos selecionados:");
        for (String candidato : candidatos)
            System.out.println("  -- " + candidato);

        for (String candidato : candidatos)
            entrarEmContatoComCandidatos(candidato);
    }

    // Método para simular o RH entrando em contato com os candidatos
    static void entrarEmContatoComCandidatos(String candidato) {

        int tentativasRealizdas = 3;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando)
                tentativasRealizdas++;
            else
                System.out.println("Contato realizado com o candidato " + candidato);
        } while (continuarTentando && tentativasRealizdas < 3);

        if (atendeu)
            System.out.println("Contato realizado com o candidato " + candidato + " na tentativa de numero " + tentativasRealizdas);
        else
            System.out.println("Não foi possível contato com o candidato " + candidato);
    }

    // Método para simular o candidato atendendo o telefonema do RH
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    public static List<String> selecaoCandidatos() {
        System.out.println("Fase de seleção de candidatos:");
        String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Paula", "Marcos", "Daniel", "Daniela"};
        int candidatosSelecionados = 0;
        List<String> candidatosSelecionadosLista = new ArrayList<>();
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " propos o valor de " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionadosLista.add(candidato);
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }

        return candidatosSelecionadosLista;

    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}