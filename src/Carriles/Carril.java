package Carriles;

public class Carril {

    int IdCarril,
            Carro,
            Juego,
            Pista;

    public int getIdCarril() {
        return IdCarril;
    }

    public Carril(int IdCarril, int Carro, int Juego, int Pista) {
        this.IdCarril = IdCarril;
        this.Carro = Carro;
        this.Juego = Juego;
        this.Pista = Pista;
    }

    public void setIdCarril(int IdCarril) {
        this.IdCarril = IdCarril;
    }

    public int getCarro() {
        return Carro;
    }

    public void setCarro(int Carro) {
        this.Carro = Carro;
    }

    public int getJuego() {
        return Juego;
    }

    public void setJuego(int Juego) {
        this.Juego = Juego;
    }

    public int getPista() {
        return Pista;
    }

    public void setPista(int Pista) {
        this.Pista = Pista;
    }
}
