package eindimensionaleArrays;

import utils.*;

public class SuchenInArray {
    public static void main(String[] args) {
        System.out.println("Bitte geb ein Array von 5 floats ein.");

        float[] numbers = new float[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = UserInput.readFloat(String.format("Wert %d eingeben: ", i+1));
        }

        float searchValue = UserInput.readFloat("Nach welcher Zahl willst du suchen? ");
        for (float value: numbers) {
            if (Comparison.doublesAreClose(value, searchValue)) {
                System.out.println("Treffer");
            } else {
                System.out.println("Niete");
            }
        }
    }
}
