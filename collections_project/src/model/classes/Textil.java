package model.classes;

import java.time.temporal.ChronoUnit;

public class Textil extends Producte implements Comparable{
    private String composicio;

    public Textil(int codi, String nom, float preu, String composicio) {
        super(codi, nom, preu);
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

    public void setComposicio(String composicio) {
        this.composicio = composicio;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Textil{" +
                "composicio='" + composicio + '\'' +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (((Textil) o).getComposicio().compareTo(this.getComposicio()) < 0) return 1;
        else if (((Textil) o).getComposicio().compareTo(this.getComposicio()) > 0) return -1;
        return Integer.compare(this.getCodi(), ((Producte) o).getCodi());
    }
}