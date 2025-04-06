package Lambdas;

public class Parent {
    void show() {
        System.out.println("This is a parent method");
    }

    static Parent getInstance() {
        return new Child(); // Returns a Child instance
    }
}
