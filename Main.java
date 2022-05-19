import java.util.Scanner;

// import java.util.*;
import java.util.Random;

class Main {
  public static Scanner userInput;
  public static Random rand;
  public static void main(String[] args) {
    // System.out.println("Hello world!");
    userInput = new Scanner(System.in);
    rand = new Random();
    new Game();
  }
}



