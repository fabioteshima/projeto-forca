package entidades;

public class LetraForca {

    private char letra;
    private int posicao;

    public LetraForca(char letra, int posicao) {
        this.letra = letra;
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public char getLetra() {
        return letra;
    }

    @Override
    public String toString(){
        return letra + " - " + posicao;
    }
}
