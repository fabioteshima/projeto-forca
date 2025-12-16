package entidades;

public class Jogador {

    private int numeroJogador;
    private int tentativas;
    private int pontos;
    private Boolean turno;

    public Jogador(int numeroJogador, boolean turno){
        this.numeroJogador = numeroJogador;
        this.tentativas = 6;
        this.pontos = 0;
        this.turno = turno;
    }

    public int getNumeroJogador() {
        return numeroJogador;
    }

    public int getTentativas() {
        return tentativas;
    }

    public int getPontos() {
        return pontos;
    }

    public Boolean getTurno() {
        return turno;
    }

    public void setTurno(Boolean turno) {
        this.turno = turno;
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
