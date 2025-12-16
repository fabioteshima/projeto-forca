package aplicacao;

import entidades.Jogador;
import entidades.PalavraForca;

import java.io.Console;
import java.util.Scanner;

public class Programa {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        String palavraEntrada;
        Jogador jogador1;
        Jogador jogador2;

        /* Mensagem boas vindas e instrução do jogo */
        ConsoleForca.msgBoasVindas();
        ConsoleForca.msgIstrucao();

        /* Inicio do jogo */
        ConsoleForca.msgDesejaJogar(); // Mensagem se deseja jogar
        char jogar = sc.next().charAt(0);
        sc.nextLine();
        while(jogar == 's' || jogar == 'S'){

            /* Instancia jogadores */
            jogador1 = new Jogador(1, true);
            jogador2 = new Jogador(2, false);
            System.out.println();

            /* Entrada da palavra */
            ConsoleForca.msgDigitarPalavra(); // Mensagem para digitar a palavra
            Console cs = System.console();
            if (cs != null) {                       // Para usar no Console (Prompt) ou Scanner (IDE)
                char[] senha = cs.readPassword();
                palavraEntrada = new String(senha);
            } else {
                palavraEntrada = sc.nextLine();
            }

            /* Instancia palavraForca e prepara a forca */
            PalavraForca palavraForca = new PalavraForca(palavraEntrada);
            palavraForca.prepararForca();
            ConsoleForca.msgPalavraRegistrada(palavraForca);  // Mensagem de palavra registrada
            System.out.println();

            /* Mostra forca e placar */
            ConsoleForca.mostrarForca(palavraForca);
            ConsoleForca.mostrarPlacar(jogador1, jogador2);
            System.out.println();

            /* Sistema do jogo */
            while(!palavraForca.verificarSePalavraCompleta() && jogador1.getTentativas() >= 0 && jogador2.getTentativas() > 0) {

                /* Turno jogador #1 */
                if(jogador1.getTurno() == true){
                    char letra;

                    /* Verifica se a letra já foi descoberta */
                    do{
                        ConsoleForca.msgDigitarLetra(jogador1); // Mensagem para o jogador digitar a letra
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

                    /* Se acertou a letra atualiza a forca e soma pontos, se não não atualiza e tira tentativa do jogador */
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

                /* Turno jogador #2 */
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

                /* Mostra forca e placar a cada jogada */
                ConsoleForca.mostrarForca(palavraForca);
                ConsoleForca.mostrarPlacar(jogador1, jogador2);
                System.out.println();
            }

            /* Verifica vencedor e mosta mensagem de vitória e placar final */
            if(jogador1.getPontos() > jogador2.getPontos()){
                ConsoleForca.msgVitoria(jogador1);
                System.out.println();
                ConsoleForca.msgPlacarFinal(jogador1, jogador2);
            }
            else if ((jogador1.getPontos() < jogador2.getPontos())){
                ConsoleForca.msgVitoria(jogador2);
                System.out.println();
                ConsoleForca.msgPlacarFinal(jogador1, jogador2);
            }
            else{
                 ConsoleForca.msgEmpate();
                 System.out.println();
                 ConsoleForca.msgPlacarFinal(jogador1, jogador2);
            }
            System.out.println();

            /* Se terminar a partida sem completar a palavra, mostra a palavra da forca */
            if (!palavraForca.verificarSePalavraCompleta()) {
                ConsoleForca.mostrarPalavraCompleta(palavraForca); // Mostra mensagem em caso de empate sem a palavra completa
                System.out.println();
            }
            /* Questiona se deseja jogar novamente */
            ConsoleForca.msgDesejaContinuar();
            jogar = sc.next().charAt(0);
            sc.nextLine();
        }

        /* Finaliza o jogo */
        ConsoleForca.msgFimJogo();
        sc.close();
    }
}
