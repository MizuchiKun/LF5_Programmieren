package eindimensionaleArrays;

import utils.UserInput;

public class Maxima {
    public static void main(String[] args) {
        System.out.println("Bitte geb ein Array von floats ein.");
        final byte LENGTH = UserInput.readByte("Wie viele Werte? ",
                                               (Long l) -> l > 0,
                                               "Länge muss größer als 0 sein!\n");

        float[] numbers = new float[LENGTH];
        float largest = 0;
        float secondLargest = 0;
        for (int i = 0; i < numbers.length; i++) {
            float input = UserInput.readFloat(String.format("Wert %d eingeben: ", i+1));
            numbers[i] = input;

            if (input > largest) {
                secondLargest = largest;
                largest = input;
            }
        }

        System.out.printf("Größte Zahl: %.2f\n", largest);
        System.out.printf("Zweitgrößte Zahl: %.2f\n", secondLargest);
    }
}
