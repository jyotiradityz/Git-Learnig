package A4;

public class first {

    public static int findMaximum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // We are in the decreasing part, so move left
                right = mid;
            } else {
                // We are in the increasing part, so move right
                left = mid + 1;
            }
        }

        // left will be the index of the maximum element
        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 8, 12, 4, 2 };
        int max = findMaximum(arr);
        System.out.println("Maximum element: " + max);
    }
}

