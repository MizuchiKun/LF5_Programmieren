package eindimensionaleArrays;

import utils.UserInput;

import java.util.Arrays;

public class Temperatur {
    public static void main(String[] args) {
        float[] temperatures = UserInput.readArray(float.class,
                                                   (byte)7,
                                                   "Temperatur an Tag %d? ");

        float average = 0;
        float minTemperature = Float.POSITIVE_INFINITY;
        float maxTemperature = Float.NEGATIVE_INFINITY;
        float maxDailyDifference = 0;
        System.out.println(temperatures.length);
        for (byte i = 0; i < temperatures.length; i++) {
            average += temperatures[i];

            minTemperature = Math.min(temperatures[i], minTemperature);
            maxTemperature = Math.max(temperatures[i], maxTemperature);

            if (i == 0) { continue; }
            float dailyDifference = Math.abs(temperatures[i] - temperatures[i-1]);
            maxDailyDifference = Math.max(dailyDifference, maxDailyDifference);
        }

        average /= temperatures.length;
        float range = maxTemperature - minTemperature;

        System.out.printf("Mittelwert\t\t\t: %.2f\n", average);
        System.out.printf("Maximale Temperatur : %.2f\n", maxTemperature);
        System.out.printf("Minimale Temperatur : %.2f\n", minTemperature);
        System.out.printf("Spannweite\t\t\t: %.2f\n", range);
        System.out.printf("Maximale Differenz  : %.2f\n", maxDailyDifference);
    }
}
