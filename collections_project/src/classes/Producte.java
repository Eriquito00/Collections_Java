package classes;

public abstract class Producte {
    private static int id = 000001;
    private int codi;
    private String nom;
    private float preu;

    public Producte(String nom, float preu) {
        this.codi = id++;
        this.nom = nom;
        this.preu = preu;
    }

    public int getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Producte{" +
                "codi=" + codi +
                ", nom='" + nom + '\'' +
                ", preu='" + preu + '\'' +
                '}';
    }
}