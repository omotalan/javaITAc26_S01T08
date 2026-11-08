package s108_n2_e01_04_Manipulacio;

import java.util.List;
import java.util.stream.Collectors;

public class NumberFormatter {

    public static String formatNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> (n % 2 == 0 ? "e" : "o") + n)
                .collect(Collectors.joining(", "));
    }
}
