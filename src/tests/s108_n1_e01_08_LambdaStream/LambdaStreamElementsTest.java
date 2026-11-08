package s108_n1_e01_08_LambdaStream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LambdaStreamElementsTest {

    @Test
    void shouldPassFailsafeAndThenFilter() {
        // Test validations
        assertThrows(NullPointerException.class, () -> new Words(null));
        assertThrows(NullPointerException.class, () -> new Words(Arrays.asList("Freddie Gibbs", null)));

        Words words = new Words(Arrays.asList("Freddie Gibbs", "Joey Badass", "J Cole", "Busta Rhymes"));
        assertEquals(Arrays.asList("Joey Badass", "J Cole"), words.filterContainingO());
        assertEquals(Arrays.asList("Joey Badass", "J Cole"), words.filterLongContainingO());
    }

    @Test
    void shouldApplyLambdaMethodReference() {
        Months months = new Months(Arrays.asList("Gener", "Febrer", "Mars"));
        List<String> caught = new ArrayList<>();

        months.processMonths(caught::add);

        assertEquals(3, caught.size());
        assertEquals("Gener", caught.getFirst());
    }

    @Test
    void piProviderShouldReturnOnlyPi() {
        PiProvider piProvider = () -> 3.1415;
        assertEquals(3.1415, piProvider.getPiValue(), 0.00001);
    }

    @Test
    void mixedListShouldSortBothWays() {
        MixedList mixed = new MixedList(Arrays.asList("Elephant", 42, "Cat", 7, "Hippopotamus", "Dog", 100, "Snake"));

        // Sort ascending
        List<String> asc = mixed.sortByLengthAscending();
        assertEquals(Arrays.asList("7", "42", "Cat", "Dog", "100", "Snake", "Elephant", "Hippopotamus"), asc);

        // Sort descending
        List<String> desc = mixed.sortByLengthDescending();
        assertEquals(Arrays.asList("Hippopotamus", "Elephant", "Snake", "Cat", "Dog", "100", "42", "7"), desc);
    }

    @Test
    void stringReverserShouldSupportLambda() {
        StringReverser reverser = (input) -> {
            if (input == null) {
                throw new NullPointerException("Input cannot be null");
            } else {
                return new StringBuilder(input).reverse().toString();
            }
        };

        assertEquals("avaJ", reverser.reverse("Java"));
        assertEquals("", reverser.reverse(""));
        assertThrows(NullPointerException.class, () -> reverser.reverse(null));
    }
}
