import java.util.ArrayList;
import java.util.List;
// Time : O(n * n!)
// Space : O(n^2)

public class NQueens {


    /**
     * Checks the 45° and 135° diagonals for an existing queen. For example, if the board is a 5x5
     * and you call checkDiagonal(board, 3, 1), The positions checked for an existing queen are
     * marked below with an `x`. The location (3, 1) is marked with an `o`.
     *
     * ....x
     * ...x.
     * x.x..
     * .o...
     * .....
     *
     * Returns true if a Queen is found.
     *
     * Do not modify this function (the tests use it)
     */
    public static boolean checkDiagonal(char[][] board, int r, int c) {
        int y = r - 1;
        int x = c - 1;
        while (y >= 0 && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y--;
        }
        y = r - 1;
        x = c + 1;
        while (y >= 0 && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y--;
        }
        return false;
    }


    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    /**
     * Space: O(N^2) -> array of 2D arrays ?
     * Time: O(N!*N)
     */
    public static List<char[][]> nQueensSolutions(int n) {
        // TODO
        List<char[][]> answers = new ArrayList<>();
        char[][] queens = new char[n][n];
        int[] cols = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queens[i][j] = '.'; // create board
            }
        }
        answers = nQueensRec(queens, 0, cols, answers);
        return answers;
    }

    public static List<char[][]> nQueensRec(char[][] board, int row, int[] col, List<char[][]> answers) {
        if (row == board.length) {
            answers.add(copyOf(board)); //add solved board to answers once you reach the last row
            return answers;
        }
        for (int i=0; i<board.length; i++) {
            if (col[i] == 0 && !checkDiagonal(board, row, i)) { // if the column has no Q's and the diagonal has no Q's
                col[i] = 1;   // there is a Q in the column now
                board[row][i] = 'Q'; // add the Q
                nQueensRec(board, row+1, col, answers); // next row
                board[row][i] = '.'; // backtrack
                col[i] = 0;
            }
        }
        return answers;
    }
=======

=======
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    public static List<char[][]> nQueensSolutions(int n) {
        List<char[][]> answers = new ArrayList<>();
        // Create and populate queens array.
        char[][] queens_array = new char[n][n];
        int[] cols = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j=0; j<n; j++) {
                queens_array[i][j] = '.';
            }
        }
        // Recursively traverse row-by-row
        answers = nQueensRec(queens_array, 0, cols, answers);
        return answers;
    }

<<<<<<< HEAD
>>>>>>> fa3f8b78319c86d5c534e7e4aca1060986f5e6b1
}
=======
    public static List<char[][]> nQueensRec(char[][] answers, int r, int[] c, List<char[][]> status) {
        if (r == answers.length) {
            status.add(copyOf(answers));
            return status;
        }
        for (int i=0; i < answers.length; i++) {
            if (c[i] == 0 && !checkDiagonal(answers, r, i)) {
                c[i] = 1;
                answers[r][i] = 'Q';
                nQueensRec(answers, r+1, c, status);
                answers[r][i] = '.';
                c[i] = 0;
            }
        }
        return status;
    }
}
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
