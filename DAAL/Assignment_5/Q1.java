package DAAL.Assignment_5;

public class Q1 {
    static void multiplyMatrix(int row1, int col1,int A[][], int row2,int col2, int B[][]){
        int i, j, k;
 
        if (row2 != col1) {
 
            System.out.println("\nMultiplication Not Possible");
            return;
        }

        int C[][] = new int[row1][col2];

        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for(int[] it : C){
            for(int ele : it){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
 
    }
    public static void main(String[] args) {
        int row1 = 4, col1 = 3, row2 = 3, col2 = 4;
 
        int A[][] = { { 1, 1, 1 },
                      { 2, 2, 2 },
                      { 3, 3, 3 },
                      { 4, 4, 4 } };
 
        int B[][] = { { 1, 1, 1, 1 },
                      { 2, 2, 2, 2 },
                      { 3, 3, 3, 3 } };
 
        multiplyMatrix(row1, col1, A, row2, col2, B);
    }
}