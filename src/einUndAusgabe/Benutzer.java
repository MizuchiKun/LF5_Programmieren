package einUndAusgabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Benutzer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Wie ist dein Vorname?? ");
        String firstName = reader.readLine().trim();
        System.out.print("Wie ist dein Nachname?? ");
        String lastName = reader.readLine().trim();

        System.out.printf("Moin, %s %s!\n", firstName, lastName);
    }
}
