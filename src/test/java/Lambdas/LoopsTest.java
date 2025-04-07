package Lambdas;

import org.testng.annotations.Test;

import java.util.List;

public class LoopsTest {

    @Test
    public void whileTest() {
        // Basic counting
        int i = 0;
        while (i < 4) {
            System.out.println(i);
            i++;
        }

        // Sum until a condition
        int num = 1;
        int sum = 0;
        while (num <= 10) {
            sum += num;
            num++;
        }
        System.out.println("Total sum: " + sum);


        // Filter even numbers
        int[] numbers = {2, 5, 8, 9, 10, 22, 20, 100, 44, 60};
        int index = 0;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                System.out.println("Even number: " + numbers[index]);
            }
            index++;
        }

        // Do-while example (runs at least once)
        int x = 0;
        do {
            System.out.println("x is: " + x);
            x++;
        } while (x <= 5);
    }

    @Test
    public void forLoopTest() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        String[] fruits = {"Apple", "Banana", "Cherry"};
        List<String> fruitsWithList = List.of("Apple", "Banana", "Cherry");
        // For
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }

        // For each
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Looping in reverse
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }

        // Nested for loop
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
    }

    @Test
    public void breakContinueTest() {
        for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                continue;
            }
            if (i == 8) {
                break;
            }
            System.out.println(i);
        }
    }

}
