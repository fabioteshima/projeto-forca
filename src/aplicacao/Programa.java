package aplicacao;

import entidades.Jogador;
import entidades.PalavraForca;

import java.io.Console;
import java.util.Scanner;

public class Programa {

    public static void main (String[] args){

        String palavraEntrada;
        Jogador jogador1 = new Jogador(1, true);
        Jogador jogador2 = new Jogador(2, false);

        ConsoleForca.msgBoasVindas();
        ConsoleForca.msgIstrucao();
        ConsoleForca.msgDigitarPalavra();

        Scanner sc = new Scanner(System.in);
        Console cs = System.console();
        if (cs != null) {                       // Para usar no Console (Prompt) ou Scanner (IDE)
            char[] senha = cs.readPassword();
            palavraEntrada = new String(senha);
        } else {
            palavraEntrada = sc.nextLine();
        }

        PalavraForca palavraForca = new PalavraForca(palavraEntrada);
        palavraForca.prepararForca();

        ConsoleForca.msgPalavraRegistrada(palavraForca);
        System.out.println();

        ConsoleForca.mostrarForca(palavraForca);
        ConsoleForca.mostrarPlacar(jogador1, jogador2);
        System.out.println();

        /* Sistema jogo */
        while(!palavraForca.verificarSePalavraCompleta() && jogador1.getTentativas() >= 0 && jogador2.getTentativas() > 0) {
            if(jogador1.getTurno() == true){
                char letra;
                do{
                    ConsoleForca.msgDigitarLetra(jogador1);
                    letra = sc.next().charAt(0);
                    System.out.println();
                    if(palavraForca.verificarLetra(letra)) {
                        ConsoleForca.msgLetraRepetida(letra);
                        System.out.println();
                        ConsoleForca.mostrarForca(palavraForca);
                        ConsoleForca.mostrarPlacar(jogador1, jogador2);
                        System.out.println();
                    }
                }while(palavraForca.verificarLetra(letra));

                if(palavraForca.atualizarForca(letra)){
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
                char letra;
                do{
                    ConsoleForca.msgDigitarLetra(jogador2);
                    letra = sc.next().charAt(0);
                    System.out.println();
                    if(palavraForca.verificarLetra(letra)){
                        ConsoleForca.msgLetraRepetida(letra);
                        System.out.println();
                        ConsoleForca.mostrarForca(palavraForca);
                        ConsoleForca.mostrarPlacar(jogador1, jogador2);
                        System.out.println();
                    }
                } while(palavraForca.verificarLetra(letra));

                if(palavraForca.atualizarForca(letra)){
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
            ConsoleForca.mostrarPlacar(jogador1, jogador2);
            System.out.println();
        }

        /* Verifica vencedor */
        if(palavraForca.verificarSePalavraCompleta() || jogador1.getTentativas() <= 0 || jogador2.getTentativas() <= 0) {
            if(jogador1.getPontos() > jogador2.getPontos()){
                ConsoleForca.msgVitoria(jogador1);
                ConsoleForca.msgPlacarFinal(jogador1, jogador2);
            }
            else if ((jogador1.getPontos() < jogador2.getPontos())){
                ConsoleForca.msgVitoria(jogador2);
                ConsoleForca.msgPlacarFinal(jogador1, jogador2);
            }
            else{
                ConsoleForca.msgEmpate();
                ConsoleForca.msgPlacarFinal(jogador1, jogador2);
            }
        }

        ConsoleForca.msgFimJogo();

        sc.close();

    }
}
