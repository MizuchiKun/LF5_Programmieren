package zweidimensionaleArrays;

import utils.UserInput;

public class Kino {
    private static void showHall(String[][] hall) {
        System.out.println("Aktuelle Sitzreservierungen:");
        for (String[] row : hall) {
            for (String seat : row) {
                System.out.print(seat);
            }
            System.out.println();
        }
    }

    private static String[][] createHall() {
        final byte ROW_COUNT = UserInput.readByte("Wie viele Reihen hat der Saal? ",
                                                  b -> b > 0,
                                                  "Saal muss mindestens eine Reihe haben!\n");
        final byte ROW_SEAT_COUNT = UserInput.readByte("Wie viele Sitze hat jede Reihe? ",
                                                       b -> b > 0,
                                                       "Reihen müssen mindestens einen Sitz haben!\n");

        String[][] hall = new String[ROW_COUNT][ROW_SEAT_COUNT];
        for (byte row = 0; row < hall.length; row++) {
            for (byte col = 0; col < hall[row].length; col++) {
                hall[row][col] = "O";
            }
        }

        return hall;
    }

    private static void reserveSeat(String[][] hall) {
        showHall(hall);
        System.out.println();

        while (true) {
            System.out.println("Welchen Platz willst du reservieren?");
            byte row = UserInput.readByte("Reihe? ",
                                          b -> 0 <= b && b < hall.length,
                                          "Reihe muss >0 sein!\n");
            byte seat = UserInput.readByte("Sitz? ",
                                           b -> 0 <= b && b < hall[0].length,
                                           "Sitz muss >0 sein!\n");

            boolean seatIsReserved = hall[row][seat].equals("X");
            if (seatIsReserved) {
                System.out.println("Dieser Platz ist schon reserviert!\n");
                showHall(hall);
                continue;
            }

            hall[row][seat] = "X";
            System.out.println("Sitz wurde reserviert!");
            showHall(hall);
            System.out.println();

            if (!UserInput.readBoolean("Willst du noch einen Platz reservieren? ")) {
                break;
            }
        }
    }

    private static void cancelSeatReservation(String[][] hall) {
        while (true) {
            System.out.println("Welchen Platz willst du stornieren?");
            byte row = UserInput.readByte("Reihe? ",
                                          b -> 0 <= b && b < hall.length,
                                          "Reihe muss >0 sein!\n");
            byte seat = UserInput.readByte("Sitz? ",
                                           b -> 0 <= b && b < hall[0].length,
                                           "Sitz muss >0 sein!\n");

            boolean seatIsFree = hall[row][seat].equals("O");
            if (seatIsFree) {
                System.out.println("Dieser Platz ist nicht reserviert!\n");
                showHall(hall);
                continue;
            }

            hall[row][seat] = "O";
            System.out.println("Sitz wurde storniert!");
            showHall(hall);
            System.out.println();

            if (!UserInput.readBoolean("Willst du noch einen Platz stornieren? ")) {
                break;
            }
        }
    }

    public static void main() {
        //loop which lets user choose between reserve seat, cancel seat, and exit program.
        String[][] hall = createHall();

        while (true) {
            System.out.println("Was willst du machen?");
            char actionChar = UserInput.readChar("(r:reservieren, s:stornieren, q:schließen)",
                                                 c -> c == 'r' || c == 's' || c == 'q',
                                                 "Eingabe muss 'r', 's', oder 'q' sein!\n");

            switch (actionChar) {
                case 'r':
                    reserveSeat(hall);
                    break;
                case 's':
                    cancelSeatReservation(hall);
                    break;
                case 'q':
                    return;
            }
        }
    }
}
