package Lambdas;

public class Utility {
    // Generic method that prints any array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element + " ");
        }
        System.out.println();
    }
}
