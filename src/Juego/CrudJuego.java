package Juego;

import Juego.Juego;
import Pistas.Pista;
import Carros.Carro;
import Carriles.Carril;
import Conductores.Conductores;
import Podio.Podio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import pruebasofka.Conexion;

public class CrudJuego {
    Conexion cn = new Conexion();
    Connection con;
    Statement st;
    ResultSet rs; 
    
    static Scanner entrada = new Scanner(System.in);
    static int competidores = 0, ganadores = 0, idjuego;
    static Conductores conductor;
    static Pista pista;
    static Carro carro;
    static Carril carril;
    static Podio podio = new Podio(1, " ", " ", " ");
    static String nombre = "";
    static ArrayList<Conductores> ListaConductores = new ArrayList<>();
    static ArrayList<Pista> ListaPista = new ArrayList<>();
    static ArrayList<Carro> ListaCarro = new ArrayList<>();
    static ArrayList<Carril> ListaCarril = new ArrayList<>();
    static ArrayList<Podio> ListaPodio = new ArrayList<>();

    // metodo para iniciar la configuracion del juego
    public void jugando() {
        idjuego = 1;
        do {
            System.out.println("Ingrese el numero de competidores, este debe ser como minimo 3:");
            competidores = entrada.nextInt();
        } while (competidores < 3);
        for (int i = 0; i < competidores; i++) { // ciclo para insernar n competidores
            insertarConductor(i);
        }
        crearPista(1, competidores);
        competir();
        Agregar();
    }

    public void insertarConductor(int i) {
        System.out.println("Inserte el nombre del competidor numero" + (i + 1) + ":");
        nombre = entrada.next();
        conductor = new Conductores((i + 1), nombre);
        ListaConductores.add(conductor);
    }

    public void crearPista(int i, int competidores) {
        System.out.println("Ingrese el numero de kilometros para la pista: ");
        pista = new Pista(i, (entrada.nextInt() * 1000), competidores);
        ListaPista.add(pista);
        relacionarPiloto(ListaConductores);
        relacionarCarriles(ListaCarro, ListaPista);
    }

    public void asignarCarro(int i, String nombre) {
        carro = new Carro((i + 1), nombre);
        ListaCarro.add(carro);
    }

    public void relacionarPiloto(ArrayList<Conductores> jugador) {
        for (int i = 0; i < jugador.size(); i++) {
            asignarCarro(i, jugador.get(i).getNombre());
        }
    }

    public void asignarCarril(int i, int idcarro, int idjuego, int idpista) {
        carril = new Carril(i, idcarro, idjuego, idpista);
        ListaCarril.add(carril);
    }

    public void relacionarCarriles(ArrayList<Carro> carros, ArrayList<Pista> pistas) {
        for (int i = 0; i < carros.size(); i++) {
            asignarCarril(i, carros.get(i).getIdCarro(), idjuego, pistas.get(0).getIdPista());
        }
    }

    public void competir() {
        //compitiendo = asignarConductor.retornarLista();
        while (ganadores < 3) {
            for (int i = 0; i < ListaCarro.size(); i++) {
                if (ListaCarro.get(i).getDistancia() < pista.getKilometroLimite()) {
                    ListaCarro.get(i).avanzar();
                    ganadores(ListaCarro.get(i).getDistancia(), ListaCarro.get(i).getNombre(), pista);
                }
            }
        }
        ListaPodio.add(podio);
        podio.mostrarPodio();
    }

    public void ganadores(int distancia, String nombre, Pista pista) {
        int metros = pista.getKilometroLimite();
        if (metros <= distancia) {
            ganadores++;
            podio(ganadores, nombre);
        }
    }

    public void podio(int posicion, String nombre) {
        switch (posicion) {
            case 1:
                podio.setPrimerLugar(nombre);
                break;
            case 2:
                podio.setSegundoLugar(nombre);
                break;
            case 3:
                podio.setTercerLugar(nombre);
                break;
        }
    }
    
    public void Agregar() {
        String PrimerLugar = podio.getPrimerLugar();
        String SegundoLugar = podio.getSegundoLugar();
        String TercerLugar = podio.getTercerLugar();
        try {
            String sql = "insert into podio (PrimerLugar,SegundoLugar,TercerLugar) values('" + PrimerLugar + "','" + SegundoLugar + "','" + TercerLugar + "')";
            con = cn.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Podio Registrado con Exito");
        } catch (Exception e) {
        }
    }
}
