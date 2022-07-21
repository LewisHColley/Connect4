public class Board {
    private final String[][] board;
    private final int HEIGHT;
    private final int WIDTH;

    public Board(int height, int width){
        HEIGHT = height;
        WIDTH = width;
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
