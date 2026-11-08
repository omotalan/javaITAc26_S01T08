package s108_n3_e01_StreamsObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import s108_n3_e01_StreamsObjectes.Alumne;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlumneTest {

    private List<Alumne> students;

    private final Alumne annaJavaPassAdult = new Alumne("Anna", 20, "Java", 8.5);
    private final Alumne albertPhpPassAdult = new Alumne("albert", 22, "php", 5.0);
    private final Alumne marcJavaFailAdult = new Alumne("Marc", 18, "JAVA", 4.9);
    private final Alumne juliaJavaPassMinor = new Alumne("Júlia", 17, "Java", 9.0);
    private final Alumne pauPythonPassAdult = new Alumne("Pau", 25, "Python", 5.0);

    @BeforeEach
    void setUp() {
        students = List.of(
                annaJavaPassAdult,
                albertPhpPassAdult,
                marcJavaFailAdult,
                juliaJavaPassMinor,
                pauPythonPassAdult
        );
    }

    @Test
    void startsWithAShouldBeCaseInsensitive() {
        List<Alumne> result = Alumne.startsWithA(students);
        assertEquals(List.of(annaJavaPassAdult, albertPhpPassAdult), result);
    }

    @Test
    void gradeAbove5ShouldInclude5() {
        List<Alumne> result = Alumne.gradeAbove5(students);
        assertEquals(List.of(annaJavaPassAdult, albertPhpPassAdult, juliaJavaPassMinor, pauPythonPassAdult), result);
    }

    @Test
    void gradeAbove5NotPhpShouldBeCaseInsensitive() {
        List<Alumne> result = Alumne.gradeAbove5NotPhp(students);
        assertEquals(List.of(annaJavaPassAdult, juliaJavaPassMinor, pauPythonPassAdult), result);
    }

    @Test
    void javaLegalAgeShouldInclude18() {
        List<Alumne> result = Alumne.javaLegalAge(students);
        assertEquals(List.of(annaJavaPassAdult, marcJavaFailAdult), result);
    }

    @Test
    void emptyListShouldReturnEmptyListForAllFilters() {
        List<Alumne> empty = List.of();
        assertTrue(Alumne.startsWithA(empty).isEmpty());
        assertTrue(Alumne.gradeAbove5(empty).isEmpty());
        assertTrue(Alumne.gradeAbove5NotPhp(empty).isEmpty());
        assertTrue(Alumne.javaLegalAge(empty).isEmpty());
    }
}


