public class MergeSortedArrays {

    public static void mergeSortedArrays(int[] A, int m, int[] B, int n) {
        // Initialize pointers for array A and B, and index for the merged array
        int i = m - 1, j = n - 1, k = m + n - 1;

        // Merge arrays starting from the end
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k] = A[i];
                i--;
            } else {
                A[k] = B[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in B, copy them to A
        while (j >= 0) {
            A[k] = B[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 5, 0, 0, 0}; // A has enough buffer at the end to hold B
        int[] B = new int[]{2, 4, 6};
        int m = 3; // Number of elements in A
        int n = 3; // Number of elements in B

        mergeSortedArrays(A, m, B, n);

        // Print the merged array A
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}
