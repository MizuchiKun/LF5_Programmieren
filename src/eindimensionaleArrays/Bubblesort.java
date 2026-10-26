package eindimensionaleArrays;

import utils.UserInput;

public class Bubblesort {
    public static void main() {
        System.out.println("Enter an array to sort.");
        float[] input = UserInput.readArray(float.class,
                                            "How many values? ",
                                            "Enter value %d: ");

        float[] sorted = input.clone();
        boolean arraySorted = false;
        while (!arraySorted) {
            arraySorted = true; // Assume it's sorted.
            for (byte i = 0; i < input.length - 1; i++) {
                boolean elementsSorted = (sorted[i] < sorted[i+1]);
                if (!elementsSorted) {
                    arraySorted = false;

                    float temp = sorted[i];
                    sorted[i] = sorted[i+1];
                    sorted[i+1] = temp;
                }
            }
        }

        System.out.println("The original array: ");
        for (float value : input) System.out.printf("%.2f\t", value);
        System.out.println();
        System.out.println("The sorted array: ");
        for (float value : sorted) System.out.printf("%.2f\t", value);
        System.out.println();
    }
}
