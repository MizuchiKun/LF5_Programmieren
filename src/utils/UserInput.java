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

    /** Returns the text ANSI-coloured. **/
    private static String colourText(String text, String ansiColour) {
        return String.format("%s%s%s", ansiColour, text, ANSI_RESET);
    }

    //region Generic base read method.
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

    /** Reads a value from the user via console.<br/>
     *  <br/>
     *  Supported types: All the primitives and String.
     *
     * @param type The type to which the input will be parsed.
     * @param prompt The prompt to show to the user.
     * @param criteria The criteria by which to check the input. E.g. numerical range.
     * @param criteriaErrorMessage The error message to show when the criteria were not met.
     * @return An object of generic type T, which contains the user's input.
     * @param <T> The generic type of which to read a value from the user.
     */
    private static <T> T readValue(Class<T> type,
                                   String prompt,
                                   Predicate<T> criteria,
                                   String criteriaErrorMessage) {
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
                                                    : "The input must be a " + type.getSimpleName(),
                                            ERROR_COLOUR));
            }
        }
    }

    /** Reads a value from the user via console.<br/>
     *  <br/>
     *  Supported types: All the primitives and String.
     *
     * @param type The type to which the input will be parsed.
     * @param prompt The prompt to show to the user.
     * @return An object of generic type T, which contains the user's input.
     * @param <T> The generic type of which to read a value from the user.
     */
    private static <T> T readValue(Class<T> type,
                                   String prompt) {
        return readValue(type,
                         prompt,
                         (T t) -> true,
                         "");
    }
    //endregion

    //region Text
    /** Reads a String from the user via the console.<br/>
     *  Input will be trimmed, and only accepted, once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param criteriaErrorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input String.
     */
    public static String readString(String prompt,
                                    Predicate<String> criteria,
                                    String criteriaErrorMessage) {
        return readValue(String.class,
                         prompt,
                         criteria,
                         criteriaErrorMessage);
    }

    /** Reads a String from the user via the console.<br/>
     *  Input will be trimmed.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input String.
     */
    public static String readString(String prompt) {
        return readValue(String.class,
                         prompt);
    }

    /** Reads a char from the user via the console.<br/>
     *  Input will be trimmed, and only accepted, once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param criteriaErrorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input char.
     */
    public static char readChar(String prompt,
                                Predicate<Character> criteria,
                                String criteriaErrorMessage) {
        return readValue(Character.class,
                         prompt,
                         criteria,
                         criteriaErrorMessage);
    }

    /** Reads a char from the user via the console.<br/>
     *  Input will be trimmed.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input char.
     */
    public static char readChar(String prompt) {
        return readValue(Character.class,
                         prompt);
    }
    //endregion

    //region Floats
    /** Reads a float from the user via console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param criteriaErrorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input float.
     */
    public static float readFloat(String prompt,
                                  Predicate<Float> criteria,
                                  String criteriaErrorMessage) {
        return readValue(Float.class,
                         prompt,
                         criteria,
                         criteriaErrorMessage);
    }

    /** Reads a float from the user via the console.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input float.
     */
    public static float readFloat(String prompt) {
        return readValue(Float.class,
                         prompt);
    }

    /** Reads a double from the user via console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param criteriaErrorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input double.
     */
    public static double readDouble(String prompt,
                                    Predicate<Double> criteria,
                                    String criteriaErrorMessage) {
        return readValue(Double.class,
                         prompt,
                         criteria,
                         criteriaErrorMessage);
    }

    /** Reads a double from the user via the console.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input double.
     */
    public static double readDouble(String prompt) {
        return readValue(Double.class,
                         prompt);
    }
    //endregion

    //region Integers
    /** Reads a byte from the user via console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param criteriaErrorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input byte.
     */
    public static byte readByte(String prompt,
                                Predicate<Byte> criteria,
                                String criteriaErrorMessage) {
        return readValue(Byte.class,
                         prompt,
                         criteria,
                         criteriaErrorMessage);
    }

    /** Reads a byte from the user via the console.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input byte.
     */
    public static byte readByte(String prompt) {
        return readValue(Byte.class,
                         prompt);
    }

    /** Reads a short from the user via console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param criteriaErrorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input short.
     */
    public static short readShort(String prompt,
                                  Predicate<Short> criteria,
                                  String criteriaErrorMessage) {
        return readValue(Short.class,
                         prompt,
                         criteria,
                         criteriaErrorMessage);
    }

    /** Reads a short from the user via the console.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input short.
     */
    public static short readShort(String prompt) {
        return readValue(Short.class,
                         prompt);
    }

    /** Reads an int from the user via console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param criteriaErrorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input int.
     */
    public static int readInt(String prompt,
                              Predicate<Integer> criteria,
                              String criteriaErrorMessage) {
        return readValue(Integer.class,
                         prompt,
                         criteria,
                         criteriaErrorMessage);
    }

    /** Reads an int from the user via the console.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input int.
     */
    public static int readInt(String prompt) {
        return readValue(Integer.class,
                         prompt);
    }

    /** Reads a long from the user via console.<br/>
     *  Input will only be accepted once it meets the criteria.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param criteriaErrorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input long.
     */
    public static long readLong(String prompt,
                                Predicate<Long> criteria,
                                String criteriaErrorMessage) {
        return readValue(Long.class,
                         prompt,
                         criteria,
                         criteriaErrorMessage);
    }

    /** Reads a long from the user via the console.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input long.
     */
    public static long readLong(String prompt) {
        return readValue(Long.class,
                         prompt);
    }
    //endregion

    //region Booleans
    /** Reads a boolean from the user via the console.
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

    /** Reads a boolean from the user via the console.<br/>
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
