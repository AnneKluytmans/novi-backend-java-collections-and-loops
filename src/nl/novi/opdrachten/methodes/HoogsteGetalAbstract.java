package nl.novi.opdrachten.methodes;

import java.util.List;
import java.util.Arrays;

/**
 * Schrijf een methode die een List Integer ontvangt.
 *
 * Wanneer er twee getallen of meer in zijn:
 * Return het volgende:
 * "Het hoogste getal van de gegeven getallen is: %GETAL%"
 *
 * Je mag hier geen Collections.sort of java.streams gebruiken.
 *
 */
public class HoogsteGetalAbstract {

    public static void main(String[] args) {
        System.out.println(highestNumber(Arrays.asList(149,8,11,35,249,49,456,3)));
    }

    public static String highestNumber(List<Integer> numbers) {
        int highest = 0;
        for(int number : numbers) {
            if(number > highest) {
                highest = number;
            }
        }
        return "Het hoogste getal van de gegeven getallen is: " + highest;
    }

}
