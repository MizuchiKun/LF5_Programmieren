package schleifen;

import utils.UserInput;

public class Bevoelkerung {
    /** Reads user input and prints a table of projected population growth based on input. */
    private static void predictPopulationGrowth() {
        boolean doRestartCalculation = false;
        do {
            float initialPopulation = UserInput.readFloat("Bitte die aktuelle Populationsgröße in Milliarden eingeben: ",
                                                          (Double input) -> input > 0,
                                                          "Population muss >0 sein!\n");
            float growthRateYearly = UserInput.readFloat("Bitte den jährlichen Zuwachs in Prozent eingeben: ")
                    / 100f;
            short durationInYears = UserInput.readShort("Bitte die Laufzeit der Prognose in Jahren eingeben: ",
                                                        (Long input) -> input > 0,
                                                        "Laufzeit muss >0 sein!\n");
            byte floatDigits = UserInput.readByte("Bitte die Anzahl der anzuzeigenden Nachkommastellen eingeben: ",
                                                  (Long input) -> input >= 0,
                                                  "Nachkommastellen müssen >= 0 sein!\n");

            System.out.println("\nJahr\tAnfangspopulation\tZuwachs\t\tEndpopulation");
            float population = initialPopulation;
            for (int year = 1; year <= durationInYears; year++) {
                float growth = growthRateYearly * population;
                float newPopulation = population + growth;
                String rowFormatString = String.format("%%d\t\t%s\t\t\t\t%<s\t\t%<s%%s\n",
                                                       "%." + floatDigits + "f");
                System.out.printf(rowFormatString,
                                  year,
                                  population,
                                  growth,
                                  newPopulation,
                                  newPopulation >= 1.2 * initialPopulation ? " *" : "");
                population = newPopulation;
            }

            doRestartCalculation = UserInput.readBoolean("\nWeitere Bevölkerungsprognose berechnen? ");
        } while (doRestartCalculation);
    }

    public static void main(String[] args)  {
        predictPopulationGrowth();
    }
}
