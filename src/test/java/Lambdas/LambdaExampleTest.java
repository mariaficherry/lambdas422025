package Lambdas;

import org.testng.annotations.Test;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaExampleTest {

    // lambda syntax: (parameter) -> {body}
    // or (parameter) -> expression

    @Test
    public void anonymousClassTest() {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hi with anonymous!");
            }
        };
        greeting.sayHello();
    }

    @Test
    public void lambdaClassTest() {
        Greeting greeting = () -> System.out.println("Hi with lambda!");
        greeting.sayHello();
    }

    @Test
    public void mathOperationTest() {
        MathOperation addition = (a, b) -> a + b;
        System.out.println(addition.operate(5, 6));
    }

    @Test
    public void predicateTest() {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4));
    }

    @Test
    public void runnableTest() {
        Runnable task = () -> System.out.println("Task is running");
        new Thread(task).start();
    }

    @Test
    public void callableTest() {
        Callable<String> callableTask = () -> "Task is running";
        // We need an ExecutorService to run callableTask
    }

    @Test
    public void biFunctionTest() {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(5, 10));
    }

    @Test
    public void unaryOperatorTest() {
        UnaryOperator<String> toUpperCase = str -> str.toUpperCase();
        System.out.println(toUpperCase.apply("kiwi"));
    }

    @Test
    public void binaryOperator() {
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        BinaryOperator<Integer> add = (a, b) -> a + b;
        BinaryOperator<Integer> subtract = (a, b) -> a - b;
        BinaryOperator<Integer> divide = (a, b) -> a / b;
        System.out.println(multiply.apply(1, 100));
        System.out.println(add.apply(1, 100));
        System.out.println(divide.apply(1, 100));
        System.out.println(subtract.apply(1, 100));

        BinaryOperator<String> toUppercase = (a, b) -> a.toUpperCase() + ": " + b.toUpperCase();
        System.out.println(toUppercase.apply("kiwi", "animal"));
    }

    @Test
    public void sortingTest() {

    }
}
