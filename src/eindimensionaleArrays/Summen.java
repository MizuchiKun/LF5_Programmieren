package eindimensionaleArrays;

import utils.UserInput;

public class Summen {
    public static void main(String[] args) {
        System.out.println("Bitte geb ein Array von ints ein.");
        short[] numbers = UserInput.readArray(byte.class,
                                              "Wie viele Werte? ",
                                              "Wert %d eingeben: ");

        byte evenCount = 0;
        short evenSum = 0;
        byte oddCount = 0;
        short oddSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
                evenCount++;
            } else {
                oddSum += numbers[i];
                oddCount++;
            }
        }

        System.out.println("Gerade Zahlen: ");
        System.out.printf("Anzahl = %d\n", evenCount);
        System.out.printf("Summe  = %d\n", evenSum);
        System.out.println("Ungerade Zahlen: ");
        System.out.printf("Anzahl = %d\n", oddCount);
        System.out.printf("Summe  = %d\n", oddSum);
    }
}
