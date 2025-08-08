
package Controller;

import java.util.ArrayList;
import Model.Contact;
import View.AddressBookView;

public class AddressBookController {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private AddressBookView view = new AddressBookView();

    public void run() {
        while (true) {
            int choice = view.showMenu();
            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewAllContacts();
                case 3 -> editContact();
                case 4 -> deleteContact();
                case 5 -> searchContact();
                case 6 -> {
                    view.showMessage("Exiting...");
                    return;
                }
                default -> view.showMessage("Invalid choice. Try again.");
            }
        }
    }

    private void addContact() {
        Contact newContact = view.getContactInput();
        contacts.add(newContact);
        view.showMessage("Contact added successfully.");
    }

    private void viewAllContacts() {
        if (contacts.isEmpty()) {
            view.showMessage("No contacts available.");
        } else {
            for (Contact c : contacts) {
                view.showContact(c);
            }
        }
    }

    private void editContact() {
        String name = view.getContactName();
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.setPhone(view.getUpdatedPhone());
                c.setEmail(view.getUpdatedEmail());
                view.showMessage("Contact updated.");
                return;
            }
        }
        view.showMessage("Contact not found.");
    }

    private void deleteContact() {
        String name = view.getContactName();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                view.showMessage("Contact deleted.");
                return;
            }
        }
        view.showMessage("Contact not found.");
    }

    private void searchContact() {
        String name = view.getContactName();
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                view.showContact(c);
                return;
            }
        }
        view.showMessage("Contact not found.");
    }
}
