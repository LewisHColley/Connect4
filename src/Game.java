import java.util.Arrays;

public class Game {

    private Board board;
    private Counter currentCounter;
    private final Connect4Application application;

    private final int CHECK = 4;

    public Game(Connect4Application application) {
        this.application = application;
        setupGame();
    }

    private void setupGame() {
        board = initBoard();
        currentCounter = Counter.RED;
        run();
    }

    private void run() {
        int column;
        Point point;
        while (true) {
            application.displayBoard(board.getBoard());
            column = application.getInput();
            point = calculatePointFromColumn(board.getTransposedBoard(), column);
            board.setCell(currentCounter.toString(), point);
            if(checkGameWonForCurrentCounter(board.getBoard(), currentCounter))
                break;
            currentCounter = switchCounter(currentCounter);
        }
        System.out.println(currentCounter + " wins!");
    }

    private Point calculatePointFromColumn(String[][] board, int column) {
        int counter = 0;
        while(counter < board[column].length) {
            if (!board[column][counter].equals(Counter.EMPTY.toString()))
                break;
            else counter++;
        }
        return new Point(column, counter - 1);
    }

    private Board initBoard() {
        int BOARD_HEIGHT = 6;
        int BOARD_WIDTH = 7;
        board = new Board(BOARD_HEIGHT, BOARD_WIDTH);
        for (int y = 0; y < board.getHEIGHT(); y++) {
            for (int x = 0; x < board.getWIDTH(); x++) {
                board.setCell(Counter.EMPTY.toString(),new Point(x,y));
            }
        }
        return board;
    }

    private Counter switchCounter(Counter currentCounter) {
        if (currentCounter.equals(Counter.RED))
            return Counter.YELLOW;
        else return Counter.RED;
    }

    private Boolean checkGameWonForCurrentCounter(String[][] board, Counter currentCounter) {
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

    private String[] initWinCondition(Counter currentCounter) {
        String[] winCondition = new String[CHECK];
        for (int i = 0; i < 4; i++) {
            winCondition[i] = currentCounter.toString();
        }
        return winCondition;
    }
}
