package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PalavraForca {

    private String palavraForca;
    private List<LetraForca> listaLetras = new ArrayList<>();
    private char[] letrasDescobertas;

    public PalavraForca(String palavraForca){
        this.palavraForca = palavraForca.toUpperCase();
    }

    public List<LetraForca> getListaLetras() {
        return listaLetras;
    }

    public char[] getLetrasDescobertas() {
        return letrasDescobertas;
    }

    public void preparaForca(){
        char[] letras = palavraForca.toCharArray();
        letrasDescobertas = new char[letras.length];
        for(int i = 0; i < letras.length; i++){
            listaLetras.add(new LetraForca(letras[i], i));
            letrasDescobertas[i] = '_';
        }
    }

    public List<LetraForca> verificaLetra(char letra){
        List<LetraForca> list = new ArrayList<>();
        for(int i = 0; i < listaLetras.size(); i++){
            if(listaLetras.get(i).getLetra() == letra){
                list.add(new LetraForca(listaLetras.get(i).getLetra(), i));
            }
        }
        return list;
    }

    public boolean atualizaForca(char letra){
        List<LetraForca> listaLetras = verificaLetra(Character.toUpperCase(letra));
        if (listaLetras.isEmpty()) {
            return false;
        }
        for (LetraForca letraForca : listaLetras) {
            letrasDescobertas[letraForca.getPosicao()] = letraForca.getLetra();
        }
        return true;
    }

    @Override
    public String toString() {
        return "PalavraForca: " + palavraForca + " - Letras: " + listaLetras;
    }
}
