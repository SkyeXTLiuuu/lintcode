/**
* Calculate hashcode of a string 
*/

public class Solution {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        if (key == null || key.length == 0) {
            return -1;
        }

        long result = 0;
        for (int i = 0; i < key.length; i ++) {
            result = (result * 33 + (key[i])) % HASH_SIZE;
        }
        return (int) result;
    }
}
