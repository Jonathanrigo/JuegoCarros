package Carros;

public class Carro {

    int IdCarro, Posicion, Distancia;
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public Carro(int IdCarro, String nombre) {
        this.IdCarro = IdCarro;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCarro() {
        return IdCarro;
    }

    public void setIdCarro(int IdCarro) {
        this.IdCarro = IdCarro;
    }

    public int getPosicion() {
        return Posicion;
    }

    public void setPosicion(int Posicion) {
        this.Posicion = Posicion;
    }

    public int getDistancia() {
        return Distancia;
    }

    public void setDistancia(int Distancia) {
        this.Distancia = Distancia;
    }

    public void avanzar() {
        Distancia = (int) (Distancia + (Math.floor(Math.random()*(6-1+1)+1) * 100));
    }
}
