package pruebasofka;

import Juego.CrudJuego;


public class PruebaSofka {

    
    public static void main(String[] args) {
        System.out.println("**********   Bienvenidos al Sofka Challenger   **********");
        System.out.println("");
        System.out.println("Antes de iniciar con la competencia se debe ingresar la cantidad de participantes.");
        System.out.println("");
        CrudJuego  juego = new CrudJuego();
        juego.jugando();
    }
}
