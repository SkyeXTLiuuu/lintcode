/**
* Bidirectional BFS
* Time complexity: O(2 * X^(N/2)) N层 每层的判断量为X
*/

public class Solution {
  public int doubleBFS(UndirectedGraphNode start, UndirectedGraphNode end) {
    if (start.equals(end)) {
      return 1;
    }

    Queue<UndirectedGraphNode> startQueue = new LinkedList<>();
    Queue<UndirectedGraphNode> endQueue = new LinkedList<>();
    startQueue.add(start);
    endQueue.add(end);
    int step = 0;

    Set<UndirectedGraphNode> startVisited = new HashSet<>();
    Set<UndirectedGraphNode> endVisited = new HashSet<>();
    startVisited(start);
    endVisited(end);

    while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
      int startSize = startQueue.size();
      int endSize = endQueue.size();
      step ++;

      for (int i = 0; i < startSize; i ++) {
        UndirectedGraphNode cur = startQueue.poll();
        for (UndirectedGraphNode neighbor: cur.neighbors) {
          if (startVisited.contains(neighbor)) {
            continue;
          }
          // 相交
          else if (endVisited.contains(neighbor)) {
            return step;
          }
          else {
            startVisited.add(neighbor);
            startQueue.add(neighbor);
          }
        }
      }

      step ++;
      for (int i = 0; i < endSize; i ++) {
        UndirectedGraphNode cur = endQueue.poll();
        for (UndirectedGraphNode neighbor: cur.neighbors) {
          if (endVisited.contains(neighbor)) {
            continue;
          }
          // 相交
          else if (startVisited.contains(neighbor)) {
            return step;
          }
          else {
            endVisited.add(neighbor);
            endQueue.add(neighbor);
          }
        }
      }
    }
    return -1; // 不连通
  }
}
