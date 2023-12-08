package DAAL.Assignment_4;
import java.util.*;

//Implement algorithm for Tiling problem: Given an n by n board where n is of form 2k where k >= 1 (Basically n is a power of 2 with minimum value as 2). The board has one missing cell (of size 1 x 1). Fill the board using L shaped tiles. An L shaped tile is a 2 x 2 square with one cell of size 1×1 missing	

public class Q2 {
    
    public static void tileBoard(int[][] board, int row, int col, int x, int y, int size) {
        if (size == 2) {
            int tileNumber = 1;
            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    if (i == x && j == y) {
                        continue;
                    }
                    board[i][j] = tileNumber++;
                }
            }
        } else {
            int subSize = size / 2;
            int tileNumber = 1;
            
            int missingQuadrant = getQuadrant(x, y, row, col, subSize);
            
            for (int i = 0; i < 4; i++) {
                if (i != missingQuadrant) {
                    int newRow = row + (i / 2) * subSize;
                    int newCol = col + (i % 2) * subSize;
                    tileBoard(board, newRow, newCol, -1, -1, subSize);
                }
            }
            
            int newRow = row + (missingQuadrant / 2) * subSize;
            int newCol = col + (missingQuadrant % 2) * subSize;
            board[newRow + subSize - 1][newCol + subSize - 1] = 0;
            
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    if (board[i][j] == -1) {
                        board[i][j] = tileNumber++;
                    }
                }
            }
        }
    }
    
    public static int getQuadrant(int x, int y, int row, int col, int size) {
        int mid = row + size / 2;
        if (x < mid) {
            if (y < col + size / 2) {
                return 0;
            } else {
                return 1;
            }
        } 
        else {
            if (y < col + size / 2) {
                return 2;
            } 
            else {
                return 3;
            }
        }
    }
    public static void main(String[] args) {
        int n = 8;
        int[][] board = new int[n][n];
        int x = 0; 
        int y = 0; 
    
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i],-1);
        }
    
        tileBoard(board, 0, 0, x, y, n);
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
