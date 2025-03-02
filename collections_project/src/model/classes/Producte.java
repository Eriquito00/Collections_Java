package model.classes;

import java.util.Comparator;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (((Producte)o).getCodi() == this.codi && ((Producte)o).getPreu() == this.preu) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codi, preu);
    }
}