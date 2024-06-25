package pathSum2;

import structures.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> pathSum = new ArrayList<>();

        helper(root, 0, new ArrayList<>(), pathSum, targetSum);

        return pathSum;
    }

    public void helper(TreeNode root, int sum, List<Integer> nums, List<List<Integer>> pathSum, int targetSum) {
        sum += root.val;

        nums.add(root.val);

        if (root.left == null && root.right == null && sum == targetSum) {
            pathSum.add(new ArrayList<>(nums));
        }

        if (root.left != null) {
            helper(root.left, sum, nums, pathSum, targetSum);
        }

        if (root.right != null) {
            helper(root.right, sum, nums, pathSum, targetSum);
        }

        int indexForDelete = -1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) == root.val) {
                indexForDelete = i;
                break;
            }
        }

        if (indexForDelete != -1) {
            nums.remove(indexForDelete);
        }
    }
}
