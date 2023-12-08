
// package DAAL.Assignment_1;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(), m = scn.nextInt();

        int[][] mat = new int[n][m];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                mat[i][j] = scn.nextInt();
            }
        }
        int target = scn.nextInt();

        int lo = 0;
        int hi = n * m - 1;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int midValue = mat[mid / m][mid % m];
            
            if(midValue < target) {
                lo = mid + 1;
            } 
            else{
                hi = mid;
            }
        }
        int ans = mat[lo / m][lo % m];
        if(ans == target){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

        scn.close();
    }
}
