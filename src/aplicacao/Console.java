package aplicacao;

import entidades.LetraForca;
import entidades.PalavraForca;

public class Console {

    public static void mostraForca (PalavraForca palavraForca){
        for(LetraForca letra : palavraForca.getListaLetras()){
            if(letra != null) {
                System.out.print(letra.getLetra() + "-" + letra.getPosicao() + ", ");
            }
            else{
                System.out.println("_" + " ");
            }

        }
    }
}
