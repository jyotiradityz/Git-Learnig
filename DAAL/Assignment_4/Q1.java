package DAAL.Assignment_4;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] res = new int[n];

        for(int i = 0;i < n;i++){
            res[i] = scn.nextInt();
        }
        scn.close();

        int lo = 0, hi = n-1;

        while(lo < hi){
            int mid = lo + (hi-lo)/2;

            if(res[mid] > res[mid-1] && res[mid] > res[mid+1]){
                lo = mid;
                break;
            }

            if(res[mid] > res[mid-1] && res[mid] < res[mid+1]){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }

        System.out.println("The peak element is :- " + res[lo]);
    }
}
