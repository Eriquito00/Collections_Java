package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alimentacio extends Producte{
    private LocalDate data_caducitat;

    public Alimentacio(String nom, float preu, LocalDate data_caducitat) {
        super(nom, Math.round((calculaPreu(preu,data_caducitat) * 100.0f)) / 100.0f);
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
}