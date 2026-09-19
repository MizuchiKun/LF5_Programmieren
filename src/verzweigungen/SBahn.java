package verzweigungen;

public class SBahn {
    public static double berechnePreis(int start, int end) {
        int startLine = start / 10;
        int startStation = start % 10;
        int endLine = end / 10;
        int endStation = end % 10;

        final int LINE_COUNT = 5;
        final int RING_STATION = 3;
        final int FINAL_STATION = 6;
        double priceInEuro = 0;

        boolean areNeighboursInCentre = startStation + endStation == 1;
        boolean areLineNeighbours = areNeighboursInCentre
                                    || (startLine == endLine && Math.abs(startStation - endStation) == 1);
        boolean areRingNeighbours = (startStation == RING_STATION && endStation == RING_STATION)
                                    && (Math.abs(startLine - endLine) == 1
                                        || startLine + endLine == LINE_COUNT + 1);
        boolean areNeighbouringStations = areLineNeighbours || areRingNeighbours;

        if (areNeighbouringStations) {
            priceInEuro = 1;
        } else {
            priceInEuro = 2;

            boolean startsAtEndOfLine = (startStation == 0 || startStation == FINAL_STATION);
            boolean endsAtEndOfLine = (endStation == 0 || endStation == FINAL_STATION);
            if (startsAtEndOfLine) {
                priceInEuro += 1;
            }
            if (endsAtEndOfLine) {
                priceInEuro += 1;
            }

            boolean startsInZone1 = startStation <= RING_STATION;
            boolean endsInZone1 = endStation <= RING_STATION;
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
