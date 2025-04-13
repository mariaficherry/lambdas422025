package Lambdas;

import java.util.List;

public class UpperBoundedWildcard {
    public static void makeAnimalSound(List<? extends Animal> animals) {
        for (Animal a : animals) {
            a.sound();
        }
    }
}
