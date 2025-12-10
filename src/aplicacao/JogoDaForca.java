package aplicacao;

import entidades.LetraForca;
import entidades.PalavraForca;

public class JogoDaForca {

    public static void main (String[] args){

        PalavraForca palavra = new PalavraForca("casa");
        palavra.preparaForca();
        System.out.println(palavra.toString());
    }
}
