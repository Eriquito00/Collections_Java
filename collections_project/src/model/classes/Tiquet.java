package model.classes;

import java.util.ArrayList;

public class Tiquet {
    private static int id = 1;
    private ArrayList<Producte> productes;

    public Tiquet(Producte ... producte) {
        for (Producte p: producte) productes.add(p);
    }
}