package aplicacao;

import entidades.Jogador;
import entidades.PalavraForca;

public class ConsoleForca {

    public static void msgBoasVindas(){
        System.out.println();
        System.out.println("BEM VINDO AO JOGO DA FORCA!");
        System.out.println();
    }

    public static void msgFimJogo(){
       System.out.println("\nO JOGO TERMINOU! THANKS FOR PLAYING!");
    }

    public static void msgIstrucao(){
        System.out.println("INSTRUÇÃO:");
        System.out.println("CADA JOGADOR (1 e 2) TERÁ 6 TENTATIVAS DE ACERTO. VENCE AQUELE QUE POSSUIR MAIOR PONTUAÇÃO FINAL  ");
        System.out.println("QUANDO A PALAVRA FOR DESCOBERTA OU CASO ACABEM OS NÚMEROS DE TENTATIVAS.\n");
    }

    public static void msgDesejaJogar (){
        System.out.print("Deseja jogar (s/n)?: ");
    }

    public static void msgDesejaContinuar (){
        System.out.print("Deseja jogar novamente (s/n)?: ");
    }

    public static void msgDigitarPalavra(){
        System.out.print("Digite uma palavra para o jogo: ");
    }

    public static void msgPalavraRegistrada(PalavraForca palavraForca){
        System.out.println("Palavra de " + palavraForca.getListaLetras().size() + " letras registrada!" );
    }

    public static void msgDigitarLetra(Jogador jogador){
        System.out.print("Digite uma letra JOGADOR #" + jogador.getNumeroJogador() + ": ");
    }

    public static void msgLetraRepetida(char letra){
        System.out.println("OPS! A LETRA \""+ letra + "\" JÁ FOI DESCOBERTA!");
    }

    public static void msgAcertou(char letra){
        System.out.println("PARABÉNS! VOCÊ ACERTOU A LETRA \"" + letra + "\"");
    }

    public static void msgNaoAcertou(char letra){
        System.out.println("AH, QUE PENA! VOCÊ NÃO ACERTOU. A PALAVRA NÃO TEM A LETRA \"" + letra + "\"");
    }

    public static void msgVitoria(Jogador jogador){
        System.out.println("PARABÉNS, JOGADOR #" + jogador.getNumeroJogador() + "! VOCE GANHOU O JOGO!");
    }

    public static void msgEmpate (){
        System.out.println("QUE DISPUTA! DEU EMPATE!");
    }

    public static void msgPlacarFinal(Jogador jogador1, Jogador jogador2){
        System.out.println("PLACAR FINAL: ");
        mostrarPlacar(jogador1, jogador2);
    }

   public static void mostrarForca(PalavraForca palavraForca){
        System.out.print("FORCA: ");
        for(char c : palavraForca.getLetrasDescobertas()){
            System.out.print(c + " ");
        }
        System.out.println();
        }

    public static void mostrarPlacar(Jogador jogador1, Jogador jogador2){
        System.out.printf("JOGADOR #%d : %d ponto(s) / Tentativas restantes %d \n",
                            jogador1.getNumeroJogador(), jogador1.getPontos(), jogador1.getTentativas());
        System.out.printf("JOGADOR #%d : %d ponto(s) / Tentativas restantes %d \n",
                            jogador2.getNumeroJogador(), jogador2.getPontos(), jogador2.getTentativas());
    }
}

