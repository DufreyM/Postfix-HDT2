import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                CustomStack<Double> stack = new CustomStack<>();
                CalculatorInterface calculator = new Calculator();

                try {
                    int result = calculator.evaluatePostfix(line);
                    System.out.println("Resultado: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error en la expresión: " + e.getMessage());
                }
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo 'datos.txt' no encontrado. Verifica la ubicación del archivo.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo.");
            e.printStackTrace();
        }
    }
}
