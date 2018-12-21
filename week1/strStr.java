/**
* Implement strStr()
* For a given source string and a target string, output the first index(from 0) of target string in source string.
* example: source = "source", target = "target", return -1
* source = "abcdabcdefg", target = "bcd", return 1
* Time complexity: O(n)
* Easy
*/

public class Solution {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if(source == null || target == null || source.length() < target.length()){
            return -1;
        }
        if(target.length() == 0){
            return 0;
        }
        for(int i = 0; i < source.length() - target.length() + 1; i ++){
            for(int j = 0 ; j < target.length(); j ++){
                if(source.charAt(i + j) != target.charAt(j)){
                    break;
                }
                if(j == target.length() - 1){
                    return i;
                }
            }
        }
        return -1;
    }
}
