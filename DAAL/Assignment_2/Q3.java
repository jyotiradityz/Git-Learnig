// package DAAL.Assignment_2;

public class Q3 {
	void countSort(int arr[], int n, int exp){
        int ans[] = new int[n]; 
        int i, count[] = new int[n] ;
        for (i=0; i < n; i++)
           count[i] = 0;
 
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%n ]++;
 
        for (i = 1; i < n; i++)
            count[i] += count[i - 1];
 
        for (i = n - 1; i >= 0; i--){
            ans[count[ (arr[i]/exp)%n] - 1] = arr[i];
            count[(arr[i]/exp)%n]--;
        }
 
        for (i = 0; i < n; i++)
            arr[i] = ans[i];
    }
 
 
    void sort(int arr[], int n){
        countSort(arr, n, 1);
 
        countSort(arr, n, n);
    }
 
    void printArr(int arr[], int n){
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
    }
 
    public static void main(String args[]){
        Q3 ob = new Q3();
 
        int arr[] = {40, 12, 45, 32, 33, 1, 22};
        int n = arr.length;
        System.out.println("Given array");
        ob.printArr(arr, n);
 
        ob.sort(arr, n);
        System.out.println("\nSorted array");
        ob.printArr(arr, n);
    }

}