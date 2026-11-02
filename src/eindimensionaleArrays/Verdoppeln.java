package eindimensionaleArrays;

import utils.UserInput;

public class Verdoppeln {
    /** Prints the given array in a single line in the format "{ a, b, c, d, ... }". <br/>
     *  (Uses float format %.2f.)
     *
     * @param array The array to be printed.
     */
    private static void printArray(float[] array) {
        StringBuilder builder = new StringBuilder("{ ");
        for (int i = 0; i < array.length; i++) {
            builder.append(String.format("%.2f", array[i]));
            if (i != array.length - 1) { builder.append(", "); }
        }
        builder.append(" }");

        System.out.println(builder);
    }

    public static void main(String[] args) {
        System.out.println("Bitte geb ein Array von floats ein.");
        float[] numbers = UserInput.readArray(float.class,
                                              "Wie viele Werte? ",
                                              "Wert %d eingeben: ");

        float[] doubled = new float[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            doubled[i] = 2 * numbers[i];
        }

        System.out.println("Ursprüngliches Array: ");
        printArray(numbers);
        System.out.println("Verdoppeltes Array: ");
        printArray(doubled);
    }
}
