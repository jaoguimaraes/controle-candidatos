package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (String candidado : candidatos) {
            entrandoEmContato(candidado);
        }
    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do {
            atendeu=atender();
            continuarTentando= !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso.");

        } while(continuarTentando && tentativasRealizadas<3);

        if (atendeu)
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        else
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo excedido, " + tentativasRealizadas + " tentativas realizadas");
    }

    //Método atender
        static boolean atender() {
            return new Random().nextInt(3)==1;
        }
    static void imprimirSelecionados() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULS", "AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for(int indice=0; indice < candidatos.length;indice++) {
            System.out.println("O candidato de número " + (indice+1) + " é o " + candidatos[indice]);
        }
        System.out.println("Forma abreviada de interação é o for each");
        for (String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }
    static void selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int canditadosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (canditadosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O Candidato " + candidato + " foi selecionado para a vaga");
                canditadosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");

        } else if (salarioBase == salarioPretendido)
            System.out.println("Ligar para o candidato com contra proposta");
        else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}