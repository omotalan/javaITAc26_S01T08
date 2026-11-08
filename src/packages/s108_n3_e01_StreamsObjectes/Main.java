package s108_n3_e01_StreamsObjectes;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Alumne> students = List.of(
            new Alumne("Fernando Poo", 19, "Java", 10),
            new Alumne("Lluis Companys", 18, "PHP", 6.5),
            new Alumne("Ada Colau", 17, "Java", 8.7),
            new Alumne("Gabriel Rufián", 21, "PHP", 5.8),
            new Alumne("Jaume Collboni", 20, "Java", 9.3),
            new Alumne("cristobal Colón", 18, "Java", 4.5),
            new Alumne("Hans-Dieter Flick", 20, "PHP", 8),
            new Alumne("David Broncano", 19, "Java", 7.2),
            new Alumne("Pedro Sanchez", 16, "Java", 8.2),
            new Alumne("Salvador Illa", 16, "PHP", 4.5)
        );

        System.out.println("\n--- Stream Name and age ---");
        students.forEach(s -> System.out.println(s.nom() + " - " + s.edat()));

        System.out.println("\n--- Stream print names starting with 'a' ---");
        List<Alumne> filteredA = Alumne.startsWithA(students);
        filteredA.forEach(System.out::println);

        System.out.println("\n--- Stream Grade >= 5 ---");
        List<Alumne> filteredGrade = Alumne.gradeAbove5(students);
        filteredGrade.forEach(System.out::println);

        System.out.println("\n--- Grade >= 5 and not PHP ---");
        List<Alumne> filteredGradePhp = Alumne.gradeAbove5NotPhp(students);
        filteredGradePhp.forEach(System.out::println);

        System.out.println("\n--- JAVA and of legal age ---");
        List<Alumne> filteredJavaLegal = Alumne.javaLegalAge(students);
        filteredJavaLegal.forEach(System.out::println);
    }
}
