import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

  private Contact contact;
  private Contact contact1;

  @BeforeEach
  void setUp() {
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  }

  @Test
  void sameNameDifferentContactObjects_areIndependent() {
    Contact contact1 = new Contact("Ada Lovelace", "+1 617 555 0202");
    contact1.setName("Travis Champ");
    assertEquals("Ada Lovelace", contact.getName());
    assertEquals("Travis Champ", contact1.getName());
  }

  @Test
  void getName_returnsCorrectName() {
    assertEquals("Ada Lovelace", contact.getName());
  }

  @Test
  void getPhone_returnsCorrectPhone() {
    assertEquals("+1 617 555 0101", contact.getPhone());
  }

  @Test
  void toString_containsBothFields() {
    assertTrue(contact.toString().contains("Ada Lovelace"));
    assertTrue(contact.toString().contains("+1 617 555 0101"));
  }
}