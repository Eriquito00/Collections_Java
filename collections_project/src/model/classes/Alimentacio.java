package model.classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alimentacio extends Producte implements Comparable{
    private LocalDate data_caducitat;

    public Alimentacio(int codi, String nom, float preu, LocalDate data_caducitat) {
        super(codi, nom, Math.round((calculaPreu(preu,data_caducitat) * 100.0f)) / 100.0f);
        this.data_caducitat = data_caducitat;
    }

    private static float calculaPreu(float p, LocalDate ld) {
        long diesRestants = ChronoUnit.DAYS.between(LocalDate.now(), ld);
        if (diesRestants < 0) diesRestants = 0;
        return p - p * (1.0f / (diesRestants + 1)) + (p * 0.1f);
    }

    public LocalDate getData_caducitat() {
        return data_caducitat;
    }

    public void setData_caducitat(LocalDate data_caducitat) {
        this.data_caducitat = data_caducitat;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Alimentacio{" +
                "data_caducitat=" + data_caducitat +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (ChronoUnit.DAYS.between(this.data_caducitat, ((Alimentacio) o).getData_caducitat()) < 0) return 1;
        else if (ChronoUnit.DAYS.between(this.data_caducitat, ((Alimentacio) o).getData_caducitat()) > 0) return -1;
        return 0;
    }
}