package aplicacao;

import entidades.PalavraForca;

import java.util.Scanner;

public class Programa {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavraEntrada = sc.nextLine();
        PalavraForca palavra = new PalavraForca(palavraEntrada);

        palavra.preparaForca();

        System.out.print("Digite uma letra: ");
        char letra = sc.next().charAt(0);

        palavra.atualizaForca(letra);

        Console.mostraForca(palavra); // mostra as letras e suas posições pela inteface

    }
}
