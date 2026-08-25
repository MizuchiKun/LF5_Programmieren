package aufgabenMitEingabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zeugnis {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("LF 1 Note? ");
        float lf1Mark = Float.parseFloat(reader.readLine().trim());
        System.out.print("LF 2 Note? ");
        float lf2Mark = Float.parseFloat(reader.readLine().trim());
        System.out.print("LF 3 Note? ");
        float lf3Mark = Float.parseFloat(reader.readLine().trim());
        System.out.print("LF 4 Note? ");
        float lf4Mark = Float.parseFloat(reader.readLine().trim());
        System.out.print("LF 5 Note? ");
        float lf5Mark = Float.parseFloat(reader.readLine().trim());

        float averageMark = (lf1Mark + lf2Mark + lf3Mark + lf4Mark + lf5Mark) / 5f;
        System.out.printf("Durchschnittsnote = %.2f\n", averageMark);
    }
}
