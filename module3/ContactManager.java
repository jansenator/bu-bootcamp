/**
 * ContactManager.java
 * Stores Contact objects in a HashMap keyed by name, supports lookup
 * by name, and prints all contacts sorted alphabetically.
 *
 * @author Jansen Rensma
 * Note: a GitHub Copilot "learn" agent was referenced while writing this
 * code; it teaches the concepts involved rather than providing answers.
 */
import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "111-1111"));
        contacts.put("Tom Petty", new Contact("Tom Petty", "222-2222"));
        contacts.put("Bob McDogul", new Contact("Bob McDogul", "333-3333"));
        contacts.put("Zanyda Kline", new Contact("Zanyda Kline", "444-4444"));
        contacts.put("James Frank", new Contact("James Frank", "555-5555"));

        // Step 5: look up a contact
        // Get contacts
        Contact contact = contacts.get("Ada Lovelace");
        Contact contact1 = contacts.get("Sara Thompson");

        // if null
        if (contact == null) {
            System.out.println("Contact not found");
        // if not null print object using toString from contact.java
        } else {
            System.out.println(contact.toString());
        }

        // if null
        if (contact1 == null) {
            System.out.println("Contact not found");
        // if not null print object using toString from contact.java
        } else {
            System.out.println(contact1.toString());
        }

        // Step 6: print sorted list

        // put all Contacts into an ArrayList; contact.value has no keys - just the values
        // so just the names;
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        // labmda expression
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("");
        System.out.println("=== All Contacts ===");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}