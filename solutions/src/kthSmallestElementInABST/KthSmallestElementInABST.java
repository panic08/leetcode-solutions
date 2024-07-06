package kthSmallestElementInABST;

import structures.treeNode.TreeNode;


public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int[] stageAnswer = new int[] {1, -1};
        helper(root, k, stageAnswer);

        return stageAnswer[1];
    }

    public void helper(TreeNode root, int k, int[] stageAnswer) {
        if (root.left != null) {
            helper(root.left, k, stageAnswer);
        }

        if (stageAnswer[1] != -1) {
            return;
        }

        if (stageAnswer[0] == k) {
            stageAnswer[1] = root.val;
            return;
        }

        stageAnswer[0]++;

        if (root.right != null) {
            helper(root.right, k, stageAnswer);
        }
    }
}
