package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelsMaxCalculator {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxes = new ArrayList();
        helper(maxes, root, 0);

        return maxes;
    }

    void helper(List<Integer> maxes, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level == maxes.size()) {
            maxes.add(node.val);
        } else {
            maxes.set(level, Math.max(maxes.get(level), node.val));
        }

        helper(maxes, node.left, level + 1);
        helper(maxes, node.right, level + 1);

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
