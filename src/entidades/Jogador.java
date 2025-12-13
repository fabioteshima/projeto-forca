package entidades;

public class Jogador {

    private int tentativas;
    private int pontos;

    public Jogador(){
        this.tentativas = 6;
        this.pontos = 0;
    }

    public int getTentativas() {
        return tentativas;
    }

    public int getPontos() {
        return pontos;
    }

    public void somaPontos(){
        pontos ++;
    }
    public void diminuiTentativas(){
        tentativas--;
    }

    @Override
    public String toString(){
        return "Tentativas restantes: " + tentativas + "Pontos: " + pontos;
    }
}
