package Conductores;

// Constructor de la clase conductores
public class Conductores {
    int id, puntaje;
    String Nombre;

    public Conductores(int id, String Nombre) {
        this.id = id;
        this.puntaje = 0;
        this.Nombre = Nombre;
    }

    // Getter and Setter para cada atributo de la clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
}
