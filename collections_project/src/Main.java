import classes.Alimentacio;
import classes.Electronica;
import classes.Producte;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Electronica a = new Electronica("Tomate", 10.5f, 120);
        System.out.println(a.getPreu());
    }
}