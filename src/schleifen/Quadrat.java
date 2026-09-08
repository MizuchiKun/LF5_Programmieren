package schleifen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quadrat {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Wie groß soll das Quadrat sein (>0)? ");
        int width = Integer.parseInt(reader.readLine().trim());

        String square = "";
        for (int y = 0; y < width; y++)
        {
            for (int x = 0; x < width; x++)
            {
                if (y == 0 || y == width - 1
                    || x == 0 || x == width - 1)
                {
                    square += '口';
                }
                else
                {
                    square += '　';
                }
            }

            if (y != width - 1)
            {
                square += '\n';
            }
        }

        System.out.println(square);
    }
}
