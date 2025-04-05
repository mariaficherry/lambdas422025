package Lambdas;

import org.testng.annotations.Test;

public class TypeCastingTest {

    //Implicit casting, widening, upcasting
    @Test
    public void upCastingTest() {
        int i = 10;
        double d = i;
        System.out.println(d);
    }

    //Explicit casting, narrowing, down casting
    @Test
    public void downCastingTest() {
        double d = 9.8;
        int i = (int) d;
        System.out.println(i);
    }
}
