package classes;

public class Electronica extends Producte {
    private int dies_garantia;

    public Electronica(String nom, float preu, int dies_garantia) {
        super(nom, calculaPreu(preu, dies_garantia));
        this.dies_garantia = dies_garantia;
    }

    private static float calculaPreu(float p, int d_garantia){
        if (d_garantia < 0) d_garantia = 0;
        return p + p * (d_garantia / 365) * 0.1f;
    }

    public int getDies_garantia() {
        return dies_garantia;
    }

    public void setDies_garantia(int dies_garantia) {
        this.dies_garantia = dies_garantia;
    }

    @Override
    public String toString() {
        return super.toString() +"Electronica{" +
                "dies_garantia=" + dies_garantia +
                '}';
    }
}