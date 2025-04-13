package Lambdas;

import java.util.List;

public class UnboundedWildcard {
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
