package eindimensionaleArrays;

import utils.UserInput;

import java.util.Arrays;

public class GemeinsameElemente {
    private static boolean valueInArray(short value, short[] array, byte endIndex) {
        if (!(0 <= endIndex && endIndex <= array.length)) {
            throw new IllegalArgumentException("endIndex out of range!");
        }

        for (byte i = 0; i < endIndex; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final byte LENGTH = UserInput.readByte("Wie viele Elemente sollen die Arrays enthalten? ",
                                               l -> l > 0,
                                               "Länge muss größer als 0 sein!\n");
        System.out.println("Eingabe des ersten Arrays:");
        short[] array1 = UserInput.readArray(short.class, LENGTH, "Wert %d eingeben: ");
        System.out.println("Eingabe des zweiten Arrays:");
        short[] array2 = UserInput.readArray(short.class, LENGTH, "Wert %d eingeben: ");

        short[] intersection = new short[array1.length];
        byte intersectCount = 0;
        for (short value1 : array1) {
            if (valueInArray(value1, intersection, intersectCount)) {
                continue;
            }

            for (short value2 : array2) {
                if (value1 == value2) {
                    intersection[intersectCount++] = value1;
                    break;
                }
            }
        }
        intersection = Arrays.copyOf(intersection, intersectCount);

        System.out.println("Alle gemeinsamen Werte:");
        for (short value : intersection) {
            System.out.printf("%d\t", value);
        }
    }
}
