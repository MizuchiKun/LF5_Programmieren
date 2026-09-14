package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class UserInput {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    // How to write function for e.g. readString, ReadInt, etc. with a predicate parameter to check if entered
    // value meets criteria, while accounting for possible exceptions?
    // There could be e.g. NumberFormatExceptions in the predicate when trying to parse numbers.
    // Maybe just catch any Exception and print an error message and/or repeat loop?
    // Though it seems I'll likely only encounter NumberFormatExceptions, when parsing numbers,
    // which I'll just do for the caller in to-be-done methods in this class, so . . .


    /** Reads a String from the user via. the console.<br/>
     *  Input will be trimmed, and only be accepted, once it meets the given criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param errorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input String.
     */
    public static String readString(String prompt,
                                    Predicate<String> criteria,
                                    String errorMessage) {
        // input should have an acceptable value after the loop but the error checker didn't think so, hence the null initialisation.
        // Better solution to this issue?
        String input = null;
        boolean inputMeetsCriteria = false;
        do {
            try {
                System.out.print(prompt);
                input = READER.readLine().trim();

                inputMeetsCriteria = criteria.test(input);
                if (!inputMeetsCriteria) {
                    System.out.print(errorMessage);
                }
            } catch (IOException e) {
                System.out.println("There was an IOException reading your input. Try again.");
            } catch (Exception e) {
                // Must mean something went wrong when testing criteria.
                System.out.printf("There's likely something wrong with the code (error: %s), but try again.\n",
                                  e.getClass().getSimpleName());
            }
        } while (!inputMeetsCriteria);

        return input;
    }

    /** Reads a String from the user via. the console.<br/>
     *  Input will be trimmed.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input String.
     */
    public static String readString(String prompt) {
        final Predicate<String> NO_CRITERIA = (String) -> true;
        return readString(prompt, NO_CRITERIA, "");
    }

    /** Reads a long/integer from the user via. console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param errorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input long.
     */
    public static long readLong(String prompt,
                                Predicate<Long> criteria,
                                String errorMessage) {
        long inputLong = -1;
        boolean inputMeetsCriteria = false;
        do {
            try {
                String inputString = readString(prompt);
                inputLong = Long.parseLong(inputString);

                inputMeetsCriteria = criteria.test(inputLong);
                if (!inputMeetsCriteria) {
                    System.out.print(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.print(errorMessage);
            }
        } while (!inputMeetsCriteria);

        return inputLong;
    }

    /** Reads a double from the user via. console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param errorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input double.
     */
    public static double readDouble(String prompt,
                                    Predicate<Double> criteria,
                                    String errorMessage) {
        double inputDouble = -1;
        boolean inputMeetsCriteria = false;
        do {
            try {
                String inputString = readString(prompt);
                inputDouble = Double.parseDouble(inputString);

                inputMeetsCriteria = criteria.test(inputDouble);
                if (!inputMeetsCriteria) {
                    System.out.print(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.print(errorMessage);
            }
        } while (!inputMeetsCriteria);

        return inputDouble;
    }

    /** Just does stuff for testing. **/
    public static void main(String[] args) {
        readDouble("Gimme a double >5.5: ",
                   (Double input) -> input > 5.5,
                   "(Double must be >5.5.)\n");
    }
}
