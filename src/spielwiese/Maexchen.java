package spielwiese;

import utils.UserInput;

import java.util.function.Predicate;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Maexchen {
    public static void main(String[] args) {
        Predicate<Long> validRoll = (Long roll) -> 1 <= roll && roll <= 6;
        final String INVALID_ROLL_ERROR = "Augenzahl muss zwischen 1 und 6 sein.\n";
        byte roll1 = UserInput.readByte("Erste Augenzahl? ",
                                        validRoll,
                                        INVALID_ROLL_ERROR);
        byte roll2 = UserInput.readByte("Zweite Augenzahl? ",
                                        validRoll,
                                        INVALID_ROLL_ERROR);

        if ((roll1 == 1 && roll2 == 2) || (roll1 == 2 && roll2 == 1)) {
            System.out.println("Mäxchen! 1000 Punkte.");
        } else if (roll1 == roll2) {
            System.out.printf("Pasch! %d Punkte.\n", 100 * roll1);
        } else {
            System.out.printf("%d Punkte.\n", 10 * max(roll1, roll2) + min(roll1, roll2));
        }
    }
}
