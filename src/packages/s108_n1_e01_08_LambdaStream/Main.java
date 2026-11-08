package s108_n1_e01_08_LambdaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Exercise 5: Functional Interface for Pi Value
    @FunctionalInterface
    interface PiProvider {
        double getPiValue();
    }

    // Exercise 8: Functional Interface for String Reversal
    @FunctionalInterface
    interface StringReverser {
        String reverse(String input);
    }

    public static void main(String[] args) {
        // Sample data for Exercises 1 & 2
        Words words = new Words(Arrays.asList("ocean", "sky", "computer", "book", "sun", "orange", "fox", "watermelon"));

        // --- EXERCISE 1 ---
        System.out.println("--- Exercise 1: Words containing 'o' ---");
        List<String> wordsWithO = words.filterContainingO();
        System.out.println(wordsWithO);

        // --- EXERCISE 2 ---
        System.out.println("\n--- Exercise 2: Words containing 'o' and length > 5 ---");
        List<String> longWordsWithO = words.filterLongContainingO();
        System.out.println(longWordsWithO);

        // Sample data for Exercises 3 & 4
        Months months = new Months(Arrays.asList(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        ));

        // --- EXERCISE 3 ---
        System.out.println("\n--- Exercise 3: Printing months using a Lambda expression ---");
        months.processMonths(x -> System.out.println(x));

        // --- EXERCISE 4 ---
        System.out.println("\n--- Exercise 4: Printing months using a Method Reference ---");
        months.processMonths(System.out::println);

        // --- EXERCISE 5 ---
        System.out.println("\n--- Exercise 5: Functional Interface getPiValue() ---");
        PiProvider piProvider = () -> 3.1415;
        System.out.println("Pi value: " + piProvider.getPiValue());

        // Sample data for Exercises 6 & 7 (Mixed list of numbers and strings)
        MixedList mixedList = new MixedList(Arrays.asList("Elephant", 42, "Cat", 7, "Hippopotamus", "Dog", 100, "Snake"));

        // --- EXERCISE 6 ---
        System.out.println("\n--- Exercise 6: Sorted by length (Shortest to Longest) ---");
        mixedList.sortByLengthAscending();
        System.out.println(mixedList);

        // --- EXERCISE 7 ---
        System.out.println("\n--- Exercise 7: Sorted by length (Longest to Shortest) ---");
        mixedList.sortByLengthDescending();
        System.out.println(mixedList);

        // --- EXERCISE 8 ---
        System.out.println("\n--- Exercise 8: Functional Interface reverse() ---");
        StringReverser reverser = (input) -> new StringBuilder(input).reverse().toString();

        String originalStr = "Java Lambdas";
        String reversedStr = reverser.reverse(originalStr);

        System.out.println("Original: " + originalStr);
        System.out.println("Reversed: " + reversedStr);
    }
}

