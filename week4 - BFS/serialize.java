/**
* Serialize and Deserialize Binary Tree
* Serialize and deserialize a binary tree
* Time complexity: O(N)
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
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        for (int i = 0; i < nodes.size(); i ++) {
            TreeNode curNode =  nodes.get(i);
            if (curNode == null) {
                continue;
            }
            nodes.add(curNode.left);
            nodes.add(curNode.right);
        }

        while (nodes.get(nodes.size() - 1) == null) {
            nodes.remove(nodes.size() - 1);
        }

        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append(nodes.get(0).val);
        for (int i = 1; i < nodes.size(); i ++) {
            if (nodes.get(i) == null) {
                result.append(",#");
            }
            else {
                result.append(",");
                result.append(nodes.get(i).val);
            }
        }
        result.append("}");
        return result.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.equals("{}")) {
            return null;
        }
        String[] dataArray = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> nodes = new ArrayList<>();
        int index = 0;
       TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        nodes.add(root);
        boolean isLeftChild = true;
        for (int i = 1; i < dataArray.length; i ++) {
            if (!dataArray[i].equals("#")) {
                TreeNode curNode = new TreeNode(Integer.parseInt(dataArray[i]));
                if (isLeftChild) {
                    nodes.get(index).left = curNode;
                }
                else {
                    nodes.get(index).right = curNode;
                }
                nodes.add(curNode);
            }

            if (!isLeftChild) {
                index ++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
