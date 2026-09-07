package verzweigungen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Notenberechnung {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Wie viele Punkte können erreicht werden? ");
        float maxPoints = Float.parseFloat(reader.readLine().trim());
        System.out.print("Wie viele Punkte hast du erreicht? ");
        float earnedPoints = Float.parseFloat(reader.readLine().trim());

        final float MARK_1_REQUIREMENT = 0.92f;
        final float MARK_2_REQUIREMENT = 0.81f;
        final float MARK_3_REQUIREMENT = 0.67f;
        final float MARK_4_REQUIREMENT = 0.50f;
        final float MARK_5_REQUIREMENT = 0.30f;
        float markPercentage = earnedPoints / maxPoints;
        float mark = 0f;
        if (markPercentage >= MARK_1_REQUIREMENT)
        {
            mark = 1f;
        }
        else if (markPercentage >= MARK_2_REQUIREMENT)
        {
            mark = 2f;
        }
        else if (markPercentage >= MARK_3_REQUIREMENT)
        {
            mark = 3f;
        }
        else if (markPercentage >= MARK_4_REQUIREMENT)
        {
            mark = 4f;
        }
        else if (markPercentage >= MARK_5_REQUIREMENT)
        {
            mark = 5f;
        }
        else
        {
            mark = 6f;
        }

        final DecimalFormat germanPercentageFormat = new DecimalFormat("#,##0.00%",
                                                                       new DecimalFormatSymbols(Locale.GERMAN));

        System.out.printf("Du hast %s und damit die Note %.0f erreicht.\n", germanPercentageFormat.format(markPercentage), mark);

        if (markPercentage > 1f)
        {
            System.out.println("Fehler: Erreichte Punktzahl ist höher als maximale Punktzahl!");
            System.out.println("(Was bist du denn für'n Streber??)");
        }
    }
}
