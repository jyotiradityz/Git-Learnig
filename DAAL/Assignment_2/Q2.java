// package DAAL.Assignment_2;
import java.util.*;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        scn.close();

        int winner = arr[0], ct = 0;

        for(int i = 0;i < n;i++){
            if(arr[i] == winner){
                ct++;
            }
            else{
                ct--;
            }

            if(ct == 0){
                winner = arr[i];
                ct = 1;
            }
        }

        System.out.println("winner is " + winner);
    }
}