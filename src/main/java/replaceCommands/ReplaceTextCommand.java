package replaceCommands;

import textCommand.TextCommand;

public class ReplaceTextCommand implements TextCommand {

  final private String target;
  final private String replacement;

  public ReplaceTextCommand(String target, String replacement) {
    this.target = target;
    this.replacement = replacement;
  }

  @Override
  public String execute(String text) {
    if (text == null || target == null) {
      return text;
    }
    return text.replace(target, replacement);
  }

  public String getTarget() {
    return target;
  }

  public String getReplacement() {
    return replacement;
  }
}