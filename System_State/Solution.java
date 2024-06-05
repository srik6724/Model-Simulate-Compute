package System_State;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
      val = x;
  }
}

public class Solution {
  private int maxPathSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
      calculateMaxPathSum(root);
      return maxPathSum;
  }

  private int calculateMaxPathSum(TreeNode node) {
      if (node == null) {
          return 0;
      }

      // Recursively calculate the maximum sum for the left and right subtrees
      int leftMax = Math.max(0, calculateMaxPathSum(node.left));
      int rightMax = Math.max(0, calculateMaxPathSum(node.right));

      // Update the maximum path sum by considering the current node
      int currentMax = node.val + leftMax + rightMax;
      maxPathSum = Math.max(maxPathSum, currentMax);

      // Return the maximum path sum starting from the current node (to be used by its parent)
      return node.val + Math.max(leftMax, rightMax);
  }

  public static void main(String[] args) {
      // Example usage
      Solution solution = new Solution();

      // Construct the binary tree
      TreeNode root = new TreeNode(10);
      root.left = new TreeNode(5);
      root.right = new TreeNode(15);
      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(7);
      root.right.right = new TreeNode(20);

      // Calculate the maximum path sum
      int maxPathSum = solution.maxPathSum(root);
      System.out.println("Maximum path sum: " + maxPathSum); // Output: 52
  }
}
