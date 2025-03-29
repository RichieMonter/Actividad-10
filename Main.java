import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nombre;
    private int edad;
    private String email;

    public Usuario(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                '}';
    }
}

class ProcesadorDatos {
    public List<Usuario> procesarDatos(String rutaArchivo) {
        List<Usuario> usuarios = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            // Saltar la línea de encabezado
            br.readLine();

            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    String[] datos = linea.split(",");
                    String nombre = datos[0].trim();
                    int edad = Integer.parseInt(datos[1].trim());
                    String email = datos[2].trim();
                    
                    usuarios.add(new Usuario(nombre, edad, email));
                } catch (Exception e) {
                    System.err.println("Error procesando línea: " + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }

        return usuarios;
    }
}

public class Main {
    public static void main(String[] args) {
        ProcesadorDatos procesador = new ProcesadorDatos();
        List<Usuario> usuarios = procesador.procesarDatos("datos_usuario.txt");
        
        System.out.println("Usuarios procesados:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
