/**
* Closest Binary Search Tree Value II
* Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
* Time complexity: O(k + logn)
* Space complexity: O(logn)
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> values = new ArrayList<Integer>();
        if (root == null || k < 1) {
            return values;
        }

        Stack<TreeNode> lowerStack = getStack(root, target);
        Stack<TreeNode> upperStack = new Stack<>();
        upperStack.addAll(lowerStack);

        if (target < lowerStack.peek().val) {
          moveLower(lowerStack);
        }
        else {
          moveUpper(upperStack);
        }

        for (int i = 0; i < k; i ++) {
          // add numbers from upperStack
          // condition 1: lowerStack is empty
          // condition 2: lowerStack and upperStack are not empty. The difference between the peek number in the upperStack is smaller than that of the lowerStack
          if (lowerStack.isEmpty() || !upperStack.isEmpty() && target - lowerStack.peek().val > upperStack.peek().val - target) {
            values.add(upperStack.peek().val);
            moveUpper(upperStack);
          }
          else {
            values.add(lowerStack.peek().val);
            moveLower(lowerStack);
          }
        }
        return values;
    }

    public Stack<TreeNode> getStack(TreeNode root, double target) {
      Stack<TreeNode> stack = new Stack<>();
      while (root != null) {
        stack.push(root);

        if (target < root.val) {
          root = root.left;
        }
        else {
          root = root.right;
        }
      }

      return stack;
    }

    public void moveLower(Stack<TreeNode> stack) {
      TreeNode node = stack.peek();
      // 第一次判断的时候进来 target < peek 并且 left = null
      // if left != null, target < node 就会向左挪
      // 用来找到离target最近的那个node
      if (node.left == null) {
        node = stack.pop();
        while (!stack.isEmpty() && stack.peek().left == node) {
          node = node.pop();
        }
        return ;
      }

      node = node.left;
      while (node != null) {
        stack.push(node);
        node = node.right;
      }
    }

    public void moveUpper(Stack<TreeNode> stack) {
      TreeNode node = stack.peek();
      if (node.right == null) {
        node = stack.pop();
        while (!stack.isEmpty() && stack.peek().right == node) {
          node = stack.pop();
        }
        return ;
      }

      node = node.right;
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }
}
