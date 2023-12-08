package DAAL.Assignment_1;
import java.util.*;

//Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array. You may assume that the array was originally sorted in increasing order.
// EXAMPLE
// Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
// Output: 8 (the index of 5 in the array)

public class Q3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] res = new int[n];

        for(int i = 0;i < n;i++){
            res[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();

        int lo = 1, hi = n - 2;

        if(res[0] == target){
            System.out.println("Present at 0");
            return ;
        }
        if(res[n-1] == target){
            System.out.println("Present at " + (n-1));
            return ;
        }
        int mid = 0;

        while(lo < hi){
            mid = lo + (hi-lo)/2;

            if(res[mid] > res[mid-1] && res[mid] > res[mid+1]){
                break;
            }

            if(res[mid] > res[0]){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }

        if(target == res[mid]){
            System.out.println(mid);
            return ;
        }

        if(target > res[mid]){
            System.out.println("not found");
            return ;
        }

        if(target > res[0]){
            lo = 0;
            hi = mid;

            while(lo < hi){
                mid = lo + (hi-lo) / 2;

                if(res[mid] < target){
                    lo = mid+1;
                }
                else{
                    hi = mid;
                }
            }
            System.out.println(lo);
        }
        else if(target < res[n-1]){
            lo = mid+1;
            hi = n-1;

            while(lo < hi){
                mid = lo + (hi-lo) / 2;

                if(res[mid] < target){
                    lo = mid+1;
                }
                else{
                    hi = mid;
                }
            }
            System.out.println(lo);
        }
    }
}