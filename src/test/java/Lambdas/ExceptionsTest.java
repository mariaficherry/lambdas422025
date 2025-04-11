package Lambdas;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class ExceptionsTest {

    @Test
    public void tryCatchTest() {
        try {
            int x = 10;
            int y = 0;
            int result = x / y;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }

    @Test
    public void throwException() throws MyException {
        checkAge(10);
    }

    @Test
    public void unCheckedException() {
        divide(10, 0);
    }

    @Test
    public void checkedException() throws IOException {
        readFile("some name");
    }

    void checkAge(int age) throws MyException {
        if (age < 18) {
            throw new MyException("You must be 18 or older");
        }
    }

    public void divide(int a, int b) {
        int result = a / b;
    }

    public void readFile(String filename) throws IOException {
        FileReader file = new FileReader(filename);
        file.read();
        file.close();
    }
}
