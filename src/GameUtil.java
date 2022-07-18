import java.util.Arrays;

public class GameUtil {
    private static final int CHECK = 4;
    public static Point calculatePointFromColumn(String[][] board, int column) {
        int counter = 0;
        while(counter < board[column].length) {
            if (!board[column][counter].equals(Counter.EMPTY.toString()))
                break;
            else counter++;
        }
        return new Point(column, counter - 1);
    }

    public static void initBoard(Board board) {
        for (int y = 0; y < board.getHEIGHT(); y++) {
            for (int x = 0; x < board.getWIDTH(); x++) {
                board.setCell(Counter.EMPTY.toString(),new Point(x,y));
            }
        }
    }

    public static Counter switchCounter(Counter currentCounter) {
        if (currentCounter.equals(Counter.RED))
            return Counter.YELLOW;
        else return Counter.RED;
    }

    public static Boolean checkGameWonForCurrentCounter(String[][] board, Counter currentCounter) {
        //check right
        //check down
        //check diagonal up
        //check diagonal down
        String[] right = new String[CHECK];
        String[] down = new String[CHECK];
        String[] diagonalUp = new String[CHECK];
        String[] diagonalDown = new String[CHECK];
        String[][] all;

        String[] winCondition = initWinCondition(currentCounter);

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if(x < 4) {
                    right = new String[]{board[y][x], board[y][x+1], board[y][x+2], board[y][x+3]};
                    if (y > 2)
                        diagonalUp = new String[]{board[y][x], board[y-1][x+1], board[y-2][x+2], board[y-3][x+3]};
                    if (y < 3)
                        diagonalDown = new String[]{board[y][x], board[y+1][x+1], board[y+2][x+2], board[y+3][x+3]};
                }

                if(y < 3)
                    down = new String[]{board[y][x], board[y+1][x], board[y+2][x], board[y+3][x]};

                all = new String[][]{right,down,diagonalUp,diagonalDown};
                for (String[] direction : all)
                    if (Arrays.equals(direction, winCondition))
                        return true;
            }
        }
        return false;
    }

    private static String[] initWinCondition(Counter currentCounter) {
        String[] winCondition = new String[CHECK];
        for (int i = 0; i < 4; i++) {
            winCondition[i] = currentCounter.toString();
        }
        return winCondition;
    }
}
