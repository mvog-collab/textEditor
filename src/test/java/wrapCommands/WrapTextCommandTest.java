package wrapCommands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WrapTextCommandTest {

  private WrapTextCommand command;

  @BeforeEach
  void setUp() {
    // Oppretter en anonym subklasse av WrapTextCommand for testing før hver test
    command = new WrapTextCommand("<b>", "</b>") {
      @Override
      public String executes(String text) {
        return execute(text);
      }
    };
  }

  @Test
  void testExecuteWithValidText() {
    String result = command.execute("bold text");
    assertEquals("<b>bold text</b>", result);
  }

  @Test
  void testExecuteWithNullText() {
    String result = command.execute(null);
    assertNull(result);  // Forventer at null forblir null
  }

  @Test
  void testExecuteWithEmptyText() {
    String result = command.execute("");
    assertEquals("<b></b>", result);
  }

  @Test
  void testGetOpening() {
    WrapTextCommand command = new WrapTextCommand("<p>", "</p>") {
      @Override
      public String executes(String text) {
        return execute(text);
      }
    };

    assertEquals("<p>", command.getOpening());
  }

  @Test
  void testGetEnding() {
    WrapTextCommand command = new WrapTextCommand("<p>", "</p>") {
      @Override
      public String executes(String text) {
        return execute(text);
      }
    };

    assertEquals("</p>", command.getEnding());
  }
}
