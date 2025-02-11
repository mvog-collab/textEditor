package capitalizeCommands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CapitalizeTextCommandTest {

  // Konkret implementasjon for å teste de abstrakte metodene
  private static class ConcreteCapitalizeTextCommand extends CapitalizeTextCommand {

    @Override
    public String execute(String text, String selection) {
      if (text == null || selection == null || selection.isEmpty()) {
        return text; // Håndterer ugyldige tilfeller
      }

      // For enkelhets skyld, antar at selection er et ord i teksten
      int start = text.indexOf(selection);
      if (start == -1) {
        return text; // Hvis utvalget ikke finnes i teksten, returner originalen
      }

      String before = text.substring(0, start);
      String selected = selection.substring(0, 1).toUpperCase() + selection.substring(1);
      String after = text.substring(start + selection.length());
      return before + selected + after;
    }
  }

  // Test for execute(String text)
  @Test
  public void testCapitalizeNormalText() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute("hello");
    assertEquals("Hello", result);
  }

  @Test
  public void testCapitalizeAlreadyCapitalizedText() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute("Hello");
    assertEquals("Hello", result);
  }

  @Test
  public void testCapitalizeEmptyString() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute(" ");
    assertEquals(" ", result);
  }

  @Test
  public void testCapitalizeSingleCharacter() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute("a");
    assertEquals("A", result);
  }

  @Test
  public void testCapitalizeNonAlphaCharacter() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute("1apple");
    assertEquals("1apple", result);
  }

  // Test for execute(String text, String selection)
  @Test
  public void testCapitalizeSelectionNormal() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute("hello world", "world");
    assertEquals("hello World", result);
  }

  @Test
  public void testCapitalizeSelectionEmpty() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute("hello world", "");
    assertEquals("hello world", result);  // Ingen endring ved tomt utvalg
  }

  @Test
  public void testCapitalizeSelectionOutOfBounds() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute("hello world", "universe");
    assertEquals("hello world", result);  // Utvalget finnes ikke i teksten, ingen endring
  }

  @Test
  public void testCapitalizeSelectionNullText() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute(null, "world");
    assertNull(result);  // Hvis teksten er null, skal resultatet være null
  }

  @Test
  public void testCapitalizeSelectionNullSelection() {
    CapitalizeTextCommand command = new ConcreteCapitalizeTextCommand();
    String result = command.execute("hello world", null);
    assertEquals("hello world", result);  // Hvis selection er null, skal original teksten returneres
  }
}
