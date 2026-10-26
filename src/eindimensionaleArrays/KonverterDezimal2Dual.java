package eindimensionaleArrays;

import utils.UserInput;

public class KonverterDezimal2Dual {
    private static String dec2Bin(short decimal) {
        var binary = new StringBuilder();
        while (decimal != 0) {
            byte remainder = (byte)(decimal % 2);
            decimal = (byte)(decimal / 2);
            binary.append(remainder);
        }
        return binary.reverse().toString();
    }

    public static void main() {
        short input = UserInput.readShort("Gimme a decimal number: ");

        String binary = dec2Bin(input);

        System.out.printf("In binary:\n%s\n", binary);
    }
}
