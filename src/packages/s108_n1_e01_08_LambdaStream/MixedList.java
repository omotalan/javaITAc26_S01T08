package s108_n1_e01_08_LambdaStream;

import java.util.ArrayList;
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

    public List<String> sortByLengthAscending() {
        List<String> mutableList = new ArrayList<>(getAsStringList());
        mutableList.sort(Comparator.comparingInt(String::length));
        return List.copyOf(mutableList);
    }

    public List<String> sortByLengthDescending() {
        List<String> mutableList = new ArrayList<>(getAsStringList());
        mutableList.sort(Comparator.comparingInt(String::length).reversed());
        return List.copyOf(mutableList);
    }

}
