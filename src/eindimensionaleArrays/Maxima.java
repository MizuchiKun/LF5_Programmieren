package eindimensionaleArrays;

import utils.UserInput;

public class Maxima {
    public static void main(String[] args) {
        System.out.println("Bitte geb ein Array von floats ein.");
        float[] numbers = UserInput.readArray(float.class,
                                              "Wie viele Werte? ",
                                              "Wert %d eingeben: ");

        float largest = Float.NEGATIVE_INFINITY;
        float secondLargest = Float.NEGATIVE_INFINITY;
        for (float number : numbers) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            }
        }

        System.out.printf("Größte Zahl: %.2f\n", largest);
        System.out.printf("Zweitgrößte Zahl: %.2f\n", secondLargest);
    }
}
