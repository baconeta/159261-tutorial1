import java.util.Random;
import java.util.Scanner;

public class RPS {

  public static void main(String[] args) {
    int playerScore = 0;
    int compScore = 0;
    while (playerScore < 3 && compScore < 3) {
      int playerMove = playerMove();
      int computerMove = computerMove();

      int result = checkResult(playerMove, computerMove);
      if (result == 1) {
        playerScore += 1;
        System.out.println("1 point to you!");
      } else if (result == 2) {
        compScore += 1;
        System.out.println("1 point to the computer!");
      } else {
        System.out.println("It was a draw... go again!");
      }

      System.out.println("Computer: " + compScore);
      System.out.println("You: " + playerScore);
      System.out.println();
    }
    if (playerScore == 3) System.out.println("You win!");
    if (compScore == 3) System.out.println("You lose!");
  }

  private static int computerMove() {
    int min = 1;
    int max = 3;
    Random r = new Random();
    int computer = r.nextInt((max - min) + 1) + min;

    if (computer == 1) {
      System.out.println("Computer played rock.");
    }
    if (computer == 2) {
      System.out.println("Computer played paper.");
    }
    if (computer == 3) {
      System.out.println("Computer played scissors.");
    }
    return computer;
  }

  public static int playerMove() {
    int move = 0;
    Scanner myObj = new Scanner(System.in);
    while (move == 0) {
      System.out.println("Enter a move (r,p,s): ");
      String input = myObj.nextLine();

      if (input.equalsIgnoreCase("r")) move += 1;
      if (input.equalsIgnoreCase("p")) move += 2;
      if (input.equalsIgnoreCase("s")) move += 3;
    }
    return move;
  }

  public static int checkResult(int player, int computer) {
    // Returns 0 for a draw, 1 for a player win and 2 for a computer win
    if (player == 1) {
      System.out.println("You played rock.");
      if (computer == 1) return 0;
      if (computer == 2) return 2;
      if (computer == 3) return 1;
    } else if (player == 2) {
      System.out.println("You played paper.");
      if (computer == 1) return 1;
      if (computer == 2) return 0;
      if (computer == 3) return 2;
    } else if (player == 3) {
      System.out.println("You played scissors.");
      if (computer == 1) return 2;
      if (computer == 2) return 1;
      if (computer == 3) return 0;
    }
    return 0;
  }
}
