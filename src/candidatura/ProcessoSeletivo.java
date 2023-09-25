package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatosSelecionados = selecaoCandidatos();
        imprimirCandidatosSelecionados(candidatosSelecionados);
        ligarParaCandidatosSelecionados(candidatosSelecionados);
    }

    static void imprimirCandidatosSelecionados(String[] candidatosSelecionados) {
        if(candidatosSelecionados == null)
            System.out.println("\nNenhum candidato foi selecionado");
        else{
        System.out.println("\nOs candidatos foram selecionados!\nSegue lista:\n");
        for (String candidato : candidatosSelecionados){
            if(candidato != null)
                System.out.println(candidato + " foi selecionado!");
         }
        }
    }

    static String[] selecaoCandidatos() {

        String[] candidatos = {"Andre", "Ana", "Edesio", "Jhonathan", "Karol", "Evellyn", "Moises", "Yan", "Gabriel", "Vitao", "Rodrigo"};
        String[] candidatosSelecionados = new String[5];

        double salarioBase = 2000;
        int quantidadeCandidatosSelecionados = 0;

        for (String candidato : candidatos) {
            if (quantidadeCandidatosSelecionados == 5)
                break;
            double salarioPretendidoPorCandidato = valorPretendido();
            if (selecionarCandidato(candidato, salarioBase, salarioPretendidoPorCandidato)) {
                candidatosSelecionados[quantidadeCandidatosSelecionados] = candidato;
                quantidadeCandidatosSelecionados++;
            }
        }
        return candidatosSelecionados;
    }

    static double valorPretendido() {
        return Math.round(ThreadLocalRandom.current().nextDouble(1800, 2200) * 100.00) / 100.00;
    }

    static boolean selecionarCandidato(String candidato, double salarioBase, double salarioPretendido) {
        System.out.println("\n" + candidato + " solicitou o salario de R$ " + salarioPretendido);
        if (salarioBase < salarioPretendido) {
            System.out.println("-> Aguardando o resultado dos demais candidatos");
            return false;
        } else if (salarioBase > salarioPretendido)
            System.out.println("-> Ligar para candidato");
        else if (salarioBase == salarioPretendido)
            System.out.println("-> Ligar para candidato com contra proposta");
        return true;
    }

    static void ligarParaCandidatosSelecionados(String[] candidatosSelecionados) {
        for (String candidato : candidatosSelecionados) {
            if(candidato != null){
            System.out.println();
            boolean atendeu = false;
            for (int i = 0; i < 3; i++) {
                System.out.println("Ligando para " + candidato + "...");
                atendeu = ThreadLocalRandom.current().nextBoolean();
                System.out.println("Atendeu? " + (atendeu ? " Sim" : "Não"));
                if (atendeu) {
                    System.out.println(candidato + " atendeu na " + (i+1) + " tentativa");
                    break;
                }
                if(i==2)
                    System.out.println(candidato + " não atendeu nenhuma ligacao");
                }
            }
        }
    }
}