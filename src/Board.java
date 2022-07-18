/**
 * Could be made as an array of stacks but is generic to showcase its possible application for other games
 */
public class Board {
    private final String[][] board;
    private final int HEIGHT = 6;
    private final int WIDTH = 7;

    public Board(){
        board = new String[HEIGHT][WIDTH];
    }

    public void setCell(String s, Point p) {
        board[p.getY()][p.getX()] = s;
    }

    public String getCell(Point p) {
        return board[p.getX()][p.getY()];
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public String[][] getBoard() {
        return board;
    }

    public String[][] getTransposedBoard() {
        String[][] transposedBoard = new String[WIDTH][HEIGHT];

        for(int x = 0; x < WIDTH; x++) {
            for(int y = 0; y < HEIGHT; y++) {
                transposedBoard[x][y] = board[y][x];
            }
        }

        return transposedBoard;
    }
}
