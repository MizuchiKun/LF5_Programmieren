package aufgabenMitEingabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Rechner {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Erste Zahl??");
        double firstNumber = Double.parseDouble(reader.readLine().trim());
        System.out.println("Zweite Zahl??");
        double secondNumber = Double.parseDouble(reader.readLine().trim());

        double sum = firstNumber + secondNumber;
        double difference = firstNumber - secondNumber;
        double product = firstNumber * secondNumber;
        double quotient = firstNumber / secondNumber;
        double power = Math.pow(firstNumber, secondNumber);

        System.out.println();
        System.out.printf("%.1f + %.1f = %.1f!\n", firstNumber, secondNumber, sum);
        System.out.printf("%.1f - %.1f = %.1f!\n", firstNumber, secondNumber, difference);
        System.out.printf("%.1f * %.1f = %.1f!\n", firstNumber, secondNumber, product);
        System.out.printf("%.1f / %.1f = %.1f!\n", firstNumber, secondNumber, quotient);
        System.out.printf("%.1f ** %.1f = %.1f!\n", firstNumber, secondNumber, power);
    }
}
