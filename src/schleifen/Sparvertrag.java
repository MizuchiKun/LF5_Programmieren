package schleifen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sparvertrag {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean doRestartCalculation = false;
        do
        {
            System.out.print("Bitte Kapital eingeben: ");
            float capital = Float.parseFloat(reader.readLine().trim());
            System.out.print("Bitte den (jährlichen) Zinssatz eingeben (%): ");
            float interestRateYearly = Float.parseFloat(reader.readLine().trim()) / 100f;
            System.out.print("Bitte die Laufzeit in Jahren eingeben: ");
            float durationInYears = Float.parseFloat(reader.readLine().trim());

            System.out.println("\nJahr\tAnfangskapital\tZinsbetrag\tJahresendbetrag");
            for (int year = 1; year <= durationInYears; year++)
            {
                float interest = interestRateYearly * capital;
                float newCapital = capital + interest;
                System.out.printf("%d\t\t%.2f\t\t\t%.2f\t\t%.2f\n", year, capital, interest, newCapital);
                capital = newCapital;
            }

            System.out.print("\nWeiteren Sparvertrag berechnen(y/n)? ");
            String restartInput = reader.readLine().trim().toLowerCase();
            doRestartCalculation = !restartInput.isEmpty() && restartInput.charAt(0) == 'y';
        } while (doRestartCalculation);
    }
}
