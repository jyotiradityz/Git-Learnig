// package DAAL.Assignment_1;

import java.util.Arrays;
import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
        }

        Arrays.sort(arr, (a,b) -> (a[0] == b[0]) ? a[1]-b[1] : a[0]-b[0]);

        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i = n-1;i >= 0;i--){
            int val = 0;
            for(int j = i+1;j < n;j++){
                val = Math.max(val, dp[j]);
            }
            dp[i] = val+1;
        }

        System.out.println(dp[0]);

        scn.close();

    }
}