import java.util.Arrays;
import java.util.Comparator;

public class AnagramSort {

    // Custom comparator to sort strings based on sorted characters
    private static class AnagramComparator implements Comparator<String> {
        private String sortChars(String str) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }

        @Override
        public int compare(String str1, String str2) {
            return sortChars(str1).compareTo(sortChars(str2));
        }
    }

    // Method to sort an array of strings with anagrams next to each other
    public static void sortAnagrams(String[] array) {
        Arrays.sort(array, new AnagramComparator());
    }

    public static void main(String[] args) {
        String[] stringArray = {"cat", "dog", "tac", "god", "act"};

        // Sort the array with anagrams next to each other
        sortAnagrams(stringArray);

        // Print the sorted array
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
    }
}
