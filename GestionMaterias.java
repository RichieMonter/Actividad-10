/**
 * Programa de gestión de materias.
 * Permite registrar profesores, salones y materias, asegurando la selección adecuada de recursos.
 * Incluye un menú interactivo para gestionar la información y mostrar los datos registrados.
 */

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 
 // Clase Profesor
 class Profesor {
     private String nombre;
     private int edad;
     private String clave;
 
     public Profesor(String nombre, int edad, String clave) {
         this.nombre = nombre;
         this.edad = edad;
         this.clave = clave;
     }
 
     public String getNombre() { return nombre; }
     public int getEdad() { return edad; }
     public String getClave() { return clave; }
 }
 
 // Clase Salon
 class Salon {
     private String nombre;
     private String edificio;
 
     public Salon(String nombre, String edificio) {
         this.nombre = nombre;
         this.edificio = edificio;
     }
 
     public String getNombre() { return nombre; }
     public String getEdificio() { return edificio; }
 }
 
 // Clase Materia
 class Materia {
     private String nombre;
     private Profesor profesor;
     private Salon salon;
 
     public Materia(String nombre, Profesor profesor, Salon salon) {
         this.nombre = nombre;
         this.profesor = profesor;
         this.salon = salon;
     }
 
     public String getNombre() { return nombre; }
     public Profesor getProfesor() { return profesor; }
     public Salon getSalon() { return salon; }
 }
 
 // Clase principal que maneja el menú y la lógica
 public class GestionMaterias {
     private static List<Profesor> profesores = new ArrayList<>();
     private static List<Salon> salones = new ArrayList<>();
     private static List<Materia> materias = new ArrayList<>();
     private static Scanner scanner = new Scanner(System.in);
 
     public static void main(String[] args) {
         int opcion;
         do {
             mostrarMenu();
             opcion = scanner.nextInt();
             scanner.nextLine();
             
             switch (opcion) {
                 case 1 -> agregarProfesor(); // Agregar un nuevo profesor
                 case 2 -> agregarSalon(); // Agregar un nuevo salón
                 case 3 -> agregarMateria(); // Agregar una nueva materia con validaciones
                 case 4 -> System.out.println("Saliendo del programa..."); // Salida del programa
                 case 5 -> mostrarMaterias(); // Mostrar materias registradas
                 default -> System.out.println("Opción no válida. Intente nuevamente.");
             }
         } while (opcion != 4);
     }
 
     // Muestra el menú principal
     private static void mostrarMenu() {
         System.out.println("\nMenú Principal:");
         System.out.println("1. Agregar Profesor");
         System.out.println("2. Agregar Salón");
         System.out.println("3. Agregar Materia");
         System.out.println("4. Salir");
         System.out.println("5. Mostrar Materias Registradas");
         System.out.print("Seleccione una opción: ");
     }
 
     // Agrega un nuevo profesor a la lista
     private static void agregarProfesor() {
         System.out.print("Ingrese nombre del profesor: ");
         String nombre = scanner.nextLine();
         System.out.print("Ingrese edad del profesor: ");
         int edad = scanner.nextInt();
         scanner.nextLine();
         System.out.print("Ingrese clave del profesor: ");
         String clave = scanner.nextLine();
         profesores.add(new Profesor(nombre, edad, clave));
         System.out.println("Profesor agregado exitosamente.");
     }
 
     // Agrega un nuevo salón a la lista
     private static void agregarSalon() {
         System.out.print("Ingrese nombre del salón: ");
         String nombre = scanner.nextLine();
         System.out.print("Ingrese edificio del salón: ");
         String edificio = scanner.nextLine();
         salones.add(new Salon(nombre, edificio));
         System.out.println("Salón agregado exitosamente.");
     }
 
     // Agrega una nueva materia verificando la existencia de profesores y salones
     private static void agregarMateria() {
         if (profesores.isEmpty() || salones.isEmpty()) {
             System.out.println("Error: No hay profesores o salones registrados.");
             return;
         }
 
         System.out.print("Ingrese el nombre de la materia: ");
         String nombreMateria = scanner.nextLine();
         
         System.out.println("Seleccione un profesor:");
         for (int i = 0; i < profesores.size(); i++) {
             System.out.println((i + 1) + ". " + profesores.get(i).getNombre());
         }
         int profesorIndex = scanner.nextInt() - 1;
         scanner.nextLine();
 
         System.out.println("Seleccione un salón:");
         for (int i = 0; i < salones.size(); i++) {
             System.out.println((i + 1) + ". " + salones.get(i).getNombre());
         }
         int salonIndex = scanner.nextInt() - 1;
         scanner.nextLine();
 
         materias.add(new Materia(nombreMateria, profesores.get(profesorIndex), salones.get(salonIndex)));
         System.out.println("Materia agregada exitosamente.");
     }
 
     // Muestra las materias registradas con su información
     private static void mostrarMaterias() {
         if (materias.isEmpty()) {
             System.out.println("No hay materias registradas.");
             return;
         }
 
         System.out.println("Materias Registradas:");
         for (Materia materia : materias) {
             System.out.println("Materia: " + materia.getNombre());
             System.out.println("Profesor: " + materia.getProfesor().getNombre() + " | Edad: " + materia.getProfesor().getEdad() + " | Clave: " + materia.getProfesor().getClave());
             System.out.println("Salón: " + materia.getSalon().getNombre() + " | Edificio: " + materia.getSalon().getEdificio());
             System.out.println("----------------------------");
         }
     }
 }
 