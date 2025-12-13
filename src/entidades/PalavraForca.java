package entidades;

import java.util.ArrayList;
import java.util.List;

public class PalavraForca {

    private final String palavraForca;
    private List<LetraForca> listaLetras;
    private char[] letrasDescobertas;
    private Integer numLetrasDescobertas;

    public PalavraForca(String palavraForca){
        this.palavraForca = palavraForca.toUpperCase();
        listaLetras = new ArrayList<>();
        numLetrasDescobertas = 0;
    }

    public List<LetraForca> getListaLetras() {
        return listaLetras;
    }

    public char[] getLetrasDescobertas() {
        return letrasDescobertas;
    }

    public int getNumLetrasDescobertas(){
        return numLetrasDescobertas;
    }

    public void preparaForca(){
        char[] letras = palavraForca.toCharArray();
        letrasDescobertas = new char[letras.length];
        for(int i = 0; i < letras.length; i++){
            listaLetras.add(new LetraForca(letras[i], i));
            letrasDescobertas[i] = '_';
        }
    }

    private List<LetraForca> verificaLetra(char letra){
        List<LetraForca> listaLetrasVerificadas = new ArrayList<>();
        LetraForca letraForca = null;
        for (int i = 0; i < listaLetras.size(); i++) {
            letraForca = listaLetras.get(i);
            if (letraForca.getLetra() == letra) {
                listaLetrasVerificadas.add(letraForca);
                numLetrasDescobertas++;
            }
        }
        return listaLetrasVerificadas;
    }

    public void atualizaForca(char letra){
        List<LetraForca> listaLetras = verificaLetra(Character.toUpperCase(letra));
        for (LetraForca letraForca : listaLetras) {
            letrasDescobertas[letraForca.getPosicao()] = letraForca.getLetra();
        }
    }

    public boolean conferePalavra(){
        if (numLetrasDescobertas == listaLetras.size()) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "PalavraForca: " + palavraForca + " - Letras: " + listaLetras;
    }
}
