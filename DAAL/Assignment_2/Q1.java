// package DAAL.Assignment_2;

import java.util.Scanner;

// Quick Sort

public class Q1 {

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }

    private static int partition(int[] arr, int lo, int hi){
        int pivot = arr[lo];
        int pivotindex = lo-1;

        for(int i=lo;i<=hi;i++){
            if(arr[i] <= pivot){
                pivotindex++;
            }
        }

        swap(arr, lo, pivotindex);

        while(lo < pivotindex && hi > pivotindex){
            while(arr[lo] <= pivot){
                lo++;
            }
            while(arr[hi] > pivot){
                hi--;
            }

            if(lo < pivotindex && hi > pivotindex){
                swap(arr,lo,hi);
                lo++;
                hi--;
            }
        }
        
        return pivotindex;
    }

    private static void quickSort(int[] arr,int lo,int hi){
        if(lo >= hi){
            return;
        }

        int pi = partition(arr,lo,hi);

        System.out.println("pivot is at " + pi);

        quickSort(arr,lo,pi-1);
        quickSort(arr,pi+1,hi);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        scn.close();

        quickSort(arr,0,n-1);

        boolean flag = false;

        for(int i = 1;i < n;i++){
            if(arr[i] == arr[i-1]){
                flag = true;
                break;
            }
        }

        for(int it : arr){
            System.out.println(it);
        }

        if(flag){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
