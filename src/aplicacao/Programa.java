package aplicacao;

import entidades.PalavraForca;

public class Programa {

    public static void main (String[] args){

        PalavraForca palavra = new PalavraForca("banana");
        palavra.preparaForca();
        Console.mostraForca(palavra); // mostra as letras e suas posições pela inteface

    }
}
