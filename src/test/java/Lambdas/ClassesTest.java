package Lambdas;

import org.testng.annotations.Test;

public class ClassesTest {

    @Test
    public void usingMethodsOfParentClass() {
        Dog dog = new Dog();
        dog.makeSound();
    }

    @Test
    public void varargsTest() {
        MathUtil mathUtil = new MathUtil();
        int result = mathUtil.sum(1, 2, 3, 4);
        System.out.println(result);
    }
}
