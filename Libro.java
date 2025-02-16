import java.util.ArrayList;
import java.util.List;

class Libro {
    private String titulo;
    private String autor;
    private String codigoBarras;
    private String genero;

    public Libro(String titulo, String autor, String codigoBarras, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigoBarras = codigoBarras;
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public static Libro buscarPorCodigo(List<Libro> libros, String codigoBarras) {
        for (Libro libro : libros) {
            if (libro.getCodigoBarras().equals(codigoBarras)) {  // Comparación corregida
                return libro;
            }
        }
        return null;
    }

    public static List<Libro> buscarPorGenero(List<Libro> libros, String genero) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public static void mostrarTodos(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro libro : libros) {
            System.out.println("\nTítulo: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Código de Barras: " + libro.getCodigoBarras());
            System.out.println("Género: " + libro.getGenero());
            System.out.println("---------------------------");
        }
    }
}

