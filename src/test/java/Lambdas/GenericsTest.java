package Lambdas;

import org.testng.annotations.Test;

public class GenericsTest {

    @Test
    public void genericsClassTest() {
        // Type Integer
        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println("Box Integer value: " + intBox.get());

        // Type String
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Box");
        System.out.println("Box String value: " + stringBox.get());
    }

    @Test
    public void genericsMethodTest() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Hello", "World", "I'm", "Maria"};

        Utility.printArray(intArray);
        Utility.printArray(stringArray);
    }
}
