public class NQueens {
    private int[][] board;
    private int N;

    public NQueens(int N) {
        this.N = N;
        board = new int[N][N];
    }

    public void solveNQueens() {
        if (solve(0)) {
            printSolution();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private boolean solve(int col) {
        if (col == N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;

                if (solve(col + 1)) {
                    return true;
                }

                board[i][col] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }

            for (int j = row, k = i; j >= 0 && k >= 0; j--, k--) {
                if (board[j][k] == 1) {
                    return false;
                }
            }

            for (int j = row, k = i; j < N && k >= 0; j++, k--) {
                if (board[j][k] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueens queens4 = new NQueens(8);
        queens4.solveNQueens();
    }
}
