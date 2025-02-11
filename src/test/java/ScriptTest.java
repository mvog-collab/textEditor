import org.junit.jupiter.api.Test;
import replaceCommands.ReplaceTextCommand;
import capitalizeCommands.CapitalizeTextCommand;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import textCommand.TextCommand;

public class ScriptTest {

  @Test
  public void testExecuteSingleCommand() {
    // Test at Script kjører én kommando korrekt
    ReplaceTextCommand replaceCommand = new ReplaceTextCommand("hello", "hi");
    Script script = new Script(Arrays.asList(replaceCommand));

    String result = script.execute("hello world");
    assertEquals("hi world", result);  // "hello" skal erstattes med "hi"
  }

  @Test
  public void testExecuteMultipleCommands() {
    // Test at Script kjører flere kommandoer i riktig rekkefølge
    ReplaceTextCommand replaceCommand = new ReplaceTextCommand("hello", "hi");
    CapitalizeTextCommand capitalizeCommand = new CapitalizeTextCommand() {
      @Override
      public String execute(String text, String selection) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
      }
    };

    Script script = new Script(Arrays.asList(replaceCommand, capitalizeCommand));

    String result = script.execute("hello world");
    assertEquals("Hi world", result);  // "hello" skal erstattes med "hi" og deretter kapitaliseres første bokstav
  }

  @Test
  public void testExecuteEmptyCommands() {
    // Test at Script med tom liste av kommandoer returnerer input uendret
    Script script = new Script(Arrays.asList());
    String result = script.execute("hello world");
    assertEquals("hello world", result);  // Ingen kommandoer, returner original input
  }

  @Test
  public void testExecuteNullInput() {
    // Test at Script håndterer null-input
    ReplaceTextCommand replaceCommand = new ReplaceTextCommand("hello", "hi");
    Script script = new Script(Arrays.asList(replaceCommand));

    String result = script.execute(null);
    assertNull(result);  // Forvent at null returneres
  }

  @Test
  public void testExecuteEmptyInput() {
    // Test at Script håndterer tom input
    ReplaceTextCommand replaceCommand = new ReplaceTextCommand("hello", "hi");
    Script script = new Script(Arrays.asList(replaceCommand));

    String result = script.execute("");
    assertEquals("", result);  // Ingen tekst, skal returnere tomt resultat
  }

  @Test
  public void testExecuteCommandChain() {
    // Test at flere kommandoer fungerer som en kjede
    ReplaceTextCommand replaceCommand = new ReplaceTextCommand("hello", "hi");
    ReplaceTextCommand anotherReplaceCommand = new ReplaceTextCommand("world", "everyone");

    Script script = new Script(Arrays.asList(replaceCommand, anotherReplaceCommand));

    String result = script.execute("hello world");
    assertEquals("hi everyone", result);  // Først "hello" blir til "hi", deretter "world" blir til "everyone"
  }

  @Test
  public void testExecuteWithNullCommand() {
    // Test at Script håndterer en null-kommando på en fornuftig måte (kan kastes unntak eller returnere uendret)
    assertThrows(NullPointerException.class, () -> {
      Script script = new Script(Arrays.asList((TextCommand) null));
      script.execute("hello world");
    });
  }
}
