package eindimensionaleArrays;

import utils.UserInput;

import java.util.Arrays;

public class Duplikate {
    public static void main(String[] args) {
        short[] inputs = UserInput.readArray(short.class,
                                            "Wie viele Elemente soll das Array enthalten? ",
                                            "Wert %d eingeben: ");

        short[] uniques = new short[inputs.length];
        byte uniqueCount = 0;
        for (short input : inputs) {
            boolean valueInUniques = false;
            for (byte i = 0; i < uniqueCount; i++) {
                if (input == uniques[i]) {
                    valueInUniques = true;
                    break;
                }
            }

            if (!valueInUniques) {
                uniques[uniqueCount++] = input;
            }
        }
        uniques = Arrays.copyOf(uniques, uniqueCount);

        System.out.println("Alle Werte ohne Duplikate:");
        for (short unique : uniques) {
            System.out.printf("%d\t", unique);
        }
        System.out.println();
    }
}
