package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Bin_Tree_Min_Depth {
  /*public int minDepth(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 1;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
            }
            minDepth++;
        }
        return minDepth;
    }*/
}
