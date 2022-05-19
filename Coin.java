
public class Coin {
  private String ANSI_RESET = "\u001B[0m";
  private String ANSI_RED = "\u001B[31m";
  private String ANSI_GREEN = "\u001B[32m";
  private boolean isPlayer = false;
  
  public String GetCoinString() {

    if (isPlayer == true) {
      return ANSI_RED + " 0 " + ANSI_RESET;
    } else {
      return ANSI_GREEN + " 0 " + ANSI_RESET;
    }
  }

  public boolean getIsPlayer() {
    return this.isPlayer;
  }

  public void setIsPlayer(boolean isPlayer) {
    this.isPlayer = isPlayer;
  }

}