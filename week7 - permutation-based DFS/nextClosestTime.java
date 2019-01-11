/**
* Next Closest Time
* Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits
* Time complexity: 
* DFS
*/

public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    int diff = Integer.MAX_VALUE;
    String result = "";
    public String nextClosestTime(String time) {
        // write your code here
        if (time == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        set.add(Integer.parseInt(time.substring(0, 1)));
        set.add(Integer.parseInt(time.substring(1, 2)));
        set.add(Integer.parseInt(time.substring(3, 4)));
        set.add(Integer.parseInt(time.substring(4, 5)));

        if (set.size() == 1) {
            return time;
        }

        List<Integer> digits = new ArrayList<>(set);
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));

        dfs(digits, "", 0, minutes);
        return result;
    }

    public void dfs(List<Integer> digits, String cur, int index, int target) {
        if (index == 4) {
            int time = Integer.parseInt(cur.substring(0, 2)) * 60 + Integer.parseInt(cur.substring(2, 4));
            if (time == target) {
                return ;
            }
            if (time < target) {
                time = time + 1440;
            }
            int curDiff = time - target;
            if (curDiff < diff) {
                diff = curDiff;
                result = cur.substring(0, 2) + ":" + cur.substring(2, 4);
            }
            return ;
        }

        for (int i = 0; i < digits.size(); i ++) {
            if (index == 0 && digits.get(i) > 2) {
                continue;
            }
            if (index == 1 && digits.get(i) + Integer.parseInt(cur) * 10 > 23) {
                continue;
            }
            if (index == 2 && digits.get(i) > 5) {
                continue;
            }
            if (index == 3 && digits.get(i) + Integer.parseInt(cur.substring(2)) * 10 > 59) {
                continue;
            }

            dfs(digits, cur + digits.get(i), index + 1, target);
        }
    }
}
