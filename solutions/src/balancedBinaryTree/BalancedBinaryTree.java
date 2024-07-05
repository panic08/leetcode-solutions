package balancedBinaryTree;

import structures.treeNode.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        int leftPathSum = 0;
        int rightPathSum = 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left != null) {
            int value = helper(root.left);

            if (value == -1) {
                return -1;
            }

            leftPathSum += value;
        }

        if (root.right != null) {
            int value = helper(root.right);

            if (value == -1) {
                return -1;
            }

            rightPathSum += value;
        }

        if (leftPathSum - 1 != rightPathSum && leftPathSum + 1 != rightPathSum && leftPathSum != rightPathSum) {
            return -1;
        } else {
            return Math.max(leftPathSum, rightPathSum);
        }
    }
}
