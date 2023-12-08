// package DAAL.Assignment_1;

public class Q5 {
    public static int findString(String[] array, String target) {
        if (array == null || target == null || target.isEmpty()) {
            return -1;
        }
        
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            
            while (left <= right && array[right].isEmpty()) {
                right--;
            }
            
            if (left > right) {
                return -1; 
            }
            
            int mid = left + (right - left) / 2;
            
            
            int midRight = mid;
            while (midRight <= right && array[midRight].isEmpty()) {
                midRight++;
            }
            
            if (midRight > right) {
                
                right = mid - 1;
                continue;
            }
            
            int compareResult = array[midRight].compareTo(target);
            
            if (compareResult == 0) {
                return midRight;  
            } else if (compareResult < 0) {
                left = midRight + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        String[] array = {"at", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String target = "ball";
        
        int result = findString(array, target);
        
        if (result != -1) {
            System.out.println("Output: " + result);
        } else {
            System.out.println("Output: String not found");
        }
    }
}
