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

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    @Override
    public String toString(){
        return letra + " - " + posicao;
    }
}
