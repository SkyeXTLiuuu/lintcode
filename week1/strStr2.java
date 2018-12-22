/**
* Implement strStr function in O(n + m) time.
* Rabin Karp Algorithm
* Time complexity: O(m + n)
*/

public class Solution {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int BASE = 1000000;
    public int strStr2(String source, String target) {
        // edge case
        if(source == null || target == null){
            return -1;
        }
        int m = target.length();
        int n = source.length();
        if(m == 0){
            return 0;
        }

        int power = 1;
        // calculate the power
        for(int i = 0; i < m; i ++){
            power = (power * 31) % BASE;
        }
        int targetCode = 0;
        // calculate the hash code of target
        for(int i = 0; i < m; i ++){
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }
        int hashCode = 0;
        // calculate the hash codes in source
        for(int i = 0; i < n; i ++){
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            // when there are fewer elements than the length of the target
            if(i < m - 1){
                continue;
            }
            // remove the first character "abcd" => "abc"
            if(i >= m){
                hashCode = hashCode - (source.charAt(i - m) * power) % BASE;
                if(hashCode < 0){
                    hashCode = hashCode + BASE;
                }
            }
            if(hashCode == targetCode){
                int start = i - m + 1;
                String candidate = source.substring(start, i + 1);
                if(candidate.equals(target)){
                    return start;
                }
            }
        }
        return -1;
    }
}
