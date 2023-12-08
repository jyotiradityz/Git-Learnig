package Search;
public class LS {
    public static int LinearSerach(int x, int arr[], int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 2, 7, 8, 10, 34, 53, 6, 63, 24, 3 };
        int x = 7;
        int ans = LinearSerach(x, arr, arr.length);
        if (ans == -1) {
            System.out.println("Not Found");

        } else {
            System.out.println("Found at position " + ans);
        }
    }
}