package capitalizeCommands;

public abstract class CapitalizeSelectionTextCommand extends CapitalizeTextCommand{
  private final String selection;

  public CapitalizeSelectionTextCommand(String selection) {
    this.selection = selection;
  }

  public String getSelection() {
    return selection;
  }

  @Override
  public String execute(String text) {
    if (selection == null || selection.isEmpty()) {
      return text;
    }
    return text.replaceAll("\\b" + selection + "\\b",
        selection.substring(0, 1).toUpperCase() + selection.substring(1));
  }
}