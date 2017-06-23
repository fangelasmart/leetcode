package main.java.category;

/**
 * 规则：
 * 标准数独由9行，9列共81的小格子构成。
 * 分别在格子中填入1到9的数字，并满足下面的条件。
 * <p>
 * 每一行都用到1,2,3,4,5,6,7,8,9
 * 每一列都用到1,2,3,4,5,6,7,8,9
 * 每3×3的格子都用到1,2,3,4,5,6,7,8,9
 * <p>
 * Created by angela on 17/6/22.
 */
public class Sudoku {

    private int[][] board;
    private int[][] result;

    private boolean[][] row;
    private boolean[][] col;
    private boolean[][] b;
    private int[][] block;


    public Sudoku(int[][] board) {
        this.board = board;
        this.result = new int[10][10];
        this.row = new boolean[10][10];
        this.col = new boolean[10][10];
        this.b = new boolean[10][10];
        this.block = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 2, 2, 2, 3, 3, 3},
                {0, 1, 1, 1, 2, 2, 2, 3, 3, 3},
                {0, 1, 1, 1, 2, 2, 2, 3, 3, 3},
                {0, 4, 4, 4, 5, 5, 5, 6, 6, 6},
                {0, 4, 4, 4, 5, 5, 5, 6, 6, 6},
                {0, 4, 4, 4, 5, 5, 5, 6, 6, 6},
                {0, 7, 7, 7, 8, 8, 8, 9, 9, 9},
                {0, 7, 7, 7, 8, 8, 8, 9, 9, 9},
                {0, 7, 7, 7, 8, 8, 8, 9, 9, 9},
        };

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (board[i][j] > 0) {
                    row[i][board[i][j]] = true;
                    col[j][board[i][j]] = true;
                    b[block[i][j]][board[i][j]] = true;
                }
            }
        }
    }


    private boolean found = false;

    public void search(int i, int j) {

        //  10,1
        if (i == 10 && j == 1) {
            found = true;

            for (int ii = 0; ii < board.length; ii++) {
                for (int jj = 0; jj < board[ii].length; jj++) {
                    result[ii][jj] = board[ii][jj];
                }
            }

            return;
        }


        int nextI = i;
        int nextJ = j + 1;
        if (nextJ > 9) {
            nextI++;
            nextJ = 1;
        }


        if (board[i][j] > 0) {
            search(nextI, nextJ);
            return;
        }

        for (int k = 1; k <= 9; k++) {
            if (!row[i][k] && !col[j][k] && !b[block[i][j]][k]) {
                row[i][k] = true;
                col[j][k] = true;
                b[block[i][j]][k] = true;

                board[i][j] = k;
                search(nextI, nextJ);
                board[i][j] = 0;

                if (found) {
                    return;
                }

                row[i][k] = false;
                col[j][k] = false;
                b[block[i][j]][k] = false;
            }
        }
    }

    public static void main(String[] args) {


        int input[][] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 9, 1, 0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 6, 8, 9, 0, 0},
                {0, 3, 6, 0, 0, 0, 9, 5, 0, 0},
                {0, 0, 4, 0, 6, 0, 0, 0, 0, 0},
                {0, 0, 7, 3, 0, 0, 0, 0, 6, 8},
                {0, 0, 0, 0, 0, 2, 0, 0, 0, 3},
                {0, 9, 0, 0, 4, 0, 3, 0, 0, 0},
                {0, 0, 0, 4, 0, 0, 0, 0, 2, 5},
                {0, 1, 0, 0, 0, 0, 6, 3, 0, 9},
        };

        Sudoku game = new Sudoku(input);
        game.search(1, 1);

        int[][] ans = game.result;

        System.out.println("result：");
        for (int i = 1; i < ans.length; i++) {
            for (int j = 1; j < ans[i].length; j++) {
                System.out.print(ans[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
