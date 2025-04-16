import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Solicitar al usuario que ingrese dos números
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();
            
            // Solicitar la operación aritmética
            System.out.print("Ingrese la operación (+, -, *, /): ");
            String operacion = scanner.next();
            
            double resultado;
            
            // Realizar la operación usando switch
            switch (operacion) {
                case "+":
                    resultado = num1 + num2;
                    System.out.println("Resultado: " + resultado);
                    break;
                case "-":
                    resultado = num1 - num2;
                    System.out.println("Resultado: " + resultado);
                    break;
                case "*":
                    resultado = num1 * num2;
                    System.out.println("Resultado: " + resultado);
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("División por cero no permitida");
                    }
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + resultado);
                    break;
                default:
                    throw new IllegalArgumentException("Operación no válida: " + operacion);
            }
            
        } catch (InputMismatchException e) {
            System.err.println("Error: Debes ingresar números válidos");
        } catch (ArithmeticException e) {
            System.err.println("Error aritmético: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            // Cerrar el scanner en el bloque finally
            scanner.close();
            System.out.println("Scanner cerrado correctamente.");
        }
    }
}