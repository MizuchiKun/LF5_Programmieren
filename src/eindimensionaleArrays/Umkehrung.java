package eindimensionaleArrays;

import utils.UserInput;

public class Umkehrung {
    public static void main(String[] args) {
        byte CHAR_COUNT = UserInput.readByte("Wie viele Buchstaben soll das Array enthalten? ",
                                             (Long l) -> l > 0,
                                             "Anzahl muss >0 sein!");
        char[] inputChars = new char[CHAR_COUNT];
        for (byte i = 0; i < CHAR_COUNT; i++) {
            inputChars[i] = UserInput.readString(String.format("Buchstaben %d eingeben: ",
                                                               i+1)).charAt(0);
        }

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
