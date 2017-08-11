import java.util.ArrayList;
import java.util.Scanner;

public class Contacts {
    private ArrayList<String> contacts = new ArrayList<String>();
    private String name;
    private String phone;
    private Scanner scan = new Scanner(System.in);

    public Contacts() {

    }

    private String printChoices() {
        String menu = "Enter 1 to View All Contact\n" +
                "Enter 2 To Add New Contact\n" +
                "Enter 3 To Remove A Contact\n" +
                "Enter 4 to Update Existing Contacts\n" +
                "Enter 5 To Quit\n" +
                "\t\tEnter Choice: ";
        return menu;
    }

    private void determineChoice(int choice) {
            switch (choice) {
                case 1:
                    viewAllContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    updateExisting();
                    break;
                case 5:
                    System.out.println("\n\n************************\n\tExiting Mobile Phone\n\n************************\n\t");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\n**********************\n\tInvalid Input\n**********************\n\n");
            }
        }
    private void updateExisting() {
        System.out.println("\n\n***********************************\n\tUpdating Existing Contact\n***********************************\n");
    }

    private void removeContact() {
        System.out.println("\n\n----------Removing Contact----------\n");
    }

    private void addNewContact() {
        System.out.println("\n\n----------Adding New Contact----------\n");

    }

    private void viewAllContact() {
        System.out.println("\n\n----------View All Contacts----------\n");
        if (contacts.size() == 0) {
            System.out.println("No contacts yet");
        }
        for (String w : contacts) {
            System.out.println(w);
        }
    }

    public void menu() {
        boolean flag = true;
        while (flag) {
            System.out.print(printChoices());
            int choice = scan.nextInt();
            determineChoice(choice);
        }
    }
}
