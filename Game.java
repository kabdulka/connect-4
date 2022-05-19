public class Game {

  int[] row = new int[10];
  Coin[][] board = new Coin[8][5];
  private boolean gameWon = false;

  public Game() {
    // System.out.println("The game constructor is instantiend");

    while (true) {
      displayBoard();
      System.out.println("Enter a column number you'd like to place your coin");
      playerMove();
      if (gameWon) {
        displayBoard();
        System.out.println("You have won the game!");
        return;
      }
      AIMove();
      if (gameWon) {
        displayBoard();
        System.out.println("The AI has won the game!");
        return;
      }
    }

  }

  private void displayBoard() {
    for (int i = 0; i < board[i].length; i++) {
      for (int j = 0; j < board.length; j++) {
        Coin currentCoin = board[j][i];
        if (currentCoin == null) {
          System.out.print(" 0 ");
        } else {
          System.out.print(currentCoin.GetCoinString());
        }
      }
      System.out.println();
    }

    System.out.println();
    System.out.println();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        Coin currentC = board[i][j];
        if (currentC == null) {
          System.out.print(" 0 ");
        } else {
          System.out.print(currentC.GetCoinString());
        }
      }
      System.out.println();
    }

  }

  // int[] arr = new int[5];
  // arr[2] = 20;
  private void insertCoin(int column, boolean isPlayer) {
    Coin c = new Coin();
    c.setIsPlayer(isPlayer);
    // c.isPlayer = isPlayer;
    for (int i = board[column].length-1; i >= 0; i--) {
      // null
      if (board[column][i] == null) {
        board[column][i] = c;
        checkVictory(column, i);
        return;
      }
      
    }

  }

  // declaring the function
  // means defining or creating a function
  private void playerMove() {
    try {
      String userInput = Main.userInput.nextLine();
      int playerColumn = Integer.parseInt(userInput);
      insertCoin(playerColumn, true);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      playerMove();
    }
  
  }

  private void AIMove() {
    int col = Main.rand.nextInt(board.length);
    // we called the insertCoin function
    insertCoin(col, false);
  }

  private void checkVictory(int x, int y) {
    checkNeighbour(1, x, y, 1, 0);
    checkNeighbour(1, x, y, -1, 0);
    checkNeighbour(1, x, y, -1, 1);
    checkNeighbour(1, x, y, -1, -1);
    checkNeighbour(1, x, y, 1, -1);
    checkNeighbour(1, x, y, 1, 1);
    checkNeighbour(1, x, y, 0, 1);
    checkNeighbour(1, x, y, 0, -1);
    
  }

  private void checkNeighbour(int nInRow, int posX, int posY, int dirX, int dirY) {
    Coin currentCoin = board[posX][posY];
    posX += dirX;
    posY += dirY;

    if (posX < 0 || posX >= board.length || posY < 0 || posY >= board[0].length) {
      return;
    }
    
    Coin neighbour = board[posX][posY];

    if (neighbour == null) {
      return;
    }
    if (currentCoin.getIsPlayer() != neighbour.getIsPlayer()) {
      return;
    }

    nInRow++;

    if (nInRow == 3) {
      // recursively call checkNeighbour
      checkNeighbour(nInRow, posX, posY, -dirX*3, -dirY*3);
    }
    
    if (nInRow == 4) {
      gameWon = true;
      return;
    }
    
    // make the recursive call here to check every neighbour in a direction
    checkNeighbour(nInRow, posX, posY, dirX, dirY);
    
  }
  
}



  






