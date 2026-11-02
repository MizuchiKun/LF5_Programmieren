package eindimensionaleArrays;

import utils.UserInput;

public class Balkendiagramm {
    /** Builds and returns a bar diagram made from '*', where each '*' corresponds to 1 floored percent.
     *
     * @param percentage The percentage to represent.
     * @return The built bar diagram.
     */
    private static String buildBarDiagramm(float percentage) {
        var builder = new StringBuilder();
        byte flooredPercentage = (byte)Math.floor(percentage);
        for (byte i = 0; i < flooredPercentage; i++) {
            builder.append('*');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Erfasse jetzt die prozentuale Verteilung des Votings (in Prozent): ");
        float[] votePercentages = UserInput.readArray(float.class,
                                                      "Wie viele Kandidaten sind noch im Rennen? ",
                                                      "Kandidat %d: ");

        System.out.println("Ergebnis");
        for (int i = 0; i < votePercentages.length; i++) {
            System.out.printf("Kandidat %d: %s %.1f%%\n",
                              i+1,
                              buildBarDiagramm(votePercentages[i]),
                              votePercentages[i]);
        }
    }
}
