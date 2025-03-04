package model;

import model.classes.*;

import java.time.LocalDate;
import java.util.*;

public class Model {
    //ArrayList con todos los productos
    public static ArrayList<Producte> productes = new ArrayList<>();
    //ArrayList con todos los productos ordenados con prioridad a alimentos con fecha de caducidad
    public static ArrayList<Producte> productesOrdreCaducitat = new ArrayList<>();
    //ArrayList con todos los productos ordenados con prioridad a textiles alfabeticamente por su composicion y codigo
    public static ArrayList<Producte> productesOrdreTextilCodi = new ArrayList<>();
    //HashMap del carret de la compra
    public static HashMap<Producte, Integer> carret = new HashMap<>();
    //ArrayList amb els tiquets
    public static ArrayList<Tiquet> tiquets = new ArrayList<>();

    /**
     * En base a la ArrayList de productes generales crea un HashMap com los objetos y las cantidades correspondientes
     */
    public static void carretCompra(){
        carret.clear();
        for (int i = 0; i < productes.size(); i++) {
            if (carret.containsKey(productes.get(i))) carret.put(productes.get(i), carret.get(productes.get(i)) + 1);
            else carret.put(productes.get(i), 1);
        }
    }

    /**
     * Crea un objeto de tipo electronica
     * @param codi Codigo de barras
     * @param nom Nombre del objeto
     * @param preu Precio
     * @param dies_garantia Numero entero de dias de garantia
     */
    public static void creaElectronic(int codi, String nom, float preu, int dies_garantia){
        productes.add(new Electronica(codi, nom,preu, dies_garantia));
    }

    /**
     * Crea un objeto de tipo textil
     * @param codi Codigo de barras
     * @param nom Nombre del objeto
     * @param preu Precio
     * @param composicio String del material con el que esta fabricado
     */
    public static void creaTextil(int codi, String nom, float preu, String composicio){
        productes.add(new Textil(codi, nom,preu, composicio));
    }

    /**
     * Crea un objeto de tipo alimentacion
     * @param codi Codigo de barras
     * @param nom Nombre del objeto
     * @param preu Precio
     * @param data Fecha de caducidad
     */
    public static void creaAlimentacio(int codi, String nom, float preu, LocalDate data){
        productes.add(new Alimentacio(codi, nom,preu, data));
    }

    /**
     * Crea una cola segun la composicion de los textiles
     */
    public static void cuaComposicio(){
        PriorityQueue<Producte> textils = onlyOneClass(productes, Textil.class);
        productesOrdreTextilCodi.clear();
        while(!textils.isEmpty()) productesOrdreTextilCodi.add(textils.remove());
        ArrayList<Producte> noTextils = withOutOneClass(productes, Textil.class);
        for (int i = 0; i < noTextils.size(); i++) productesOrdreTextilCodi.add(noTextils.get(i));
    }

    /**
     * Crea una cola segun la caducidad de los alimentos
     */
    public static void cuaCaducitat(){
        PriorityQueue<Producte> aliments = onlyOneClass(productes, Alimentacio.class);
        productesOrdreCaducitat.clear();
        while(!aliments.isEmpty()) productesOrdreCaducitat.add(aliments.remove());
        ArrayList<Producte> noAliments = withOutOneClass(productes, Alimentacio.class);
        for (int i = 0; i < noAliments.size(); i++) productesOrdreCaducitat.add(noAliments.get(i));
    }

    /**
     * Crea una cola de prioridades segun la clase que se pasa
     * @param a ArrayList introducidad con los objetos
     * @param clase Clase con la que NOS QUEDAMOS
     * @return PriorityQueue con los objetos de esa clase
     */
    public static PriorityQueue<Producte> onlyOneClass(ArrayList<Producte> a, Class clase){
        PriorityQueue<Producte> array = new PriorityQueue<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getClass() == clase) array.add(a.get(i));
        }
        return array;
    }

    /**
     * Crea una ArrayList excluyendo la clase introducida
     * @param a ArrayList introducidad con los objetos
     * @param clase Clase que vamos a EXCLUIR
     * @return ArrayList con todos los objetos excepto los de la clase introducida
     */
    public static ArrayList<Producte> withOutOneClass(ArrayList<Producte> a, Class clase){
        ArrayList<Producte> array = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getClass() != clase) array.add(a.get(i));
        }
        return array;
    }

    /**
     * Crea els objectes per defecte per fer proves
     */
    public static void defaultObjects(){
        LocalDate l1 = LocalDate.of(2025, 8, 15);
        LocalDate l2 = LocalDate.of(2025, 9, 21);
        LocalDate l3 = LocalDate.of(2025, 7, 30);
        LocalDate l4 = LocalDate.of(2025, 9, 20);

        productes.add(new Alimentacio(100000, "Tomaquet", 2.5f, l1));
        productes.add(new Alimentacio(100001,"Patata", 1.25f, l2));
        productes.add(new Alimentacio(100002,"Pastanaga", 5.25f, l3));
        productes.add(new Alimentacio(100003,"Fresa", 3.85f, l4));
        productes.add(new Electronica(200000,"Mobil", 200.5f, 120));
        productes.add(new Electronica(200001,"Portatil", 502.99f, 365));
        productes.add(new Textil(300000,"Jaqueta", 50.4f, "cuero"));
        productes.add(new Textil(300001,"Camisa", 25.4f, "coto"));
        productes.add(new Textil(300002,"Polo", 22.4f, "coto"));
        productes.add(new Textil(300003,"Jaqueta", 50.4f, "tela"));

        productes.add(new Alimentacio(100000, "Tomaquet", 2.5f, l1));
        productes.add(new Alimentacio(100002,"Pastanaga", 5.25f, l3));
        productes.add(new Electronica(200001,"Portatil", 502.99f, 365));
        productes.add(new Textil(300001,"Camisa", 25.4f, "coto"));
        productes.add(new Textil(300003,"Jaqueta", 50.4f, "tela"));
        productes.add(new Textil(300000,"Jaqueta", 50.4f, "cuero"));
        productes.add(new Alimentacio(100000, "Tomaquet", 2.5f, l2));
    }
}