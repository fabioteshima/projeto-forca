package aplicacao;

import entidades.LetraForca;
import entidades.PalavraForca;

public class Console {

    public static void mostraForca(PalavraForca palavraForca){
        System.out.print("Forca: ");
        for(char c : palavraForca.getLetrasDescobertas()){
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void msgBoasVindas(){
        System.out.println();
        System.out.println("BEM VINDO AO JOGO DA FORCA!");
        System.out.println();
    }

    public static void msgFimJogo(){
       System.out.println("O JOGO TERMINOU! THANK YOU FOR PLAYING!");
    }
}

