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
                CalculatorInterface calculator = new Calculator();

                try {
                    int result = calculator.evaluatePostfix(line);
                    System.out.println("Result: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error: File 'data.txt' not found. Check the file location.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("File reading error.");
            e.printStackTrace();
        }
    }
}
