package verzweigungen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Bestellung {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Wie viele Schrauben? ");
        int amountScrews = Integer.parseInt(reader.readLine().trim());
        System.out.print("Wie viele Muttern? ");
        int amountNuts = Integer.parseInt(reader.readLine().trim());
        System.out.print("Wie viele Unterlegscheiben? ");
        int amountWashers = Integer.parseInt(reader.readLine().trim());

        final float PRICE_SCREWS = 0.05f;
        final float PRICE_NUTS   = 0.03f;
        final float PRICE_WASHERS = 0.01f;
        float totalPrice = amountScrews * PRICE_SCREWS + amountNuts * PRICE_NUTS + amountWashers * PRICE_WASHERS;
        boolean orderOk = amountScrews == amountNuts;

        final DecimalFormat germanEuroFormat = new DecimalFormat("#,##0.00 €",
                                                                 new DecimalFormatSymbols(Locale.GERMAN));
        System.out.printf("Gesamtbetrag der Bestellung: %s\n", germanEuroFormat.format(totalPrice));
        if (orderOk)
        {
            System.out.println("Ihre Bestellung ist in Ordnung und wurde aufgegeben.");
        }
        else
        {
            System.out.println("Sie müssen die gleiche Anzahl von Schrauben und Muttern bestellen! Bearbeiten Sie Ihre Bestellung.");
        }
    }
}
