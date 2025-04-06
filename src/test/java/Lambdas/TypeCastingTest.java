package Lambdas;

import org.testng.annotations.Test;

public class TypeCastingTest {

    //Implicit casting, widening, upcasting -> smaller to bigger
    @Test
    public void upCastingTest() {
        int i = 10;
        double d = i;
        System.out.println(d);
    }

    //Explicit casting, narrowing, down casting -> bigger to smaller
    @Test
    public void downCastingTest() {
        double d = 9.8;
        int i = (int) d;
        System.out.println(i);
    }

    @Test
    public void upcastingObjectTest() {
        Parent parent = new Child(); // upcasting (implicit) -> smaller to bigger
        parent.show(); // now can only access parent methods

        Child child = (Child) parent; //down casting (explicit) -> bigger to smaller
        child.display(); // now can only access child methods
    }

    // Safety down casting -> bigger to smaller
    @Test
    public void usingInstanceofTest() {
        Parent parent = new Child();
        if (parent instanceof Child) {
            // Down casting -> superclass to subclass -> to access child method
            Child child = (Child) parent;
            child.display();
        } else {
            System.out.println("Not an instance of Child class");
        }
    }

    @Test
    public void usingFactoryMethodTest() {
        Parent parent = Parent.getInstance();
        if (parent instanceof Child) {
            Child child = (Child) parent;
            child.display();
        }
    }
}
