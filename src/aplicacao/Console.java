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
}

