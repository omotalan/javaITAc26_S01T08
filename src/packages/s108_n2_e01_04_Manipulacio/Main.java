package s108_n2_e01_04_Manipulacio;


import java.util.Arrays;
import java.util.List;

import static s108_n2_e01_04_Manipulacio.MixedList.*;

public class Main {

    public static void main(String[] args) {

        // EXERCICI 1
        NomsPropis noms = new NomsPropis(Arrays.asList("Tomato", "Basil", "Art", "Mozzarella cheese", "Anchovies"));
        List<String> filtered = noms.StringsWithAAndThreeLetters();
        System.out.println("\n--- Exercise 1 ---");
        System.out.println(filtered.toString());

        // EXERCICI 2   
        String nbrChain = NumberFormatter.formatNumbers(Arrays.asList(2, 55, 98, 0));
        System.out.println("\n--- Exercise 2 ---");
        System.out.println(nbrChain);

        // EXERCICI 3
        // Operations via functional interface contract. Lambda must fit interface method
        Operacio suma = (x, y) -> x + y;
        Operacio subtraccio = (x, y) -> x - y;
        Operacio multiplicacio = (x, y) -> x * y;
        Operacio divisio = (x, y) -> x / y;

        // Apply contract by calling method
        System.out.println("\n--- Exercise 3 ---");
        System.out.println(suma.aplicar(2, 3));
        System.out.println(subtraccio.aplicar(2, 3));
        System.out.println(multiplicacio.aplicar(2, 3));
        System.out.println(divisio.aplicar(2, 3));

        // EXERCICI 4
        MixedList mixedList = new MixedList(Arrays.asList("Elephant", 42, "Cat", 7, "Hippopotamus", "Dog", 100, "Snake"));

        System.out.println("\n--- Exercise 4 ---");
        System.out.println("\nAlphabetic sort:");
        System.out.println(mixedList.sortAlphabetically());

        System.out.println("\nE first sort:");
        System.out.println(eFirst.sort(mixedList.getAsStringList()));

        System.out.println("\nReplace A with 4:");
        System.out.println(replaceAWithNumber.sort(mixedList.getAsStringList()));

        System.out.println("\nShow numbers only:");
        System.out.println(onlyNumbers.sort(mixedList.getAsStringList()));
    }
}
