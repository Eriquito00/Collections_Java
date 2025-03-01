package vista;

import model.classes.Producte;

import java.util.ArrayList;

public class Vista {
    /**
     * Muestra un mensaje
     * @param msg Mensaje mostrado
     */
    public static void mostraMsg(String msg){
        System.out.println(msg);
    }

    /**
     * Crea un menu de opciones
     * @param opciones Opciones del menu
     */
    public static void menu(String ... opciones){
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(i + ": " + opciones[i]);
        }
    }

    /**
     * Muestra un titulo con formato
     * @param nom String del nombre del titulo
     */
    public static void mostrarTitol(String nom){
        String len = "";
        for (int i = 0; i < nom.length(); i++) {
            len += "-";
        }
        System.out.println(len);
        System.out.println(nom);
        System.out.println(len);
    }

    /**
     * Muestra una ArrayList
     * @param a ArrayList mostrada
     */
    public static void mostrarArrayList(ArrayList <Producte> a){
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}
