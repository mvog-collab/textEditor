package wrapCommands;

public class WrapSelectionTextCommand extends WrapTextCommand{
  private final String selection;

  public WrapSelectionTextCommand(String opening, String ending, String selection) {
    super(opening, ending);
    this.selection = selection;
  }

  public String getSelection() {
    return selection;
  }
  @Override
  public String executes(String text) {
    if (!text.contains(selection)) {
      return text;
    }
    return text.replace(selection, getOpening() + selection + getEnding());
  }
}
