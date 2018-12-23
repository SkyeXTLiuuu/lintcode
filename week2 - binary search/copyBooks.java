/**
* Copy Books
* Given n books and the ith book has A[i] pages. You are given k people to copy the n books.
* Find the best strategy to assign books so that the slowest copier can finish at earliest time.
* Time complexity: 
*/

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages == null || pages.length == 0){
            return 0;
        }
        int start = 1;
        int end = Integer.MAX_VALUE;
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(countWork(mid, pages, k)){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(countWork(start, pages, k)){
            return start;
        }
        else if(countWork(end, pages, k)){
            return end;
        }
        else{
            return 0;
        }
    }

    public boolean countWork(int work, int[] pages, int k){
        int count = 0;
        int rest = 0;
        for(int p: pages){
            if(p > work){
                return false;
            }
            if(p > rest){
                count ++;
                rest = work;
            }
            rest = rest - p;
        }
        return count <= k;
    }

    public int getMin(int[] pages){
        int min = pages[0];
        for(int i: pages){
            min = Math.min(i, min);
        }
        return min;
    }

    public int getMax(int[] pages){
        int max = pages[0];
        for(int i: pages){
            max = Math.max(i, max);
        }
        return max;
    }
}
