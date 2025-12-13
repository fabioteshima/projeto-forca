package aplicacao;

import entidades.Jogador;
import entidades.PalavraForca;

import java.util.Scanner;

public class Programa {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        Jogador jogador = new Jogador();
        String palavraEntrada;

        ConsoleForca.msgBoasVindas();

        System.out.print("Digite uma palavra: ");
        palavraEntrada = sc.nextLine();
        PalavraForca palavraForca = new PalavraForca(palavraEntrada);

        palavraForca.prepararForca();
        ConsoleForca.mostrarForca(palavraForca);
        ConsoleForca.mostrarStatusJogador(jogador);

        while(!palavraForca.verificarSePalavraCompleta()) {
            System.out.print("Digite uma letra: ");
            char letra = sc.next().charAt(0);
            if(palavraForca.atualizarForca(letra) == true){
                jogador.somaPontos();
                ConsoleForca.msgAcertou(letra);
            }
            else{
                jogador.diminuiTentativas();
                ConsoleForca.msgNaoAcertou(letra);
            }

            ConsoleForca.mostrarForca(palavraForca); // mostra as letras e suas posições pela inteface
            ConsoleForca.mostrarStatusJogador(jogador);
        }

        ConsoleForca.msgFimJogo();

        sc.close();

    }
}
