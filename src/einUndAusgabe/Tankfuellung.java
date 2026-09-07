package einUndAusgabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Tankfuellung {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Getankte Liter: ");
        float litres = Float.parseFloat(reader.readLine().trim());
        System.out.print("Nettopreis pro Liter: ");
        float pricePerLitre = Float.parseFloat(reader.readLine().trim());
        float netPrice = litres * pricePerLitre;

        final DecimalFormat germanEuroFormat = new DecimalFormat("#,##0.00 €",
                                                                 new DecimalFormatSymbols(Locale.GERMAN));
        final float TAX_RATE = 0.19f;
        float taxAmount = TAX_RATE * netPrice;
        float grossPrice = netPrice + taxAmount;
        System.out.printf("Nettobetrag: %s\n", germanEuroFormat.format(netPrice));
        System.out.printf("Mehrwertsteuer: %s\n", germanEuroFormat.format(taxAmount));
        System.out.printf("Bruttobetrag: %s\n", germanEuroFormat.format(grossPrice));
    }
}
