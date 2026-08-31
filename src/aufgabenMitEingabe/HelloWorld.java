package aufgabenMitEingabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        System.out.println("Moin, Welt!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Oy, schreib' was!");
        String text = reader.readLine();

        if (Objects.equals(text, "Java"))
            System.out.println("Hamster!");
        else
            System.out.println(text);
    }
}
