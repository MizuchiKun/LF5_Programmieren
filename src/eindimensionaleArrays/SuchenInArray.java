package eindimensionaleArrays;

import utils.*;

public class SuchenInArray {
    public static void main(String[] args) {
        System.out.println("Bitte geb ein Array von 5 floats ein.");
        float[] numbers = UserInput.readArray(float.class, (byte)5, "Wert %d eingeben: ");

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
