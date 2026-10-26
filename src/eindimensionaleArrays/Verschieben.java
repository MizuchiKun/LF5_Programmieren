package eindimensionaleArrays;

import utils.UserInput;

import java.util.Arrays;

public class Verschieben {
    public static void main(String[] args) {
        float[] inputs = UserInput.readArray(float.class,
                                            "Wie viele Elemente soll das Array enthalten? ",
                                            "Wert %d eingeben: ");
        byte shiftRightAmount = UserInput.readByte("Um wie viele Stellen nach rechts verschieben (negativ -> links)? ",
                                                   s -> -inputs.length + 1 <= s && s <= inputs.length - 1,
                                                   String.format("Wert muss zwischen %d und %d sein (inklusive)!\n",
                                                                 -inputs.length + 1,
                                                                 +inputs.length - 1));

        float[] shifted = new float[inputs.length];
        byte k = 0;
        byte splitIndex = shiftRightAmount > 0
                          ? (byte)(inputs.length - shiftRightAmount)
                          : (byte)-shiftRightAmount;
        for (byte i = splitIndex; i < inputs.length; i++) {
            shifted[k++] = inputs[i];
        }
        for (byte i = 0; i < splitIndex; i++) {
            shifted[k++] = inputs[i];
        }

        System.out.println("Array mit den verschobenen Werten:");
        for (float value : shifted) {
            System.out.printf("%.1f\n", value);
        }
    }
}
