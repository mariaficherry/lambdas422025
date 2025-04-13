package Lambdas;

import java.util.List;

public class LowerBoundedWildcard {
    public static void addDog(List<? super Dog> list) {
        list.add(new Dog());
    }
}
