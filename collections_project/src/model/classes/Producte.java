package model.classes;

public abstract class Producte {
    private int codi;
    private String nom;
    private float preu;

    public Producte(int codi, String nom, float preu) {
        this.codi = codi;
        this.nom = nom;
        this.preu = preu;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
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