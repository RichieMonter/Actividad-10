package main;

import java.util.Scanner;
import modelo.Estudiante;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes deseas almacenar? ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Estudiante[] estudiantes = new Estudiante[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            estudiantes[i] = new Estudiante(nombre, edad);
        }

        System.out.println("\nLista de estudiantes:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Estudiante " + (i + 1) + ": " +
                estudiantes[i].getNombre() + ", Edad: " + estudiantes[i].getEdad());
        }

        scanner.close();
    }
}
