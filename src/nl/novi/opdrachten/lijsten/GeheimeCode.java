package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GeheimeCode {

    public static void main(String[] secret) {

        List<String> laResistanceMembers = new ArrayList<>();

        laResistanceMembers = addMembers(laResistanceMembers, "Arie");
        laResistanceMembers = addMembers(laResistanceMembers, "Sjaak");
        laResistanceMembers = addMembers(laResistanceMembers, "Henrie");
        laResistanceMembers = addMembers(laResistanceMembers, "Piet");
        laResistanceMembers = addMembers(laResistanceMembers, "LeDroitCestMoi");

        /*
        Opdracht 1: Hierboven zijn via de methode addMembers, leden aan de lijst toegevoegd. Pas de Methode zo aan dat
         er alleen unieke namen in voor mogen komen.
         */

        /*
        Opdracht 2: La Resistance wil niet dat de lijst met namen zo in handen komt te vallen van de bezetter. Versleutel
        Maak een methode die de lijst op de volgende manier versleuteld:
        a) Verander elke letter naar het nummer in het alfabet. Voeg na elke veranderde letter een - toe
        (behalve de laatste). Dus a wordt 1, b wordt 2 et cetera.
        Wanneer een letter een hoofdletter is, moet je beginnen met tellen bij 100. Dus A wordt 101, B wordt 102.
        Voorbeeld: Alex wordt versleuteld naar: 101-12-5-24
        b) Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
         */

        List<String> encryptedMembers = encryptList(laResistanceMembers);
        System.out.println("Encrypted list: ");
        for (String member : encryptedMembers) {
            System.out.println(member);
        }
        System.out.println("\n");

    }

    private static List<String> addMembers(List<String> members, String name) {
        if(!members.contains(name)) {
            members.add(name);
        }

        return members;
    }

    public static List<String> encryptList(List<String> members) {
        List<String> encryptedList = new ArrayList<>();

        for(String member : members) {
            encryptedList.add(encryptName(member));
        }

        for (int i = 0; i < encryptedList.size(); i++) {
            if(i % 2 == 0) {
                encryptedList.set(i, reverseEncryptedName(encryptedList.get(i)));
            }
        }

        return encryptedList;
    }

    private static String encryptName(String name) {
        StringBuilder encryptedName = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            String number = charToNumber(name.charAt(i));
            encryptedName.append(number);
            if(i < name.length() - 1) {
                encryptedName.append("-");
            }
        }
        return encryptedName.toString();
    }

    private static String reverseEncryptedName(String encryptedName) {
        String[] splitString = encryptedName.split("-");
        String[] reversedString = new String[splitString.length];

        for (int i = 0; i < splitString.length; i++) {
            reversedString[splitString.length - 1 - i] = splitString[i];
        }

        return String.join("-", reversedString);
    }

    public static String charToNumber(char character){
        char tempChar = Character.toLowerCase(character);
        int number = tempChar - 'a' + 1;

        if(Character.isUpperCase(character)) {
            number = number + 100;
        }

        return Integer.toString(number);
    }


}
