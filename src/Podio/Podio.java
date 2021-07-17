package Podio;

public class Podio {

    int idpodio;
    String PrimerLugar,SegundoLugar,TercerLugar;

    public Podio() {
    }

   
    public int getIdpodio() {
        return idpodio;
    }

    public void setIdpodio(int idpodio) {
        this.idpodio = idpodio;
    }

    public String getPrimerLugar() {
        return PrimerLugar;
    }

    public void setPrimerLugar(String PrimerLugar) {
        this.PrimerLugar = PrimerLugar;
    }

    public String getSegundoLugar() {
        return SegundoLugar;
    }

    public void setSegundoLugar(String SegundoLugar) {
        this.SegundoLugar = SegundoLugar;
    }

    public String getTercerLugar() {
        return TercerLugar;
    }

    public void setTercerLugar(String TercerLugar) {
        this.TercerLugar = TercerLugar;
    }
    
    public void mostrarPodio(){
        System.out.println("Primer lugar para el competidor: "+ getPrimerLugar()+".");
        System.out.println("Segundo lugar para el competidor: "+ getSegundoLugar()+".");
        System.out.println("Tercer lugar para el competidor: " +getTercerLugar()+".");
    }
}
