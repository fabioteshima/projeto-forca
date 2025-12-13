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
       System.out.println("\nO JOGO TERMINOU! THANK YOU FOR PLAYING!");
    }

    public static void msgIstrucao(){
        System.out.println("INSTRUÇÃO:");
        System.out.println("CADA JOGADOR (1 e 2) TERÁ 6 TENTATIVAS DE ACERTO. VENCE AQUELE QUE POSSUIR MAIOR PONTUAÇÃO FINAL  ");
        System.out.println("QUANDO A PALAVRA FOR DESCOBERTA OU CASO SEU ADVERSÁRIO ACABE COM SEUS NÚMEROS DE TENTATIVAS.\n");
    }

    public static void msgAcertou(char letra){
        System.out.println("PARABÉNS! VOCÊ ACERTOU A LETRA " + letra);
    }

    public static void msgNaoAcertou(char letra){
        System.out.println("AH, QUE PENA! VOCÊ NÃO ACERTOU. A PALAVRA NÃO TEM A LETRA " + letra);
    }

    public static void msgVenceu(Jogador jogador){
        System.out.println("PARABÉNS! VOCÊ JOGADOR #" + jogador.getNumeroJogador() + " GANHOU O JOGO!");
        System.out.println("SUA PONTUAÇÃO FOI: " + jogador.getPontos() + " PONTO(S)");
    }

    public static void msgEmpate (){
        System.out.println("QUE DISPUTA! DEU EMPATE!");
    }

    public static void mostrarForca(PalavraForca palavraForca){
        System.out.print("FORCA: ");
        for(char c : palavraForca.getLetrasDescobertas()){
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void mostrarStatusJogador(Jogador jogador){
        System.out.println("JOGADOR #" + jogador.getNumeroJogador()
                + ": " + jogador.getPontos()
                + " ponto(s) / Tentativas restantes: " + jogador.getTentativas());
    }
}

