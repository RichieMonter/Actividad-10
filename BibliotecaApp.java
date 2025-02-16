import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Libro> libros = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear / Registrar un libro");
            System.out.println("2. Buscar por Código");
            System.out.println("3. Mostrar todos los libros");
            System.out.println("4. Buscar por Género");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el código de barras: ");
                    String codigoBarras = scanner.nextLine();
                    System.out.print("Ingrese el género: ");
                    String genero = scanner.nextLine();

                    libros.add(new Libro(titulo, autor, codigoBarras, genero));
                    System.out.println("Libro registrado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el código de barras del libro a buscar: ");
                    String codigoBuscar = scanner.nextLine();
                    Libro libroEncontrado = Libro.buscarPorCodigo(libros, codigoBuscar);
                    if (libroEncontrado != null) {
                        System.out.println("\nTítulo: " + libroEncontrado.getTitulo());
                        System.out.println("Autor: " + libroEncontrado.getAutor());
                        System.out.println("Código de Barras: " + libroEncontrado.getCodigoBarras());
                        System.out.println("Género: " + libroEncontrado.getGenero());
                    } else {
                        System.out.println("No se encontró el código solicitado: " + codigoBuscar);
                    }
                    break;

                case 3:
                    Libro.mostrarTodos(libros);
                    break;

                case 4:
                    System.out.print("Ingrese el género a buscar: ");
                    String generoBuscar = scanner.nextLine();
                    List<Libro> librosPorGenero = Libro.buscarPorGenero(libros, generoBuscar);
                    if (!librosPorGenero.isEmpty()) {
                        Libro.mostrarTodos(librosPorGenero);
                    } else {
                        System.out.println("No se encontró el género solicitado: " + generoBuscar);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}