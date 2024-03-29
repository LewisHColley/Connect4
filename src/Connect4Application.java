import java.util.Arrays;
import java.util.Scanner;

public class Connect4Application {
    Scanner in = new Scanner(System.in);
    public Connect4Application() {
        new Game(this);
    }

    public int getInput() {
        System.out.println("Enter column (0-6) to place counter");
        return in.nextInt();
    }

    public void displayBoard(String[][] board) {
        for (String[] row: board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        new Connect4Application();
    }

}