package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        List<String> candidatos = selecaoCandidatos();

        for (String candidato : candidatos)
            System.out.println(candidato);
    }

    public static List<String> selecaoCandidatos() {
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