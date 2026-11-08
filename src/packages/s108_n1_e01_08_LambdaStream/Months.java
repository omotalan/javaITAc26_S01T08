package s108_n1_e01_08_LambdaStream;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public record Months(List<String> list) {

    public Months {
        Objects.requireNonNull(list, "Month list can't be null.");
        list = List.copyOf(list);
    }


    public void processMonths(Consumer<String> action) {
        list.forEach(action);
    }
}
