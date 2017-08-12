import java.util.ArrayList;
import java.util.Scanner;

public class Contacts {
    private ArrayList<String> contacts = new ArrayList<String>();
    private String name;
    private String phone;
    private Scanner scan = new Scanner(System.in);
    private String[] currentContact = new String[2];

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
                    System.out.println("\n\n****************************\n\tExiting Mobile Phone\n****************************\n\t");
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
        System.out.print("Enter Name: ");
        String tempName = scan.next();
        scan.nextLine();
        System.out.print("Enter Phone: ");
        String tempPhone = scan.next();

        int tmpInt;
        //Can't do the following foreach loop below. contacts needs to be iterated though I believe.
        // In its current state the following throws:
        //      Exception in thread "main" java.util.ConcurrentModificationException
        //      at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
        //      at java.util.ArrayList$Itr.next(ArrayList.java:851)
        for (String w:contacts){
            if (w.contains(tempName) && w.contains(tempPhone)){
                String tmp = ("Name: " + tempName + "\t\t\tPhone: " + tempPhone);
                try {
                    contacts.remove(tmp);

                    System.out.println("\nContact Removed\n");
                    viewAllContact();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    private void addNewContact() {
        System.out.print("Enter New Contact Name: ");
        this.name = scan.next();
        //scan.nextLine();
        System.out.print("\nEnter A Number for " + this.name + ": ");
        this.phone = scan.next();
        if(checkIfExisting(this.name,this.phone)){
            System.out.println("\n--------------That contact already Exists---------------\n\n");
        }
        else {
            currentContact[0] = this.name;
            currentContact[1] = this.phone;
            String temp = ("Name: " + this.name + "\t\t\tPhone: " + this.phone);
            contacts.add(temp);
            currentContact[0] = "";
            currentContact[1] = "";
        }

    }

    private boolean checkIfExisting(String name, String phone){
        for (String w: contacts){
            if(w.contains(name) && w.contains(phone)){
                return true;
            }
        }
        return false;
    }

    private void viewAllContact() {
        System.out.println("\n\n----------View All Contacts----------\n");
        if (contacts.size() == 0) {
            System.out.println("No contacts yet");
        }
        for (String w : contacts) {
            System.out.println(w);
        }
        System.out.println("\n\n");
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
