public class WrapTextCommand implements TextCommand {

  private final String opening;
  private final String ending;

  public WrapTextCommand(String opening, String ending) {
    this.ending = ending;
    this.opening = opening;
  }

  @Override
  public String execute(String text) {
    if (text == null || ending == null || opening == null) {
      return text;
    }
    return (opening + text + ending);
  }


    public String getOpening(){
      return opening;
    }

    public String getEnding() {
      return ending;
    }
  }



