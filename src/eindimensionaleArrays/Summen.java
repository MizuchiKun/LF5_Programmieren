package eindimensionaleArrays;

import utils.UserInput;

public class Summen {
    public static void main(String[] args) {
        System.out.println("Bitte geb ein Array von ints ein.");
        final byte LENGTH = UserInput.readByte("Wie viele Werte? ",
                                               (Long l) -> l > 0,
                                               "Länge muss größer als 0 sein!\n");

        short[] numbers = new short[LENGTH];
        byte evenCount = 0;
        short evenSum = 0;
        byte oddCount = 0;
        short oddSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            short input = UserInput.readShort(String.format("Wert %d eingeben: ", i+1));
            numbers[i] = input;

            if (input % 2 == 0) {
                evenSum += input;
                evenCount++;
            } else {
                oddSum += input;
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
