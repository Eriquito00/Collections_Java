import model.Model;
import vista.Vista;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir){
            try {
                Vista.mostrarTitol("INICI");
                Vista.menu("Gestio Magatzem i Compres", "Introduir producte", "Passar per caixa", "Mostrar carro de la compra", "Sortir");
                int opcio = Integer.parseInt(scan.nextLine());
                if (opcio < 0 || opcio > 4) throw new RuntimeException("La opcio introduida no existeix.");
                switch (opcio){
                    case 0:
                        opcio1();
                        break;
                    case 1:
                        opcio2();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        Vista.mostraMsg("Finalitzant el programa...");
                        seguir = false;
                        break;
                }
            }
            catch (RuntimeException e) {
                Vista.mostraMsg(e.getMessage());
            }
        }
    }

    /**
     * Gestion de todas las subopciones del apartado 1
     */
    private static void opcio1(){
        boolean seguir = true;
        while (seguir){
            try {
                Vista.mostrarTitol("CONSULTES");
                Vista.menu("Caducitat", "Tiquets de compra", "Composicio textil", "Tornar");
                int opcio = Integer.parseInt(scan.nextLine());
                if (opcio < 0 || opcio > 3) throw new RuntimeException("La opcio introduida no existeix.");
                switch (opcio){
                    case 0:
                        Model.cuaCaducitat();
                        Vista.mostrarArrayList(Model.productesOrdreCaducitat);
                        break;
                    case 1:
                        break;
                    case 2:
                        Model.cuaComposicio();
                        Vista.mostrarArrayList(Model.productesOrdreTextilCodi);
                        break;
                    default:
                        Vista.mostraMsg("Tornant al menu inicial...");
                        seguir = false;
                        break;
                }
            }
            catch (RuntimeException e) {
                Vista.mostraMsg(e.getMessage());
            }
        }
    }

    /**
     * Gestion de todas las subopciones del apartado 2
     */
    private static void opcio2(){
        boolean seguir = true;
        while (seguir){
            try {
                Vista.mostrarTitol("INTRODUIR PRODUCTES");
                Vista.menu("Alimentacio", "Textil", "Electronica", "Tornar");
                int opcio = Integer.parseInt(scan.nextLine());
                if (opcio < 0 || opcio > 3) throw new RuntimeException("La opcio introduida no existeix.");

                switch (opcio){
                    case 0:
                        Vista.mostrarTitol("ALIMENTACIO");
                        creaAliment(demanaCodi(), demanaNom(), demanaPreu());
                        break;
                    case 1:
                        Vista.mostrarTitol("TEXTIL");
                        creaTextil(demanaCodi(), demanaNom(), demanaPreu());
                        break;
                    case 2:
                        Vista.mostrarTitol("ELECTRONICA");
                        creaElectronic(demanaCodi(), demanaNom(), demanaPreu());
                        break;
                    default:
                        Vista.mostraMsg("Tornant al menu inicial...");
                        seguir = false;
                        break;
                }
            }
            catch (RuntimeException e) {
                Vista.mostraMsg(e.getMessage());
            }
        }
    }

    /**
     * Pide el codigo para el producto
     * @return Integer con el codigo
     */
    private static int demanaCodi(){
        Vista.mostraMsg("Introdueix el codi de barres.");
        int codi = Integer.parseInt(scan.nextLine());
        if (codi < 1) throw new RuntimeException("El codi no pot ser menor a 1");
        return codi;
    }

    /**
     * Pide el nombre para el producto
     * @return String con el codigo
     */
    private static String demanaNom(){
        Vista.mostraMsg("Introdueix el nom.");
        String nom = scan.nextLine();
        return nom;
    }

    /**
     * Pide el precio para el producto
     * @return Float con el codigo
     */
    private static float demanaPreu(){
        Vista.mostraMsg("Introdueix el preu.");
        float preu = Float.parseFloat(scan.nextLine());
        if (preu < 0.1f) throw new RuntimeException("El preu no pot ser inferior a 0.1€");
        return preu;
    }

    /**
     * Pide los datos especificos de un objeto Electronico i lo manda a crear
     * @param codi Integer con el codigo
     * @param nom String con el nombre
     * @param preu Float con el precio
     */
    private static void creaElectronic(int codi, String nom, float preu){
        Vista.mostraMsg("Introdueix el numero de dies de garantia del aliment.");
        int dies_garantia = Integer.parseInt(scan.nextLine());
        Model.creaElectronic(codi,nom,preu,dies_garantia);
    }

    /**
     * Pide los datos especificos de un objeto Textil i lo manda a crear
     * @param codi Integer con el codigo
     * @param nom String con el nombre
     * @param preu Float con el precio
     */
    private static void creaTextil(int codi, String nom, float preu){
        Vista.mostraMsg("Introdueix la composicio del aliment.");
        String composicio = scan.nextLine();
        Model.creaTextil(codi,nom,preu,composicio);
    }

    /**
     * Pide los datos especificos de un objeto Alimento i lo manda a crear
     * @param codi Integer con el codigo
     * @param nom String con el nombre
     * @param preu Float con el precio
     */
    private static void creaAliment(int codi, String nom, float preu){
        Vista.mostraMsg("Introdueix l'ANY de la data de caducitat.");
        int any = Integer.parseInt(scan.nextLine());
        if (any < LocalDate.now().getYear()) throw new RuntimeException("¡NO POR HABER PRODUCTES CADUCATS!");

        Vista.mostraMsg("Introdueix el MES de la data de caducitat.");
        int mes = Integer.parseInt(scan.nextLine());
        if (mes < 1 || mes > 12) throw new RuntimeException("¡MES INVÀLID! Ha de ser entre 1 i 12.");
        if (any == LocalDate.now().getYear() && mes < LocalDate.now().getMonthValue()) throw new RuntimeException("¡NO POR HABER PRODUCTES CADUCATS!");

        Vista.mostraMsg("Introdueix el DIA de la data de caducitat.");
        int dia = Integer.parseInt(scan.nextLine());
        if (comprovaDia(any, mes, dia)){
            LocalDate data = LocalDate.of(any,mes,dia);
            Model.creaAlimentacio(codi,nom,preu,data);
        }
        else throw new RuntimeException("La data introduida no es valida");
    }

    /**
     * Comprueba si el dia introducido es valido
     * @param any Integer con el año
     * @param mes Integer con el mes
     * @param dia Integer con el dia
     * @return True si la fecha es valida False si no
     */
    private static boolean comprovaDia(int any, int mes, int dia) {
        int[] diesMesos = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (mes == 2 && esBisiesto(any)) diesMesos[1] = 29;

        if (dia >= 1 && dia <= diesMesos[mes - 1]) return true;
        return false;
    }

    /**
     * Comprueba si un año es bisiesto
     * @param any Integer con el año
     * @return True si es bisiesto False si no
     */
    private static boolean esBisiesto(int any) {
        if ((any % 4 == 0 && any % 100 != 0) || (any % 400 == 0)) return true;
        return false;
    }
}