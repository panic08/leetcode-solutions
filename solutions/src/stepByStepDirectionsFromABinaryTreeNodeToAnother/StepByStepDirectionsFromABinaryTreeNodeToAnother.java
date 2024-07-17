package stepByStepDirectionsFromABinaryTreeNodeToAnother;

import structures.treeNode.TreeNode;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder toStartValue = new StringBuilder();
        StringBuilder toDestValue = new StringBuilder();

        buildPathFromRootToValue(root, startValue, toStartValue);
        buildPathFromRootToValue(root, destValue, toDestValue);

        while (!toStartValue.isEmpty() && !toDestValue.isEmpty() && toStartValue.charAt(0) == toDestValue.charAt(0)) {
            toStartValue.deleteCharAt(0);
            toDestValue.deleteCharAt(0);
        }

        return "U".repeat(toStartValue.length()) + toDestValue;
    }

    public boolean buildPathFromRootToValue(TreeNode root, int value, StringBuilder path) {
        if (value == root.val) {
            return true;
        }

        boolean isLeftHasPath;
        boolean isRightHasPath;

        if (root.left != null) {
            path.append("L");
            isLeftHasPath = buildPathFromRootToValue(root.left, value, path);

            if (isLeftHasPath) {
                return true;
            }

            path.deleteCharAt(path.length() - 1);
        }

        if (root.right != null) {
            path.append("R");
            isRightHasPath = buildPathFromRootToValue(root.right, value, path);

            if (isRightHasPath) {
                return true;
            }

            path.deleteCharAt(path.length() - 1);
        }

        return false;
    }

}
