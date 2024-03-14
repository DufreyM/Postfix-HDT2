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
                Calculatorinterface calculator = new Calculator();
                Calculatorinterface calculator2 = new CalculatorPostfix();

                try {
                    int result = calculator.evaluatePostfix(line);

                    System.out.println("Resultado: " + result);
                    int result2 = calculator2.evaluatePostfix(line);
                    System.out.println("Resultado (pareja): " + result2);
                    System.out.println("Result: " + result);

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            br.close();

        } catch (FileNotFoundException e) {
            //Maneja errores con el archivo tipo .txt
            System.err.println("Error: File 'data.txt' not found. Check the file location.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("File reading error.");
            e.printStackTrace();
        }

        
    }
}
