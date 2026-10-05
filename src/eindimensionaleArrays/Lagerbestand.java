package eindimensionaleArrays;

import utils.Printer;
import utils.UserInput;

public class Lagerbestand {
    public static void main(String[] args) {
        final byte UNIQUE_ITEM_COUNT = UserInput.readByte("Wie viele verschiedene Artikel sind im Lager? ",
                                                          (Long l) -> l > 0,
                                                          "Anzahl muss >0 sein.\n");
        String[] itemNames = new String[UNIQUE_ITEM_COUNT];
        float[] itemPrices = new float[UNIQUE_ITEM_COUNT];
        int[] itemCounts = new int[UNIQUE_ITEM_COUNT];
        for (byte i = 0; i < UNIQUE_ITEM_COUNT; i++) {
            itemNames[i] = UserInput.readString(String.format("Bezeichnung von Artikel %d? ",
                                                              i+1));
            itemPrices[i] = UserInput.readFloat(String.format("Preis von Artikel '%s'? ",
                                                              itemNames[i]));
            itemCounts[i] = UserInput.readInt(String.format("Menge von Artikel '%s'? ",
                                                            itemNames[i]));
        }

        long totalCount = 0;
        double totalPrice = 0;
        for (byte i = 0; i < UNIQUE_ITEM_COUNT; i++) {
            totalCount += itemCounts[i];
            totalPrice += itemCounts[i] * itemPrices[i];
        }

        System.out.printf("Im Lager befinden sich %d Artikel im Wert von %s.\n",
                          totalCount,
                          Printer.GERMAN_EURO_FORMAT.format(totalPrice));
    }
}
