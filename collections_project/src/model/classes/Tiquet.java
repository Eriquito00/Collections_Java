package model.classes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Tiquet {
    private static int id = 1;
    private HashMap<Producte, Integer> producte_quantitat;

    public Tiquet(HashMap<Producte, Integer> producte_quantitat) {
        this.producte_quantitat = producte_quantitat;
    }

    @Override
    public String toString() {
        String p_qt = "";
        float total = 0;
        for (Map.Entry<Producte, Integer> entry : producte_quantitat.entrySet()) {
            Producte p = entry.getKey();
            int qt = entry.getValue();
            float preuUnitari = p.getPreu(), preuTotal = preuUnitari * qt;

            total += preuTotal;
            p_qt += String.format("%-25s %4d %8.2f€ %8.2f€", p.getNom(), qt, preuUnitari, preuTotal) + "\n";
        }
        return  "--------------------------------------------------" + "\n" +
                "                    SAPAMERCAT                    " + "\n" +
                "--------------------------------------------------" + "\n" +
                "Data: " + LocalDate.now()                           + "\n" +
                "--------------------------------------------------" + "\n" +
                p_qt + "\n" +
                "--------------------------------------------------" + "\n" +
                "Total: " + String.format("%.2f€",total)                                    + "\n";
    }
}