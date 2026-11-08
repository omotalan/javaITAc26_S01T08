package s108_n1_e01_08_LambdaStream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public record Words(List<String> list) {

    public Words {
        Objects.requireNonNull(list, "Word list can't be null.");
        list.forEach(word -> Objects.requireNonNull(word, "Individual words in the list cannot be null."));
        // Return copy for immutability
        list = List.copyOf(list);
    }

    public List<String> filterContainingO() {
        return list.stream()
                .filter(word -> word.toLowerCase().contains("o"))
                .collect(Collectors.toList());
    }

    public List<String> filterLongContainingO() {
        return list.stream()
                .filter(word -> word.toLowerCase().contains("o"))
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());
    }
}
