package s108_n2_e01_04_Manipulacio;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public record NomsPropis(List<String> list) {

    public NomsPropis {
        Objects.requireNonNull(list, "Name list can't be null.");
        if (list.isEmpty() || list.contains("")) {
            throw new IllegalArgumentException("Name list can't be empty.");
        }
        list = List.copyOf(list);
    }

    public List<String> StringsWithAAndThreeLetters() {
        return list.stream()
                .filter(nom -> nom.contains("A"))
                .filter(nom -> nom.length() == 3)
                .collect(Collectors.toList());
    }
}
