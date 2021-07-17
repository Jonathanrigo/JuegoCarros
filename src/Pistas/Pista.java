package Pistas;


public class Pista {
    int idPista, KilometroLimite, NumCariles;

    public int getKilometroLimite() {
        return KilometroLimite;
    }

    public Pista(int idPista, int KilometroLimite, int NumCariles) {
        this.idPista = idPista;
        this.KilometroLimite = KilometroLimite;
        this.NumCariles = NumCariles;
    }

    public void setKilometroLimite(int KilometroLimite) {
        this.KilometroLimite = KilometroLimite;
    }

    public int getNumCariles() {
        return NumCariles;
    }

    public void setNumCariles(int NumCariles) {
        this.NumCariles = NumCariles;
    }

    public int getIdPista() {
        return idPista;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }
}
