package verzweigungen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alterspruefung {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Wie alt bist du?? ");
        int age = Integer.parseInt(reader.readLine().trim());

        final int LEGAL_AGE = 18;
        if (age >= LEGAL_AGE)
        {
            System.out.println("Volljährig!!");
        }
        else
        {
            System.out.println("Minderjährig!!");
        }
    }
}
