package verzweigungen;

public class SBahn {
    public static double berechnePreis(int start, int end) {
        int startLine = start / 10;
        int startStation = start % 10;
        int endLine = end / 10;
        int endStation = end % 10;

        final int NUMBER_OF_LINES = 5;
        final int RING_LINE_STATION = 3;
        final int FINAL_STATION = 6;
        double priceInEuro = 0;
        boolean areLineNeighbours = (startStation + endStation == 1)
                                    || (startLine == endLine && Math.abs(startStation - endStation) == 1);
        boolean areRingNeighbours = (startStation == RING_LINE_STATION && endStation == RING_LINE_STATION)
                                    && (Math.abs(startLine - endLine) == 1
                                        || startLine + endLine == NUMBER_OF_LINES + 1);
        boolean areNeighbouringStations = areLineNeighbours || areRingNeighbours;
        if (areNeighbouringStations) {
            priceInEuro = 1;
        } else {
            priceInEuro = 2;  // 2 € base price.

            boolean startsAtEndOfLine = (startStation == 0 || startStation == FINAL_STATION);
            boolean endsAtEndOfLine = (endStation == 0 || endStation == FINAL_STATION);
            if (startsAtEndOfLine) {
                priceInEuro += 1;
            }
            if (endsAtEndOfLine) {
                priceInEuro += 1;
            }

            boolean startsInZone1 = startStation <= RING_LINE_STATION;
            boolean endsInZone1 = endStation <= RING_LINE_STATION;
            boolean crossedBoundaryExplicitly = (startsInZone1 ^ endsInZone1);
            boolean crossedBoundaryImplicitly = (!startsInZone1 && !endsInZone1)
                                                && startLine != endLine;
            boolean crossedBoundary = crossedBoundaryExplicitly || crossedBoundaryImplicitly;
            if (crossedBoundary) {
                priceInEuro += 1;
            }
        }

        return priceInEuro;
    }
}
