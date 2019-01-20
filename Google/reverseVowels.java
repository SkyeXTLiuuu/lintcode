/**
* Reverse Vowels of a String
* Write a function that takes a string as input and reverse only the vowels of a string.
* example: Given s = "hello", return "holle".
* Time complexity: O(n)
* Space complexity: O(n)
*/

public class Solution {
    /**
     * @param s: a string
     * @return: reverse only the vowels of a string
     */
    public String reverseVowels(String s) {
        // write your code here

        if (s == null || s.length() == 0) {
            return s;
        }

        int left = 0;
        int right = s.length() - 1;
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');

        char[] letters = s.toCharArray();

        while (left <= right) {
            while (left <= right && !vowel.contains(letters[left])) {
                left ++;
            }
            while (left <= right && !vowel.contains(letters[right])) {
                right --;
            }
            if (left < right) {
                swap(letters, left, right);
            }
            left ++;
            right --;
        }

        return String.valueOf(letters);
    }

    public void swap(char[] letters, int left, int right) {
        char c = letters[left];
        letters[left] = letters[right];
        letters[right] = c;
    }
}
