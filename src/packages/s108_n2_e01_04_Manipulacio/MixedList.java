package s108_n2_e01_04_Manipulacio;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public record MixedList(List<Object> list) {
    public MixedList {
        Objects.requireNonNull(list, "Mixed list cannot be null");
        list = List.copyOf(list);
    }

    List<String> getAsStringList() {
        return list.stream()
                .map(Objects::toString)
                .collect(Collectors.toList());
    }

    public List<String> sortAlphabetically() {
        return getAsStringList().stream()
                .sorted(Comparator.comparingInt(s -> s.charAt(0)))
                .toList();
    }

    static CustomSorter eFirst = (list) ->
            list.stream()
                .sorted((s1, s2) -> {
                    boolean s1HasE = s1.toLowerCase().contains("e");
                    boolean s2HasE = s2.toLowerCase().contains("e");
                    return Boolean.compare(s2HasE, s1HasE);
                })
                .toList();

    static CustomSorter replaceAWithNumber = (list) ->
            list.stream()
                .map(s -> s.contains("a") ? s.replace("a", "4") : s)
                .toList();

    static CustomSorter onlyNumbers = (list) ->
            list.stream()
                .filter(s -> s.matches("-?\\d+(\\.\\d+)?"))
                .toList();

}
