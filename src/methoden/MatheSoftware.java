package methoden;

import utils.UserInput;

import java.util.Arrays;
import java.util.function.Predicate;

public class MatheSoftware {
    private static void schreibeMenue() {
        System.out.println("""
            Folgende Rechenoperationen stehen zur Auswahl:
            [+] für Addition
            [-] für Subtraktion
            [*] für Multiplikation
            [/] für Division
            [p] für Potenzieren
            [w] für Wurzelziehen""");
    }

    /** Prompts for two operands and prints the result of the addition. */
    private static void addition() {
        float operand1 = UserInput.readFloat("Bitte gebe die erste Zahl ein: ");
        float operand2 = UserInput.readFloat("Bitte gebe die zweite Zahl ein: ");
        System.out.printf("%.2f + %.2f = %.2f\n", operand1, operand2, operand1 + operand2);
    }

    /** Prompts for two operands and prints the result of the subtraction. */
    private static void subtraction() {
        float operand1 = UserInput.readFloat("Bitte gebe die erste Zahl ein: ");
        float operand2 = UserInput.readFloat("Bitte gebe die zweite Zahl ein: ");
        System.out.printf("%.2f - %.2f = %.2f\n", operand1, operand2, operand1 - operand2);
    }

    /** Prompts for two operands and prints the result of the multiplication. */
    private static void multiplication() {
        float operand1 = UserInput.readFloat("Bitte gebe die erste Zahl ein: ");
        float operand2 = UserInput.readFloat("Bitte gebe die zweite Zahl ein: ");
        System.out.printf("%.2f * %.2f = %.2f\n", operand1, operand2, operand1 * operand2);
    }

    /** Prompts for two operands and prints the result of the division. */
    private static void division() {
        float operand1 = UserInput.readFloat("Bitte gebe die erste Zahl ein: ");
        float operand2 = UserInput.readFloat("Bitte gebe die zweite Zahl ein: ",
                                             (Double x) -> x != 0,
                                             "Nenner darf nicht 0 sein!\n");
        System.out.printf("%.2f / %.2f = %.2f\n", operand1, operand2, operand1 / operand2);
    }

    /** Prompts for two operands and prints the result of the exponentiation. */
    private static void exponentiation() {
        float operand1 = UserInput.readFloat("Bitte gebe die erste Zahl ein: ");
        float operand2 = UserInput.readFloat("Bitte gebe die zweite Zahl ein: ");
        System.out.printf("%.2f ^ %.2f = %.2f\n", operand1, operand2, Math.pow(operand1, operand2));
    }

    /** Prompts for one operand and prints the result of the square rooting. */
    private static void squareRooting() {
        float operand = UserInput.readFloat("Bitte gebe die Zahl ein: ",
                                            (Double x) -> x >= 0,
                                            "Radikand darf nicht negativ sein!\n");
        System.out.printf("√(%.2f) = %.2f\n", operand, Math.sqrt(operand));
    }

    public static void main(String[] args) {
        boolean repeatCalculation = false;
        do {
            schreibeMenue();
            Predicate<String> isSupportedOperation = (String str) ->
                                                     Arrays.asList(new String[]{"+", "-", "*", "/", "p", "w"}).contains(str);
            String operation = UserInput.readString("Deine Auswahl: ",
                                                    isSupportedOperation,
                                                    "Gebe eine der oben aufgeführten Optionen ein!\n");

            switch (operation) {
                case "+" -> addition();
                case "-" -> subtraction();
                case "*" -> multiplication();
                case "/" -> division();
                case "p" -> exponentiation();
                case "w" -> squareRooting();
                default ->  throw new IllegalArgumentException("Nicht unterstützte Operation ausgewählt!");
            };

            repeatCalculation = UserInput.readBoolean("Wollen Sie eine weitere Rechnung durchführen (j/n)? ");
            if (repeatCalculation) { System.out.println(); }
        } while (repeatCalculation);
    }

}
