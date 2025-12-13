package aplicacao;

import entidades.Jogador;
import entidades.PalavraForca;

import java.util.Scanner;

public class Programa {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        String palavraEntrada;
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();

        ConsoleForca.msgBoasVindas();
        ConsoleForca.msgIstrucao();

        System.out.print("Digite uma palavra para o jogo: ");
        palavraEntrada = sc.nextLine();
        PalavraForca palavraForca = new PalavraForca(palavraEntrada);

        palavraForca.prepararForca();
        ConsoleForca.mostrarForca(palavraForca);
        ConsoleForca.mostrarStatusJogador(jogador1);

        while(!palavraForca.verificarSePalavraCompleta() && jogador1.getTentativas() > 0) {
            System.out.print("Digite uma letra: ");
            char letra = sc.next().charAt(0);
            if(palavraForca.atualizarForca(letra) == true){
                jogador1.somaPontos();
                ConsoleForca.msgAcertou(letra);
            }
            else{
                jogador1.diminuiTentativas();
                ConsoleForca.msgNaoAcertou(letra);
            }

            ConsoleForca.mostrarForca(palavraForca); // mostra as letras e suas posições pela inteface
            ConsoleForca.mostrarStatusJogador(jogador1);
        }

        if(palavraForca.verificarSePalavraCompleta()){
            ConsoleForca.msgVenceu(jogador1);
        }
        else if (jogador1.getTentativas()<=0){
            ConsoleForca.msgPerdeu();
        }

        ConsoleForca.msgFimJogo();

        sc.close();

    }
}
