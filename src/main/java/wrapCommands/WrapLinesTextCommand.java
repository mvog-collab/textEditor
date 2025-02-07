package wrapCommands;

public class WrapLinesTextCommand extends WrapTextCommand{

  public WrapLinesTextCommand(String opening, String ending) {
    super(opening, ending);
  }

  @Override
  public String executes(String text) {
    String[] lines = text.split("\n");
    StringBuilder wrappedText = new StringBuilder();

    for (int i = 0; i < lines.length; i++) {
      wrappedText.append(getOpening()).append(lines[i]).append(getEnding());
      if (i < lines.length - 1) {
        wrappedText.append("\n");
      }
    }
    return wrappedText.toString();
  }
}
