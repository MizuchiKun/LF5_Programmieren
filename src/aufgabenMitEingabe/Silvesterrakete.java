package aufgabenMitEingabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Silvesterrakete {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Time to impact? ");
        float timeToImpact = Float.parseFloat(reader.readLine().trim());

        final float GRAVITY = 9.81f;
        float impactVelocityMps = GRAVITY * timeToImpact;
        float impactVelocityKph = impactVelocityMps * 3.6f;

        final DecimalFormat germanFormat = new DecimalFormat("#,##0.00",
                                                                 new DecimalFormatSymbols(Locale.GERMAN));
        System.out.printf("%s m/s\n", germanFormat.format(impactVelocityMps));
        System.out.printf("%s km/h\n", germanFormat.format(impactVelocityKph));
    }
}
