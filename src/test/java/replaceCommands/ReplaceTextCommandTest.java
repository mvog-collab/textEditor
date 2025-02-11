package replaceCommands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReplaceTextCommandTest {

  @Test
  public void testReplaceTextNormal() {
    ReplaceTextCommand command = new ReplaceTextCommand("hello", "hi");
    String result = command.execute("hello world");
    assertEquals("hi world", result);
  }

  @Test
  public void testReplaceTextMultipleOccurrences() {
    ReplaceTextCommand command = new ReplaceTextCommand("world", "earth");
    String result = command.execute("hello world, world!");
    assertEquals("hello earth, earth!", result);
  }

  @Test
  public void testReplaceTextNoOccurrence() {
    ReplaceTextCommand command = new ReplaceTextCommand("goodbye", "farewell");
    String result = command.execute("hello world");
    assertEquals("hello world", result);
  }

  @Test
  public void testReplaceTextEmptyString() {
    ReplaceTextCommand command = new ReplaceTextCommand("hello", "hi");
    String result = command.execute("");
    assertEquals("", result);
  }

  @Test
  public void testReplaceTextNullText() {
    ReplaceTextCommand command = new ReplaceTextCommand("hello", "hi");
    String result = command.execute(null);
    assertNull(result);
  }

  @Test
  public void testReplaceTextNullTarget() {
    ReplaceTextCommand command = new ReplaceTextCommand(null, "hi");
    String result = command.execute("hello world");
    assertEquals("hello world", result);
  }

  @Test
  public void testReplaceTextWithSpecialCharacters() {
    ReplaceTextCommand command = new ReplaceTextCommand("hello!", "hi?");
    String result = command.execute("hello! world");
    assertEquals("hi? world", result);
  }
}