package classes;

public class Textil extends Producte{
    private String composicio;

    public Textil(String nom, float preu, String composicio) {
        super(nom, preu);
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
}