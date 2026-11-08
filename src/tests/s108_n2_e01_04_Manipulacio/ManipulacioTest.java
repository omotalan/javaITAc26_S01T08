package s108_n2_e01_04_Manipulacio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static s108_n2_e01_04_Manipulacio.MixedList.*;

public class ManipulacioTest {

        @Test
        void shouldFilterStringsWithAAndThreeLetters() {
            NomsPropis noms = new NomsPropis(Arrays.asList("Tomato", "Basil", "Art", "Mozzarella cheese", "Anchovies"));
            assertEquals(List.of("Art"), noms.StringsWithAAndThreeLetters());
        }

        @Test
        void shouldThrowOnNullOrEmptyLists() {
            assertThrows(NullPointerException.class, () -> new NomsPropis(null));
            assertThrows(NullPointerException.class, () -> new NomsPropis(Arrays.asList("Freddie", null)));
            assertThrows(IllegalArgumentException.class, () -> new NomsPropis(List.of()));
            assertThrows(IllegalArgumentException.class, () -> new NomsPropis(List.of("")));
        }

        @Test
        void shouldIgnoreLowercaseAWithThreeLetters() {
            NomsPropis noms = new NomsPropis(Arrays.asList("ant", "Apt", "Art", "act", "Anchovies", "alimony"));
            assertEquals(List.of("Apt", "Art"), noms.StringsWithAAndThreeLetters());
        }

        @Test
        void shouldFormatNumbersAndJoinOnComma() {
            assertEquals("e2, o55", NumberFormatter.formatNumbers(Arrays.asList(2, 55)));
        }

        @Test
        void shouldFormatZeroAsPair() {
            assertEquals("e0, e2, o55", NumberFormatter.formatNumbers(Arrays.asList(0, 2, 55)));
        }

        @Test
        void shouldFormatNegativeNumbers() {
            assertEquals("e-2, o-55", NumberFormatter.formatNumbers(Arrays.asList(-2, -55)));
        }

        @Test
        void shouldFormatSingleElementWithNoComma() {
            assertEquals("e2", NumberFormatter.formatNumbers(List.of(2)));
        }

        @Test
        void shouldFormatEmptyInputListAsEmptyString() {
            assertEquals("", NumberFormatter.formatNumbers(List.of()));
        }

        @Test
        void SumLambdaShouldSumTwoElements() {
            Operacio suma = (x, y) -> x + y;

            assertEquals(5, suma.aplicar(2, 3));
            assertEquals(-1, suma.aplicar(2, -3));
            assertEquals(0, suma.aplicar(2, -2));
            assertEquals(2, suma.aplicar(2, 0));
        }

        @Test
        void SubtractionLambdaShouldSubtractTwoElements() {
            Operacio subtraccio = (x, y) -> x - y;

            assertEquals(-1, subtraccio.aplicar(2, 3));
            assertEquals(5, subtraccio.aplicar(2, -3));
            assertEquals(0, subtraccio.aplicar(2, 2));
            assertEquals(2, subtraccio.aplicar(2, 0));
        }

        @Test
        void MUltiplicationLambdaShouldMultiplyTwoElements() {
            Operacio multiplicacio = (x, y) -> x * y;

            assertEquals(6, multiplicacio.aplicar(2, 3));
            assertEquals(-6, multiplicacio.aplicar(2, -3));
            assertEquals(4, multiplicacio.aplicar(2, 2));
            assertEquals(0, multiplicacio.aplicar(2, 0));
        }

        @Test
        void DivisionLambdaShouldDivideTwoElements() {
            Operacio divisio = (x, y) -> x / y;

            assertEquals(2, divisio.aplicar(6, 3));
            assertEquals(-2, divisio.aplicar(6, -3));
            assertEquals(1, divisio.aplicar(2, 2));
        }

        @Test
        void DivisionLambdaShouldReturnInfinityOnDivisionByZero() {
            Operacio divisio = (x, y) -> x / y;

            assertEquals(Float.POSITIVE_INFINITY, divisio.aplicar(2, 0));
        }


        @Nested
        class MixedListTests {
            private MixedList mixedList;
            private final List<Object> baseList = Arrays.asList("Elephant", 42, "Cat", 7, "Hippopotamus", "Dog", 100, "Snake");

            @BeforeEach
            void spawnMixedList() {
                mixedList = new MixedList(baseList);
            }

            @Test
            void mixedListShouldSortAlphabetically() {
                List<String> alph = mixedList.sortAlphabetically();
                assertEquals(Arrays.asList("100", "42", "7", "Cat", "Dog", "Elephant", "Hippopotamus", "Snake"), alph);
            }

            @Test
            void mixedListShouldNotAffectOriginalList() {
                List<String> alph = mixedList.sortAlphabetically();
                assertEquals(Arrays.asList("100", "42", "7", "Cat", "Dog", "Elephant", "Hippopotamus", "Snake"), alph);
                assertEquals(Arrays.asList("Elephant", 42, "Cat", 7, "Hippopotamus", "Dog", 100, "Snake"), mixedList.list());
            }

            @Test
            void mixedListShouldSortAlphabeticallyObservingCase() {
                mixedList = new MixedList(Arrays.asList("Elephant", 42, "cat", "Cat", 7, "Hippopotamus", "dog", 100, "snake"));
                List<String> alph = mixedList.sortAlphabetically();
                assertEquals(Arrays.asList("100", "42", "7", "Cat", "Elephant", "Hippopotamus", "cat", "dog", "snake"), alph);
            }

            @Test
            void mixedListShouldSortEFirst() {
                List<String> ef = eFirst.sort(mixedList.getAsStringList());
                assertEquals(Arrays.asList("Elephant", "Snake", "42", "Cat", "7", "Hippopotamus", "Dog", "100"), ef);
            }

            @Test
            void mixedListShouldReplaceAWith4() {
                List<String> a4 = replaceAWithNumber.sort(mixedList.getAsStringList());
                assertEquals(Arrays.asList("Eleph4nt", "42", "C4t", "7", "Hippopot4mus", "Dog", "100", "Sn4ke"), a4);
            }

            @Test
            void mixedListShouldShowOnlyNumbers() {
                List<String> onbrs = onlyNumbers.sort(mixedList.getAsStringList());
                assertEquals(Arrays.asList("42", "7", "100"), onbrs);
            }

            @Test
            void mixedListShouldShowOnlyNumbersRegardlessOfType() {
                mixedList = new MixedList(Arrays.asList("13", "42", "Cat", 7, "Hippopotamus", "dog", 100, "snake"));
                List<String> onbrs = onlyNumbers.sort(mixedList.getAsStringList());
                assertEquals(Arrays.asList("13", "42", "7", "100"), onbrs);
            }

        }
}
