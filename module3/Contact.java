/**
 * Contact.java
 * A single contact entry: a name and phone number, with getters
 * and a readable toString() for printing.
 *
 * @author Jansen Rensma
 * Note: a GitHub Copilot "learn" agent was referenced while writing this
 * code; it teaches the concepts involved rather than providing answers.
 */
public class Contact {
    // Declarations
    private String name;
    private String phone;

    // Constructors
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters
    public String getName() { return name; }
    public String getPhone() { return phone; }

    // what to print when an instance of Contact using toString()
    @Override
    public String toString() {
        return name + " | " + phone;
    }
}
