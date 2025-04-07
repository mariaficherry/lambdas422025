package Lambdas.example;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Read Input until user types "exit"
        Scanner scanner = new Scanner(System.in);
        List<String> savedInputs = new ArrayList<>();
        String input;
        while (true) {
            System.out.println("Type something (type exit to stop): ");
            input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            savedInputs.add(input);
        }
        System.out.println("Exited loop");
        System.out.println("You typed: ");
        for (String saved : savedInputs) {
            System.out.println("- " + saved);
        }
    }
}