package spielwiese;

import utils.UserInput;

import java.util.function.Predicate;

public class Zahlraten {
    /** Asks the user to choose a number, then tries to guess it by asking the user. */
    private static void guessUserNumber() {
        System.out.println("Such dir eine Zahl zwischen 1 und 100 aus!");

        byte min = 1, max = 100;
        byte guess = 0;
        boolean guessedRight = false;
        byte guessCount = 0;
        do {
            byte rangeWidth = (byte)(max - min);
            guess = (byte)(min + rangeWidth / 2);
            guessCount++;
            if (rangeWidth == 0) {
                break;
            }

            Predicate<String> startsWithJKG = (String str) -> str.toLowerCase().matches("^[jkg].*");
            char feedback = UserInput.readString(String.format("Ist deine Zahl %d, oder ist sie kleiner/größer (j/k/g)?", guess),
                                                 startsWithJKG,
                                                 "(ja/kleiner/größer?)\n").charAt(0);
            guessedRight = feedback == 'j';
            if (!guessedRight) {
                boolean guessTooSmall = feedback == 'g';
                if (guessTooSmall) {
                    min = (byte)(guess + 1);
                } else {
                    max = (byte)(guess - 1);
                }
            }
        } while (!guessedRight);

        System.out.printf("Zahl in %d Versuchen erraten! Sie war %d!\n", guessCount, guess);
    }

    public static void main(String[] args) {
        guessUserNumber();
    }
}
