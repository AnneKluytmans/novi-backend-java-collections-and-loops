package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOefening {

    public static void main(String[] uitlegList) {

        //We hebben een list die de namen van voetbalclubs bevat
        List<String> clubNames = new ArrayList<>();
        //Die vullen we alvast voor de opdracht
        clubNames.add("Ajax");
        clubNames.add("PSV");
        clubNames.add("Feyenoord");
        clubNames.add("Fc Utrecht");
        clubNames.add("Fc Groningen");
        clubNames.add("FC Twente");

        // Vraag -1: Maak een methode die als taak heeft om de list per regel uit te printen.

        printList(clubNames);
        System.out.println("\n");

        // Vraag 0: Maak een methode die als taak heeft om de list uit te printen: positie + inhoud.
        // Bovenstaande list zou dan dit zijn:
        // 0 - Ajax
        // 1 - PSv
        // etc...

        printListAndIndex(clubNames);
        System.out.println("\n");

        // Vraag 1: Maak een methode die checkt of een club al in de lijst zit en voeg deze anders toe.

        addClub(clubNames, "Ado Den Haag");
        addClub(clubNames, "Real Madrid");
        printList(clubNames);
        System.out.println("\n");

        // Vraag 2: Maak een methode die de positie van de club in de lijst teruggeeft.

        int indexOfPsv = returnIndex(clubNames, "psv");
        System.out.println("PSV staat op plek " + (indexOfPsv + 1) + " in de lijst.");
        System.out.println("\n");

        // Vraag 3: Maak een methode die de lijst alfabetisch sorteert. Wanneer Ajax niet op positie 1 staat, moeten de
        // clubs die voor Ajax staan verwijderd worden.
        // We voegen nog wat clubs toe om de code te kunnen testen.
        clubNames.add("AA Aachen");
        clubNames.add("AFC Amsterdam");
        clubNames.add("AFC");

        sortListAjaxFirst(clubNames);
        System.out.println("Sorted list with Ajax first: ");
        printList(clubNames);
        System.out.println("\n");

        // Vraag 4: Kun je hetzelfde doen als hierboven, maar PSV moet dan laatste zijn.
        clubNames.add("Zlotty FC");
        clubNames.add("SC Eindhoven");

        sortListPsvLast(clubNames);
        System.out.println("Sorted list with PSV last: ");
        printList(clubNames);
        System.out.println("\n");
    }

    public static void printList(List<String> clubs) {
        System.out.println("Clubs overview: ");
        for (String club : clubs) {
            System.out.println(club);
        }
    }

    public static void printListAndIndex(List<String> clubs) {
        System.out.println("Clubs overview: ");
        for (int i = 0; i < clubs.size(); i++) {
            System.out.println(i + " - " + clubs.get(i));
        }
    }

    public static void addClub(List<String> clubs, String name) {
        if (!clubs.contains(name)) {
            clubs.add(name);
        }
    }

    public static int returnIndex(List<String> clubs, String name) {
        for (int i = 0; i < clubs.size(); i++) {
            if(name.equalsIgnoreCase(clubs.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void sortListAjaxFirst(List<String> clubs) {
        Collections.sort(clubs);

        while (returnIndex(clubs, "Ajax") != 0) {
            clubs.removeFirst();
        }
    }

    public static void sortListPsvLast(List<String> clubs) {
        Collections.sort(clubs);

        while (returnIndex(clubs, "PSV") != clubs.size() - 1) {
            clubs.removeLast();
        }
    }



}
