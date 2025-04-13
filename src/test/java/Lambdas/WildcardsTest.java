package Lambdas;

import org.testng.annotations.Test;

import java.util.List;

public class WildcardsTest {

    @Test
    public void upperBoundedWildcardTest() {
        List<Dog> dogs = List.of(new Dog(), new Dog());
        List<Cat> cats = List.of(new Cat());

        // Works for reading from list, not modifying
        UpperBoundedWildcard.makeAnimalSound(dogs);
        UpperBoundedWildcard.makeAnimalSound(cats);
    }

    @Test
    public void lowerBoundedWildcardTest() {

    }

    @Test
    public void unboundedWildcardTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> strings = List.of("Hello", "from", "a", "Wildcard");

        UnboundedWildcard.printList(numbers);
        UnboundedWildcard.printList(strings);
    }
}
