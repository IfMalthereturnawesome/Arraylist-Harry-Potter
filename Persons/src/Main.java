import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String RESET = "\033[0m";
    public static final String WHITE_BACKGROUND = "\033[47m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public ArrayList<Person> person;
    public ArrayList<Person> kol;


    public Main() {
        this.person = new ArrayList<Person>();


        person.add(new Person("Harry", " Potter", " Gryffindor"));
        person.add(new Person("Parvati", " Patil", " Gryffindor"));
        person.add(new Person("Draco", " Malfoy", " Slytherin"));
        person.add(new Person("Luna", " Lovegood", " Ravenclaw"));
        person.add(new Person("Padma", " Patil ", " Ravenclaw"));


    }

    public void printAll(ArrayList p) {
        setPerson(person);
        System.out.println(personList());
        System.out.println("\n--------------------------------------------\n");
    }

    public void printtAll(String p) {
        setPerson(person);
        System.out.println(personList());
        System.out.println("\n--------------------------------------------\n");
    }


    public void firstNamePrint() {
        Scanner input = new Scanner(System.in);
        System.out.println(ANSI_RED + "Type one of the students first name" + ANSI_RESET);
        String user = input.next();
        if (user.equalsIgnoreCase(person.get(0).getFirstName())) {
            System.out.print(person.get(0).getFirstName());
            System.out.print(person.get(0).getLastName());
            System.out.println(" From the house" + person.get(0).getHouse());

        } else if (user.equalsIgnoreCase(person.get(1).getFirstName())) {
            System.out.print(person.get(1).getFirstName());
            System.out.print(person.get(1).getLastName());
            System.out.println(" From the house" + person.get(1).getHouse());
        } else if (user.equalsIgnoreCase(person.get(2).getFirstName())) {
            System.out.print(person.get(2).getFirstName());
            System.out.print(person.get(2).getLastName());
            System.out.println(" From the house" + person.get(2).getHouse());
        } else if (user.equalsIgnoreCase(person.get(3).getFirstName())) {
            System.out.print(person.get(3).getFirstName());
            System.out.print(person.get(3).getLastName());
            System.out.println(" From the house" + person.get(3).getHouse());
        } else if (user.equalsIgnoreCase(person.get(4).getFirstName())) {
            System.out.print(person.get(4).getFirstName());
            System.out.print(person.get(4).getLastName());
            System.out.println("From the house" + person.get(4).getHouse());
        } else {
            System.out.println("not valid");
        }
    }


    public String kollegie(String kolle) {
        System.out.println("\n--------------------------------------------\n");
        System.out.println(ANSI_GREEN + "These are the persons in the house specified " + ANSI_RESET);

        this.kol = new ArrayList<>();
        for (Person kl : person) {
            if (kl.getHouse().toUpperCase().contains(kolle.toUpperCase())) {
                kol.add(kl);

            }

        }
        return kol.toString().replace("[", "")
                .replace("]", "").replace(", ", "\n");
    }

    public void delete(String fName) {
        person.remove(findFirstNames(fName));
    }

    public Person findFirstNames(String fName) {

        for (Person find : person) {
            if (find.getFirstName().toUpperCase().contains(fName.toUpperCase())) {
                System.out.println(ANSI_RED + find + ANSI_RESET);
                return find;
            }
        }

        return null;
    }


    public String personList() {
        String list = Arrays.toString(person.toArray()).replace(", ", "\n");
        return list.substring(1, list.length() - 1);
    }

    public void morePersons(String firstName, String lastName, String house) {
        person.add(new Person(firstName, lastName, house));

    }

    public Person makeNewHouse(String fName, String lName, String house) {
        for (Person nhouse : person) {
            if (nhouse.getFirstName().toUpperCase().contains(fName.toUpperCase())) {
                nhouse.setHouse(house);
                return nhouse;
            }
        }
        return null;
    }

    public void userAdd() {
        Scanner user = new Scanner(System.in);
        String addSpace = " ";

        System.out.println("Add a first Name then press Enter");
        String firstN = user.nextLine();
        System.out.println("Add a Last Name then press Enter");
        String lastN = addSpace + user.next();
        System.out.println("Assign a House Name then press Enter");
        String house = addSpace + user.next();

        morePersons(firstN, lastN, house);
        System.out.println("\n--------------------------------------------");
        System.out.println(ANSI_GREEN+"Ehhmm, We have room for one more student, please add"+ANSI_RESET);
        System.out.println("--------------------------------------------");

        System.out.println("Add a first Name then press Enter");
        firstN = user.next();
        System.out.println("Add a Last Name then press Enter");
        lastN = addSpace + user.next();
        System.out.println("Assing a House Name then press Enter");
        house = addSpace + user.next();

        morePersons(firstN, lastN, house);

    }

    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();
        // Method 1

        System.out.println(ANSI_GREEN + "Here is all the students for this year" + ANSI_RESET);
        main.printAll(main.person);


        // Method 2 with input
        main.firstNamePrint();
        System.out.println("\n--------------------------------------------\n");

        // Method 2 Normal
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(ANSI_GREEN + "Here is the name you asked for earlier.." + ANSI_RESET);
        main.findFirstNames("Harry");

        // Method 3
        TimeUnit.MILLISECONDS.sleep(4000);
        System.out.println(main.kollegie("ravenclaw"));
        System.out.println("\n--------------------------------------------\n");

        // Method 4
        TimeUnit.MILLISECONDS.sleep(5000);
        System.out.println(ANSI_GREEN + "The train were late, here is the updated list" +
                " with all the students" + ANSI_RESET);
        main.morePersons(ANSI_BLACK + ANSI_WHITE_BACKGROUND +
                "Helga", " Hufflepuf", " Hufflepuf" + RESET);
        main.morePersons(ANSI_BLACK + WHITE_BACKGROUND +
                "Petter", " Pettigrew", " Slytherin" + RESET);
        main.printAll(main.person);

        // Method 5 to show the deleted person in red.
        TimeUnit.MILLISECONDS.sleep(5000);
        System.out.println(ANSI_GREEN + "A student got expelled! " + ANSI_RESET);
        main.delete("Luna");
        main.printAll(main.person);
        main.delete("Luna");

        // Still Method 5
        TimeUnit.MILLISECONDS.sleep(5000);
        System.out.println(ANSI_GREEN + "Here is the updated list of students you asked for" + ANSI_RESET);
        main.printtAll(ANSI_RESET + main.person + RESET);

        // Method 6
        TimeUnit.MILLISECONDS.sleep(5000);
        System.out.println(ANSI_GREEN + "Ups, the sorting hat changed its mind.." + ANSI_RESET);
        main.makeNewHouse("Harry", " Potter", " Slytherin");
        main.printAll(main.person);

        // Add user
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println(ANSI_GREEN + "We need a few more students, time to Recruit more wizards" + ANSI_RESET);
        main.userAdd();
        System.out.println("\n--------------------------------------------\n");
        System.out.println(ANSI_GREEN+"Here is the updated list with the requested students, Sir"+ANSI_RESET);
        main.printAll(main.person);

        // See where the students are assigned to
        System.out.println("Give me a second to write them into the system");
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println(main.kollegie("Gryffindor"));


    }

    ArrayList getPerson() {
        return person;
    }

    ArrayList setPerson(ArrayList aPerson) {
        person = aPerson;
        return aPerson;
    }

}
