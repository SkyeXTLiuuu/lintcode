public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        if(dict == null){
            return null;
        }
        List<List<String>> result = new ArrayList<List<String>>();
        dict.add(start);
        dict.add(end);
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(start, map, distance, dict);
        dfs(start, end, map, distance, dict, result, new ArrayList<String>());
        return result;
    }

    public void dfs(String start, String crt, Map<String, List<String>> map, Map<String, Integer> distance, Set<String> dict, List<List<String>> result, List<String> list){
        list.add(crt);
        if(crt.equals(start)){
            Collections.reverse(list);
            result.add(new ArrayList(list));
            Collections.reverse(list);
        }
        else{
            for(String s: map.get(crt)){
                if(distance.containsKey(s) && distance.get(s) + 1 == distance.get(crt)){
                    dfs(start, s, map, distance, dict, result, list);
                }
            }
        }
        list.remove(list.size() - 1);
    }

    public void bfs(String start, Map<String, List<String>> map, Map<String, Integer> distance, Set<String> dict){
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        for(String s: dict){
            map.put(s, new ArrayList<String>());
        }
        while(!queue.isEmpty()){
            String cur = queue.poll();
            for(String s: getNext(cur, dict)){
                map.get(s).add(cur);
                if(!distance.containsKey(s)){
                    distance.put(s, distance.get(cur) + 1);
                    queue.offer(s);
                }
            }
        }
    }

    public List<String> getNext(String cur, Set<String> dict){
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < cur.length(); i ++){
            for(char c = 'a'; c <= 'z'; c ++){
                if(cur.charAt(i) != c){
                String newWord = cur.substring(0, i) + c + cur.substring(i + 1);
                    if(dict.contains(newWord)){
                        result.add(newWord);
                    }
                }
            }
        }
        return result;
    }
}
