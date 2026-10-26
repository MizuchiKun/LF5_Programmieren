package eindimensionaleArrays;

import utils.UserInput;

public class Umkehrung {
    public static void main(String[] args) {
        char[] inputChars = UserInput.readArray(Character.class,
                                                "Wie viele Buchstaben soll das Array enthalten? ",
                                                "Buchstaben %d eingeben: ");

        char[] reversedInput = new char[inputChars.length];
        for (byte i = 0; i < inputChars.length; i++) {
            reversedInput[reversedInput.length - 1 - i] = inputChars[i];
        }

        System.out.println("Umgedrehtes Array: ");
        var outputString = new StringBuilder();
        for (char c : reversedInput) { outputString.append(c).append('\t'); }
        System.out.println(outputString);
    }
}
