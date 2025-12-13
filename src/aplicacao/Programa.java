package aplicacao;

import entidades.Jogador;
import entidades.PalavraForca;

import java.util.Scanner;

public class Programa {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        String palavraEntrada;
        Jogador jogador1 = new Jogador(1,true);
        Jogador jogador2 = new Jogador(2,false);

        ConsoleForca.msgBoasVindas();
        ConsoleForca.msgIstrucao();

        System.out.print("Digite uma palavra para o jogo: ");
        palavraEntrada = sc.nextLine();
        PalavraForca palavraForca = new PalavraForca(palavraEntrada);
        palavraForca.prepararForca();

        System.out.println("Palavra de " + palavraForca.getListaLetras().size() + " letras registrada!\n");
        ConsoleForca.mostrarForca(palavraForca);
        ConsoleForca.mostrarStatusJogador(jogador1);
        ConsoleForca.mostrarStatusJogador(jogador2);
        System.out.println();

        while(!palavraForca.verificarSePalavraCompleta() && jogador1.getTentativas() > 0 && jogador2.getTentativas() > 0) {
            if(jogador1.getTurno() == true){
                System.out.print("Digite uma letra JOGADOR #" + jogador1.getNumeroJogador() + ": ");
                char letra = sc.next().charAt(0);
                System.out.println();
                if(palavraForca.atualizarForca(letra) == true){
                    jogador1.somaPontos();
                    ConsoleForca.msgAcertou(letra);
                    System.out.println();
                }
                else{
                    jogador1.diminuiTentativas();
                    ConsoleForca.msgNaoAcertou(letra);
                    jogador1.setTurno(false);
                    jogador2.setTurno(true);
                    System.out.println();
                }
            }
            else if (jogador2.getTurno() == true){
                System.out.print("Digite uma letra JOGADOR #" + jogador2.getNumeroJogador() + ": ");
                char letra = sc.next().charAt(0);
                System.out.println();
                if(palavraForca.atualizarForca(letra) == true){
                    jogador2.somaPontos();
                    ConsoleForca.msgAcertou(letra);
                    System.out.println();
                }
                else{
                    jogador2.diminuiTentativas();
                    ConsoleForca.msgNaoAcertou(letra);
                    jogador2.setTurno(false);
                    jogador1.setTurno(true);
                    System.out.println();
                }
            }

            ConsoleForca.mostrarForca(palavraForca);
            ConsoleForca.mostrarStatusJogador(jogador1);
            ConsoleForca.mostrarStatusJogador(jogador2);
            System.out.println();
        }

        if(palavraForca.verificarSePalavraCompleta()){ // Termina o jogo se a palavra foi completada
            if(jogador1.getPontos() > jogador2.getPontos()){
                ConsoleForca.msgVenceu(jogador1);
            }
            else if ((jogador1.getPontos() < jogador2.getPontos())){
                ConsoleForca.msgVenceu(jogador2);
            }
            else{
                ConsoleForca.msgEmpate();
            }
        }
        else if (jogador1.getTentativas() <= 0 || jogador2.getTentativas() <= 0) { // Termina se acabaram as tentativas
            if (jogador1.getPontos() > jogador2.getPontos()) {
                ConsoleForca.msgVenceu(jogador1);
            } else if ((jogador1.getPontos() < jogador2.getPontos())) {
                ConsoleForca.msgVenceu(jogador2);
            } else {
                ConsoleForca.msgEmpate();

            }
        }

        ConsoleForca.msgFimJogo();

        sc.close();

    }
}
