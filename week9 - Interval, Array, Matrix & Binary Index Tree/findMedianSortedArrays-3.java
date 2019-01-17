/**
* Median of two Sorted Arrays
* There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
* Time complexity: O(log(n+m))
* 每次移除较小的一部分数和较大的一部分数，直到其中一个数组为空
*/

public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double c(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) {
            return -1;
        }

        return findMedian(new PartialArray(A), new PartialArray(B));
    }

    public double findMedian(PartialArray A, PartialArray B) {
        while (!A.isEmpty() && !B.isEmpty()) {
            if (A.size() == 1 && B.size() == 1) {
                return (A.getMedian() + B.getMedian()) / 2.0;
            }

            PartialArray lowerArr = A;
            int lowerIndex = A.getLowerMedianIndex();
            if(A.getLowerMedian() > B.getLowerMedian()) {
                lowerArr = B;
                lowerIndex = B.getLowerMedianIndex();
            }

            PartialArray upperArr = A;
            int upperIndex = A.getUpperMedianIndex();
            if(A.getUpperMedian() < B.getUpperMedian()) {
                upperArr = B;
                upperIndex = B.getUpperMedianIndex();
            }

            int numOfRemoved = Math.min(lowerArr.getNumberOfLower(lowerIndex), upperArr.getNumberOfUpper(upperIndex));
            if (lowerArr.get(lowerIndex) == upperArr.get(upperIndex)) {
                return lowerArr.get(lowerIndex);
            }

            lowerArr.removeLower(numOfRemoved);
            upperArr.removeUpper(numOfRemoved);
        }

        if (A.isEmpty()) {
            return B.getMedian();
        }
        return A.getMedian();
    }

    class PartialArray {
        int[] arr;
        int start, end;

        PartialArray(int[] arr) {
            this.arr = arr;
            this.start = 0;
            this.end = arr.length - 1;
        }

        public int getLowerMedian() {
            return arr[(start + end) / 2];
        }

        public int getUpperMedian() {
            return arr[(start + end + 1) / 2];
        }

        public int getLowerMedianIndex() {
            return (start + end) / 2;
        }

        public int getUpperMedianIndex() {
            return (start + end + 1) / 2;
        }

        public int size() {
            return end - start + 1;
        }

        public double getMedian() {
            return (getLowerMedian() + getUpperMedian()) / 2.0;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int getNumberOfUpper(int index) {
            if (index == end) {
                return 1;
            }
            return end - index;
        }

        public int getNumberOfLower(int index) {
            if (index == start) {
                return 1;
            }
            return index - start;
        }

        public void removeLower(int numOfRemoved) {
            start += numOfRemoved;
        }

        public void removeUpper(int numOfRemoved) {
            end -= numOfRemoved;
        }

        public int get(int index) {
            return arr[index];
        }
    }
}
