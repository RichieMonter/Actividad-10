import java.util.HashSet;
import java.util.Scanner;

public class RegistroEmpleados {
    public static void main(String[] args) {
        HashSet<Integer> empleados = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menú:");
            System.out.println("1. Registrar ingreso");
            System.out.println("2. Registrar salida");
            System.out.println("3. Finalizar (mostrar resumen)");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número de identificación del empleado: ");
                    int idIngreso = scanner.nextInt();
                    empleados.add(idIngreso);
                    System.out.println("Ingreso registrado.");
                    break;
                case 2:
                    System.out.print("Ingrese el número de identificación del empleado: ");
                    int idSalida = scanner.nextInt();
                    if (empleados.contains(idSalida)) {
                        System.out.println("Salida registrada.");
                    } else {
                        System.out.println("El empleado no está registrado.");
                    }
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        System.out.println("Número total de empleados únicos: " + empleados.size());
        scanner.close();
    }
}