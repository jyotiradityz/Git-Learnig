// package A4;

public class TilingProblem {
    
    // Function to solve the tiling problem
    public static void tileBoard(int n, int row, int col, int missingRow, int missingCol) {
        if (n == 2) {
            // Base case: Fill the board using L-shaped tiles
            int tileNumber = 0;
            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    if (i != missingRow || j != missingCol) {
                        // Place an L-shaped tile
                        System.out.println("Place tile " + (++tileNumber) + " at (" + i + ", " + j + ")");
                    }
                }
            }
        } else {
            // Divide the board into four quadrants
            int halfSize = n / 2;
            int midRow = row + halfSize;
            int midCol = col + halfSize;

            // Determine which quadrant contains the missing cell
            if (missingRow < midRow && missingCol < midCol) {
                // Top-left quadrant
                tileBoard(halfSize, row, col, missingRow, missingCol);
            } else if (missingRow < midRow) {
                // Top-right quadrant
                tileBoard(halfSize, row, midCol, missingRow, missingCol);
            } else if (missingCol < midCol) {
                // Bottom-left quadrant
                tileBoard(halfSize, midRow, col, missingRow, missingCol);
            } else {
                // Bottom-right quadrant
                tileBoard(halfSize, midRow, midCol, missingRow, missingCol);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4; // Change this to the desired board size (power of 2)
        int missingRow = 1; // Change these coordinates to specify the missing cell
        int missingCol = 2;

        tileBoard(n, 0, 0, missingRow, missingCol);
    }
}
