package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class UserInput {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    private static final Predicate<String> NO_CRITERIA_STRING = (String) -> true;
    private static final Predicate<Double> NO_CRITERIA_DOUBLE = (Double) -> true;
    private static final Predicate<Long> NO_CRITERIA_LONG = (Double) -> true;

    //region String
    /** Reads a String from the user via. the console.<br/>
     *  Input will be trimmed, and only accepted, once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param errorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input String.
     */
    public static String readString(String prompt,
                                    Predicate<String> criteria,
                                    String errorMessage) {
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
        return readString(prompt, NO_CRITERIA_STRING, "");
    }
    //endregion

    //region Floats
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
                System.out.print(!errorMessage.isEmpty()
                                 ? errorMessage
                                 : "(Input must be a floating-point number!)");
            }
        } while (!inputMeetsCriteria);

        return inputDouble;
    }

    /** Reads a double from the user via. the console.<br/>
     *  Input will be trimmed.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input double.
     */
    public static double readDouble(String prompt) {
        return readDouble(prompt, NO_CRITERIA_DOUBLE, "");
    }

    /** Reads a float from the user via. console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param errorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input float.
     */
    public static float readFloat(String prompt,
                                  Predicate<Double> criteria,
                                  String errorMessage) {
        return (float)readDouble(prompt, criteria, errorMessage);
    }

    /** Reads a float from the user via. the console.<br/>
     *  Input will be trimmed.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input float.
     */
    public static float readFloat(String prompt) {
        return readFloat(prompt, NO_CRITERIA_DOUBLE, "");
    }
    //endregion

    //region Integers
    /** Reads a long from the user via. console.<br/>
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
                System.out.print(!errorMessage.isEmpty()
                                 ? errorMessage
                                 : "(Input must be an integer!)");
            }
        } while (!inputMeetsCriteria);

        return inputLong;
    }

    /** Reads a long from the user via. the console.<br/>
     *  Input will be trimmed.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input long.
     */
    public static long readLong(String prompt) {
        return readLong(prompt, NO_CRITERIA_LONG, "");
    }

    /** Reads an int from the user via. console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param errorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input int.
     */
    public static int readInt(String prompt,
                              Predicate<Long> criteria,
                              String errorMessage) {
        return (int)readLong(prompt, criteria, errorMessage);
    }

    /** Reads an int from the user via. the console.<br/>
     *  Input will be trimmed.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input int.
     */
    public static int readInt(String prompt) {
        return readInt(prompt, NO_CRITERIA_LONG, "");
    }

    /** Reads a short from the user via. console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param errorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input short.
     */
    public static short readShort(String prompt,
                                  Predicate<Long> criteria,
                                  String errorMessage) {
        return (short)readLong(prompt, criteria, errorMessage);
    }

    /** Reads a short from the user via. the console.<br/>
     *  Input will be trimmed.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input short.
     */
    public static short readShort(String prompt) {
        return readShort(prompt, NO_CRITERIA_LONG, "");
    }

    /** Reads a byte from the user via. console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param errorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input byte.
     */
    public static byte readByte(String prompt,
                                Predicate<Long> criteria,
                                String errorMessage) {
        return (byte)readLong(prompt, criteria, errorMessage);
    }

    /** Reads a byte from the user via. the console.<br/>
     *  Input will be trimmed.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input byte.
     */
    public static byte readByte(String prompt) {
        return readByte(prompt, NO_CRITERIA_LONG, "");
    }
    //endregion
}
