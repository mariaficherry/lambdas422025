package Lambdas;

import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest {

    @Test
    public void filteringTest() {
        // With a for loop
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        List<String> result = new ArrayList<>();

        for (String name : names) {
            if (name.startsWith("A")) {
                result.add(name);
            }
        }

        System.out.println(result);

        // With streams
        List<String> resultWithStreams = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(resultWithStreams);

        List<String> resultWithStreams2 = names.stream()
                .filter(name -> names.contains("s"))
                .collect(Collectors.toList());

        System.out.println(resultWithStreams2);

        List<String> resultWithStreams3 = names.stream()
                .filter(name -> name.length() <= 5)
                .collect(Collectors.toList());

        System.out.println(resultWithStreams3);
    }

    @Test
    public void mappingTest() {
        // With a loop
        List<String> names = List.of("alice", "bob", "john");
        List<String> upperCaseNames = new ArrayList<>();
        for (String name : names) {
            upperCaseNames.add(name.toUpperCase());
        }
        System.out.println(upperCaseNames);

        // With streams
        List<String> upperCaseNamesWithStreams = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseNamesWithStreams);

        List<String> upperCaseNamesWithStreams2 = names.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(upperCaseNamesWithStreams2);
    }

    @Test
    public void summingValues() {
        // With a loop
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);

        // With streams
        int sum1 = numbers.stream().mapToInt(Integer::intValue).sum();
        int sum2 = numbers.stream().mapToInt(n -> n.intValue()).sum();
        int sum3 = numbers.stream().mapToInt(n -> n).sum();
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }

    @Test
    public void findingElementsTest() {
        List<String> names = List.of("alice", "bob", "john");
        // with loops
        String found = null;
        for (String name : names) {
            if (name.startsWith("a")) {
                found = name;
                break;
            }
        }
        System.out.println(found);

        // with streams
        String foundWithStreams = names.stream()
                .filter(name -> name.startsWith("a"))
                .findFirst()
                .orElse(null);
        System.out.println(foundWithStreams);
    }

    @Test
    public void countElementsTest() {
        List<String> names = List.of("alice", "bob", "john", "maria", "pablo");
        // With loops
        int count = 0;
        for (String name : names) {
            if (name.length() >= 4) {
                count++;
            }
        }
        System.out.println(count);

        //With streams
        long countWithLambdas = names.stream()
                .filter(name -> name.length() > 3).count();
        System.out.println(countWithLambdas);
    }
}
