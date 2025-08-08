package View;

import java.util.Scanner;
import Model.Contact;

public class AddressBookView {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n=== Address Book Menu ===");
        System.out.println("1. Add Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Edit Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Search Contact");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Contact getContactInput() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        return new Contact(name, phone, email);
    }

    public String getContactName() {
        System.out.print("Enter contact name: ");
        return scanner.nextLine();
    }

    public String getUpdatedPhone() {
        System.out.print("Enter new phone: ");
        return scanner.nextLine();
    }

    public String getUpdatedEmail() {
        System.out.print("Enter new email: ");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showContact(Contact contact) {
        System.out.println(contact);
    }
}
