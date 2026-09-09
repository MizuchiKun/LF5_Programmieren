package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class UserInput {
    private static BufferedReader reader;


    // How to write function for e.g. ReadString, ReadInt, etc. with a predicate parameter to check if entered
    // value meets criteria, while accounting for possible exceptions?
    // There could be e.g. NumberFormatExceptions in the predicate when trying to parse numbers.


    /** Reads a String from the user via. the console.
     *
     * @param prompt The input prompt message to show the user.
     * @param criteria The criteria for the entered user input.
     * @param errorMessage A message to be displayed to the user if their input did not meet the criteria.
     * @return The user input String.
     */
    public static String ReadString(String prompt, Predicate<String> criteria, String errorMessage)
    {
        initialise();

        // input should have an acceptable value after the loop but the error checker didn't think so, hence the null initialisation.
        // Better solution to this issue?
        String input = null;
        boolean inputMeetsCriteria = false;
        do
        {
            try
            {
                System.out.print(prompt);
                input = reader.readLine().trim();

                inputMeetsCriteria = criteria.test(input);
                if (!inputMeetsCriteria)
                {
                    System.out.print(errorMessage);
                }
            }
            catch (IOException e)
            {
                System.out.println("There was an IOException reading your input. Try again.");
            }
        } while (!inputMeetsCriteria);

        return input;
    }

    /** Reads a String from the user via. the console.
     *
     * @param prompt The input prompt message to show the user.
     * @return The user input String.
     */
    public static String ReadString (String prompt)
    {
        final Predicate<String> NO_CRITERIA = (String) -> true;
        return ReadString(prompt, NO_CRITERIA, "");
    }

    /** Initialises the BufferedReader. **/
    private static void initialise ()
    {
        if (reader == null)
        {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public static void main(String[] args) {
        ReadString("Gimme a String: ",
                   (String input) -> input.length() >= 5,
       "String must be at least 5 characters long.\n");
    }
}
