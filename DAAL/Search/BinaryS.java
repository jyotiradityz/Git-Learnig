package Search;
public class BinaryS {
    public int BinarySearch(int left, int right, int x, int arr[]) {
        int mid = (right + left) / 2;

        for (int i = 0; i < arr.length; i++) {
            if (arr[mid] > x) {
                return left = mid + 1;
            } else if (arr[mid] < x) {
                return right = mid - 1;
            } else if (arr[mid] == x) {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinaryS bs = new BinaryS();
        int arr[] = { 1, 5, 6, 7, 9, 10, 15, 36, 78, 85, 98 };
        int x = 10;
        int ans = bs.BinarySearch(0, arr.length - 1, x, arr);
        if (ans == -1) {
            System.out.println("Not Found !");
        } else {
            System.out.println("Found at position " + ans);
        }

    }
}
