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
// variables para establecer la conexion a la base de datos
    Conexion cn = new Conexion();
    Connection con;
    Statement st;
    ResultSet rs;
// variables globales y objetos de clase
    static Scanner entrada = new Scanner(System.in);
    static int competidores = 0, ganadores = 0, idjuego, kilometros;
    static Conductores conductor;
    static Pista pista;
    static Carro carro;
    static Carril carril;
    static Podio podio;
    static String nombre = "";
    //creacion de listas para cada clase utilizada en el juego
    static ArrayList<Conductores> ListaConductores = new ArrayList<>();
    static ArrayList<Pista> ListaPista = new ArrayList<>();
    static ArrayList<Carro> ListaCarro = new ArrayList<>();
    static ArrayList<Carril> ListaCarril = new ArrayList<>();
    static ArrayList<Podio> ListaPodio = new ArrayList<>();

    // metodo para iniciar la configuracion del juego
    public void jugando() {
        idjuego = 1;
        do {
            System.out.println("Ingrese el numero de participantes, este debe ser minimo 3. ");
            competidores = entrada.nextInt();
        } while (competidores < 3);
        for (int i = 0; i < competidores; i++) { // ciclo para insernar n competidores
            insertarConductor(i);
        }
        crearPista(1, competidores);
        competir();
        InsertarPodio();
    }
// metodo para crear la lista de conductores
    public void insertarConductor(int id) {
        System.out.println("Inserte el nombre del competidor numero" + (id + 1) + ": ");
        nombre = entrada.next();
        conductor = new Conductores((id + 1), nombre);
        ListaConductores.add(conductor);
    }
// metodo para configurar la pista
    public void crearPista(int i, int competidores) {
        do {
            System.out.println("Ingrese los kilometros a recorrer en la pista, deben ser mayor a cero: ");
            kilometros = entrada.nextInt();
        } while (kilometros <= 0);
        pista = new Pista(i, (kilometros * 1000), competidores);
        ListaPista.add(pista);
        relacionarPiloto(ListaConductores);
        relacionarCarriles(ListaCarro, ListaPista);
    }
//metodo para asignar vehuculo a un conductor
    public void asignarCarro(int i, String nombre) {
        carro = new Carro((i + 1), nombre);
        ListaCarro.add(carro);
    }
// metodo para relacionar el piloto y el carro
    public void relacionarPiloto(ArrayList<Conductores> jugador) {
        for (int i = 0; i < jugador.size(); i++) {
            asignarCarro(i, jugador.get(i).getNombre());
        }
    }
// metodo para configurar un carril
    public void asignarCarril(int i, int idcarro, int idjuego, int idpista) {
        carril = new Carril(i, idcarro, idjuego, idpista);
        ListaCarril.add(carril);
    }
// metodo para relacionar los carriles a una pista
    public void relacionarCarriles(ArrayList<Carro> carros, ArrayList<Pista> pistas) {
        for (int i = 0; i < carros.size(); i++) {
            asignarCarril(i, carros.get(i).getIdCarro(), idjuego, pistas.get(0).getIdPista());
        }
    }
// metodo que inicia la competencia cuando se tiene configurado la pista y los participantes
    public void competir() {
        do {
            for (int i = 0; i < ListaCarro.size(); i++) {
                if (ListaCarro.get(i).getDistancia() < pista.getKilometroLimite()) {
                    ListaCarro.get(i).avanzar();
                    ganadores(ListaCarro.get(i).getDistancia(), ListaCarro.get(i).getNombre(), pista);
                }
            }
        }while (ganadores < 3);
        ListaPodio.add(podio);
        podio.mostrarPodio();
    }
// metodo para valiar los ganadores de la competencia
    public void ganadores(int distancia, String nombre, Pista pista) {
        if (pista.getKilometroLimite() <= distancia) {
            ganadores++;
            podio(ganadores, nombre);
        }
    }
// metodo para generar el podio recibiendo el nombre de los ganadores
    public void podio(int posicion, String nombre) {
        if(posicion==1){
          podio = new Podio();
        }
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
// metodo para guardar la lista de ganadores en la base de datos
    public void InsertarPodio() {
        try {
            String sql = "insert into podio (PrimerLugar,SegundoLugar,TercerLugar) values"
                    + "('" + podio.getPrimerLugar() + "','" + podio.getSegundoLugar() + "','" + podio.getTercerLugar() + "')";
            con = cn.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Podio Registrado con Exito");
        } catch (Exception e) {
        }
    }
}
