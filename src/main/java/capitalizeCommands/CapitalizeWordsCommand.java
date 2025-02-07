package capitalizeCommands;

public abstract class CapitalizeWordsCommand extends CapitalizeTextCommand {

  @Override
  public String execute(String text) {
    String[] words = text.split("\\s+");
    StringBuilder result = new StringBuilder();

    for (String word : words) {
      if (!word.isEmpty()) {
        result.append(word.substring(0, 1).toUpperCase())
            .append(word.substring(1))
            .append(" ");
      }
    }
    return result.toString().trim();
  }
}