package zweidimensionaleArrays;

import utils.UserInput;

import java.time.temporal.TemporalQueries;

public class Sozialabgaben {
    /**
     * Creates a Sozialabgaben table.
     * @return The created table.
     */
    private static double[][] createTable() {
        final byte EMPLOYEE_COUNT = UserInput.readByte("Wie viele Mitarbeiter haben Sie? ",
                                                       b -> b > 0,
                                                       "Saal muss mindestens eine Reihe haben!\n");
        final byte COLUMN_COUNT = 5;

        double[][] table = new double[EMPLOYEE_COUNT][COLUMN_COUNT];
        for (byte employeeId = 0; employeeId < table.length; employeeId++) {
            for (byte col = 0; col < table[employeeId].length; col++) {
                table[employeeId][col] = 0;
            }
        }

        for (byte employeeId = 0; employeeId < table.length; employeeId++) {
            table[employeeId][0] = UserInput.readDouble(String.format("Wie viel verdient Mitarbeiter %d? ",
                                                                      employeeId+1),
                                                        d -> d >= 0,
                                                        "Gehalt darf nicht negativ sein!\n");
        }

        return table;
    }

    /**
     * Calculates the Sozialabgaben of the table's salaries.
     * @param table The table whose values to calculate.
     */
    private static void calculateTable(double[][] table) {
        final double KRANKENVERSICHERUNG_RATE = 7e-2;
        final double PFLEGEVERSICHERUNG_RATE = 1.525e-2;
        final double ARBEITSLOSENVERSICHERUNG_RATE = 1.2e-2;
        final double RENTE_RATE = 9.3e-2;

        for (byte employeeId = 0; employeeId < table.length; employeeId++) {
            double salary = table[employeeId][0];
            table[employeeId][1] = salary * KRANKENVERSICHERUNG_RATE;
            table[employeeId][2] = salary * PFLEGEVERSICHERUNG_RATE;
            table[employeeId][3] = salary * ARBEITSLOSENVERSICHERUNG_RATE;
            table[employeeId][4] = salary * RENTE_RATE;
        }
    }

    /**
     * Prints the given table.
     * @param table The table to print.
     */
    private static void printTable(double[][] table) {
        System.out.println("Gehalt\tKrank\tPflege\tArbeit\tRente");
        for (double[] row : table) {
            for (double value : row) {
                System.out.printf("%.2f\t", round(value));
            }
            System.out.println();
        }
    }

    /**
     * Rounds value to 2 decimal places.
     * @param value The value to round.
     * @return The rounded value.
     */
    private static double round(double value) {
        value *= 100;
        value = Math.round(value);
        value /= 100;
        return value;
    }

    public static void main() {
        boolean doAnotherCalculation = true;
        do {
            var table = createTable();
            System.out.println();
            calculateTable(table);
            printTable(table);
            System.out.println();

            doAnotherCalculation = UserInput.readBoolean("Wollen Sie weitere Sozialabgaben berechnen lassen? ");
            System.out.println();
        } while(doAnotherCalculation);
    }
}
