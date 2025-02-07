package capitalizeCommands;

import java.util.Locale;
import textCommand.TextCommand;

public abstract class CapitalizeTextCommand implements TextCommand {

  @Override
  public String execute(String text) {
    return text.substring(0, 1).toUpperCase() + text.substring(1);
  }

  public abstract String execute(String text, String selection);
}
