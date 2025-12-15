package entidades;

import java.util.ArrayList;
import java.util.List;

public class PalavraForca {

    private final String palavraForca;
    private List<LetraForca> listaLetras;
    private char[] letrasDescobertas;
    private int numLetrasDescobertas;

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

    public boolean verificarLetra(char letra){
        letra = Character.toUpperCase(letra);
        boolean encontrou = false;
        for(char c : getLetrasDescobertas()){
            if (c == letra) {
                encontrou = true;
            }
        }
        return encontrou;
    }

    public void prepararForca(){
        char[] letras = palavraForca.toCharArray();
        letrasDescobertas = new char[letras.length];
        for(int i = 0; i < letras.length; i++){
            listaLetras.add(new LetraForca(letras[i], i));
            letrasDescobertas[i] = '_';
        }
    }

    public boolean atualizarForca(char letra) {
        letra = Character.toUpperCase(letra);
        boolean encontrou = false;
        for (LetraForca letraForca : listaLetras) {
            if (letraForca.getLetra() == letra) {
                if (letrasDescobertas[letraForca.getPosicao()] == '_') {
                    letrasDescobertas[letraForca.getPosicao()] = letraForca.getLetra();
                    numLetrasDescobertas++;
                }
                encontrou = true;
            }
        }
        return encontrou;
    }

    public boolean verificarSePalavraCompleta(){
        if (numLetrasDescobertas == listaLetras.size()) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "PalavraForca: " + palavraForca + " - Letras: " + listaLetras;
    }
}
