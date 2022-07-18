import java.util.Arrays;
import java.util.Scanner;

public class Connect4Application {
    public static void main(String[] args) {
        Board board = new Board();
        GameUtil.initBoard(board);
        Scanner in = new Scanner(System.in);
        Counter currentCounter = Counter.RED;

        while (true) {
            displayBoard(board.getBoard());
            System.out.println("Enter column to place counter");
            int column = in.nextInt();
            Point point = GameUtil.calculatePointFromColumn(board.getTransposedBoard(), column);
            board.setCell(currentCounter.toString(), point);
            if(GameUtil.checkGameWonForCurrentCounter(board.getBoard(), currentCounter))
                break;
            currentCounter = GameUtil.switchCounter(currentCounter);
        }
        System.out.println(currentCounter + " wins!");
    }

    private static void displayBoard(String[][] board) {
        for (String[] row: board) {
            System.out.println(Arrays.toString(row));
        }
    }


}