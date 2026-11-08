package s108_n3_e01_StreamsObjectes;

import java.util.List;

public record Alumne(String nom, int edat, String curs, double nota) {


    public static List<Alumne> startsWithA(List<Alumne> students) {
        return students.stream()
                .filter(s -> s.nom().toLowerCase().startsWith("a"))
                .toList();
    }

    public static List<Alumne> gradeAbove5(List<Alumne> students) {
        return students.stream()
                .filter(s -> s.nota() >= 5)
                .toList();
    }

    public static List<Alumne> gradeAbove5NotPhp(List<Alumne> students) {
        return students.stream()
                .filter(s -> s.nota() >= 5)
                .filter(s -> !s.curs().equalsIgnoreCase("PHP"))
                .toList();
    }

    public static List<Alumne> javaLegalAge(List<Alumne> students) {
        return students.stream()
                .filter(s -> s.curs().equalsIgnoreCase("Java"))
                .filter(s -> s.edat() >= 18)
                .toList();
    }
}
