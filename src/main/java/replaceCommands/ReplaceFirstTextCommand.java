package replaceCommands;

public class ReplaceFirstTextCommand extends ReplaceTextCommand {

  public ReplaceFirstTextCommand(String target, String replacement) {
    super(target, replacement);
  }

  @Override
  public String execute(String text) {
    if (text == null || getTarget() == null || getReplacement() == null) {
      return text;
    }
    return text.replaceFirst(getTarget(), getReplacement());
  }
}

