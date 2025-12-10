package entidades;

import java.util.ArrayList;
import java.util.List;

public class PalavraForca {

    private String palavraForca;
    private List<LetraForca> listaLetras = new ArrayList<>();

    public PalavraForca(String palavraForca){
        this.palavraForca = palavraForca.toUpperCase();
    }

    public void preparaForca(){
        char[] letras = palavraForca.toCharArray();
        for(int i = 0; i < letras.length; i++){
            listaLetras.add(new LetraForca(letras[i], i));
        }
    }

    @Override
    public String toString() {
        return "PalavraForca: " + palavraForca + " - Letras: " + listaLetras;
    }
}
