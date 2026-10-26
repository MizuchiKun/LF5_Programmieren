package eindimensionaleArrays;

import utils.UserInput;

public class Tonsignal {
    public static void main() {
        System.out.println("Enter your weird audio signal array.");
        short[] input = UserInput.readArray(short.class,
                                            "How many values? ",
                                            "Enter value %d: ");

        short[] smoothed = new short[input.length];
        for (byte i = 0; i < smoothed.length; i++) {
            if (i == 0) {
                smoothed[i] = (short)((input[i] + input[i+1]) / 2);
            } else if (i == smoothed.length - 1) {
                smoothed[i] = (short)((input[i] + input[i-1]) / 2);
            } else {
                smoothed[i] = (short)((input[i-1] + input[i] + input[i+1]) / 3);
            }
        }

        System.out.println("Original signal: ");
        for (short value : input) System.out.printf("%d\t", value);
        System.out.println();
        System.out.println("Smoothed signal: ");
        for (short value : smoothed) System.out.printf("%d\t", value);
        System.out.println();
    }
}
