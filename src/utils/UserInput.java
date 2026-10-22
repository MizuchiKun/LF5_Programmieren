package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.function.Predicate;

public class UserInput {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ERROR_COLOUR = ANSI_YELLOW;

    private static final Predicate<String> NO_CRITERIA_STRING = (String) -> true;
    private static final Predicate<Double> NO_CRITERIA_DOUBLE = (Double) -> true;
    private static final Predicate<Long> NO_CRITERIA_LONG = (Double) -> true;

    /** Returns the text ANSI-coloured. **/
    private static String colourText(String text, String ansiColour) {
        return String.format("%s%s%s", ansiColour, text, ANSI_RESET);
    }

    /** Parses the input to the given type.<br/>
     *  <br/>
     *  Supports: String, Character, Byte, Short, Integer, Long, Float, Double, Boolean.
     *
     * @param input The input string to parse.
     * @param type The type to parse input to.
     * @return A 'T' object parsed from input.
     * @param <T> The generic type to parse input to.
     * @throws IllegalArgumentException Passed generic type is not supported.
     */
    private static <T> T parseValue(String input, Class<T> type)
            throws IllegalArgumentException {
        Object result;
        if (type == String.class)          result = input;
        else if (type == Character.class)  result = input.charAt(0);
        else if (type == Byte.class)       result = Byte.parseByte(input);
        else if (type == Short.class)      result = Short.parseShort(input);
        else if (type == Integer.class)    result = Integer.parseInt(input);
        else if (type == Long.class)       result = Long.parseLong(input);
        else if (type == Float.class)      result = Float.parseFloat(input.replace(',', '.'));  // To support German format.
        else if (type == Double.class)     result = Double.parseDouble(input.replace(',', '.'));  // To support German format.
        else if (type == Boolean.class)    result = Boolean.parseBoolean(input);
        else throw new IllegalArgumentException("Unsupported input type: " + type);

        return type.cast(result);
    }

    /** Reads a value from the user via. console.<br/>
     *  <br/>
     *  Supported types: All the primitives and String.
     *
     * @param type The type to which the input will be parsed.
     * @param prompt The prompt to show to the user.
     * @param criteria The criteria by which to check the input. E.g. numerical range.
     * @param criteriaErrorMessage The error message to show when the criteria were not met.
     * @param parseErrorMessage The error message to show when there was a parsing error. <br/>
     *                          E.g. int expected but float supplied.
     * @return An object of generic type T, which contains the user's input.
     * @param <T> The generic type of which to read a value from the user.
     */
    private static <T> T readValue(Class<T> type,
                                   String prompt,
                                   Predicate<T> criteria,
                                   String criteriaErrorMessage,
                                   String parseErrorMessage) {
        //TODO: wrap this function in more explicitly named functions, as to make them more explicit in code
        while (true) {
            try {
                System.out.print(prompt);
                String input = READER.readLine().trim();

                T parsedInput = parseValue(input, type);

                boolean inputMeetsCriteria = criteria.test(parsedInput);
                if (inputMeetsCriteria) {
                    return parsedInput;
                }
                System.out.print(colourText(criteriaErrorMessage, ERROR_COLOUR));
            } catch (IOException e) {
                System.out.println("There was an IOException reading your input. Try again.");
            } catch (IllegalArgumentException e) {
                System.out.print(colourText(!criteriaErrorMessage.isEmpty()
                                            ? criteriaErrorMessage
                                            : parseErrorMessage,
                                 ERROR_COLOUR));
            }
        }
    }

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
                    System.out.print(colourText(errorMessage, ERROR_COLOUR));
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
                inputString = inputString.replace(',', '.'); // To support German separator.
                inputDouble = Double.parseDouble(inputString);

                inputMeetsCriteria = criteria.test(inputDouble);
                if (!inputMeetsCriteria) {
                    System.out.print(colourText(errorMessage, ERROR_COLOUR));
                }
            } catch (NumberFormatException e) {
                System.out.print(colourText(!errorMessage.isEmpty()
                                            ? errorMessage
                                            : "Input must be a floating-point number, without thousands separator!\n",
                                            ERROR_COLOUR));
            }
        } while (!inputMeetsCriteria);

        return inputDouble;
    }

    /** Reads a double from the user via. the console.
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

    /** Reads a float from the user via. the console.
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
                    System.out.print(colourText(errorMessage, ERROR_COLOUR));
                }
            } catch (NumberFormatException e) {

                System.out.print(colourText(!errorMessage.isEmpty()
                                            ? errorMessage
                                            : "Input must be an integer!\n",
                                            ERROR_COLOUR));
            }
        } while (!inputMeetsCriteria);

        return inputLong;
    }

    /** Reads a long from the user via. the console.
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

    /** Reads an int from the user via. the console.
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

    /** Reads a short from the user via. the console.
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

    /** Reads a byte from the user via. the console.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input byte.
     */
    public static byte readByte(String prompt) {
        return readByte(prompt, NO_CRITERIA_LONG, "");
    }
    //endregion

    //region Booleans
    /** Reads a boolean from the user via. the console.
     *
     * @param prompt The input prompt message to show the user.
     * @param trueInputs A list of lowercase inputs which are to be considered as the 'true' inputs.<br/>
     *                   Starting substrings are also considered to be true. E.g. "yes" also accepts "y".
     *                   Uppercase variants are also accepted.
     * @return The user input boolean.
     */
    public static boolean readBoolean(String prompt, String[] trueInputs) {
        String input = readString(prompt).toLowerCase();
        for (String trueInput : trueInputs) {
            if (input.startsWith(trueInput.substring(0, 1))) {
                return true;
            }
        }

        // Must mean none of trueInputs matched.
        return false;
    }

    /** Reads a boolean from the user via. the console.<br/>
     *  Accepts "yes", "true", and "ja" as 'true', as well as their starting substrings ("yes" -> "y").
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input boolean.
     */
    public static boolean readBoolean(String prompt) {
        final String[] DEFAULT_TRUE_INPUTS = {"yes", "true", "ja"};
        return readBoolean(prompt, DEFAULT_TRUE_INPUTS);
    }
    //endregion Booleans

    //region Arrays
//    public static <T> T[] readArray(Type dataType,
//                                      byte length,
//                                      String prompt,
//                                      Predicate<T> criteria,
//                                      String errorMessage) {
//        var array = new T[]{};
//        for (byte i = 0; i < length; i++) {
//
//        }
//    }
    //endregion
}
