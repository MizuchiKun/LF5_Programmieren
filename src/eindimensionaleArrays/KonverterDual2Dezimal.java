package eindimensionaleArrays;

import utils.UserInput;

public class KonverterDual2Dezimal {
    private static boolean isBinary(String input) {
        char[] inputArray = input.toCharArray();
        for (char c : inputArray) {
            switch (c) {
                case '0':
                case '1':
                case ' ':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private static long bin2Dec(String binary) {
        long decimal = 0;
        char[] bits = binary.toCharArray();
        for (byte i = 0; i < bits.length; i++) {
            if (bits[i] == '1') {
                byte exponent = (byte)(bits.length - 1 - i);
                decimal += Math.powExact(2, exponent);
            }
        }

        return decimal;
    }

    public static void main() {
        String input = UserInput.readString("Gimme a binary number: ",
                                            KonverterDual2Dezimal::isBinary,
                                            "Binary number must only contain 0, 1, and spaces!\n");
        input = input.replace(" ", "");

        long decimal = bin2Dec(input);

        System.out.printf("In decimal:\n%d\n", decimal);
    }
}
