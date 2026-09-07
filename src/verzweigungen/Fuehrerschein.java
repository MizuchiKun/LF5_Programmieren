package verzweigungen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fuehrerschein {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Alter? ");
        int age = Integer.parseInt(reader.readLine().trim());

        final int AGE_REQUIREMENT_50er = 14;
        final int AGE_REQUIREMENT_125er = 16;
        final int AGE_REQUIREMENT_CAR = 18;
        if (age >= AGE_REQUIREMENT_CAR)
        {
            System.out.println("Du darfst jetzt auch Auto fahren.");
        }
        else if (age >= AGE_REQUIREMENT_125er)
        {
            System.out.println("Du darfst schon 125er fahren, aber noch kein Auto.");
        }
        else if (age >= AGE_REQUIREMENT_50er)
        {
            System.out.println("Du darfst schon 50er fahren.");
        }
        else
        {
            System.out.println("Du darfst Bobby-Car oder Fahrrad fahren.");
        }
    }
}
