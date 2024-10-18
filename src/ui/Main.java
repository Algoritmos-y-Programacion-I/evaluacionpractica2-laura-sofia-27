package ui;

import java.util.Scanner;
import model.Controller;

public class Main {
    private static Controller controladora = new Controller();
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
     */
    public static void menu() {
        boolean flag = true;

        do {
            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pilar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);
    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema
     */
    public static void registerProject() {
        reader.nextLine(); // Limpiar el buffer
    
        System.out.println("Ingrese el tipo de Pilar (0-Biodiversidad, 1-Agua, 2-Tratamiento de Basuras, 3-Energía): ");
        int pilarPosicion = reader.nextInt();
    
        System.out.println("Ingrese el ID del Proyecto: ");
        String id = reader.next();
    
        System.out.println("Ingrese el Nombre del Proyecto: ");
        String name = reader.next();
    
        System.out.println("Ingrese la Descripción del Proyecto: ");
        String description = reader.next();
    
        // Controlar el ingreso de un booleano válido
        boolean status = false;
        boolean entrada= false;
    
        while (!entrada) {
            System.out.println("Ingrese el estado del Proyecto (true para Activo, false para Inactivo): ");
            String input = reader.next(); // Tomar la entrada como cadena
    
            if (input.equalsIgnoreCase("true")) {
                status = true;
                entrada = true;
            } else if (input.equalsIgnoreCase("false")) {
                status = false;
                entrada = true;
            } else {
                System.out.println("Entrada no válida. Por favor ingrese 'true' o 'false'.");
            }
        }
    
        boolean added = controladora.addProjectToPillar(pilarPosicion, id, name, description, status);
        if (added) {
            System.out.println("Proyecto registrado exitosamente!");
        } else {
            System.out.println("No se pudo registrar el proyecto. Verifique la posición del pilar.");
        }
    }
    
    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pilar 
     */
    public static void showProjectsByPillar() {
        System.out.println("Ingrese el tipo de Pilar (0-Biodiversidad, 1-Agua, 2-Tratamiento de Basuras, 3-Energía): ");
        int pilarPosicion = reader.nextInt();

        String projects = controladora.listProjectsInPillar(pilarPosicion);
        System.out.println(projects);
    }
}
