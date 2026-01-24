public class Main {

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return findNodeAndDelete(root, key);
    }

    private TreeNode findNodeAndDelete(TreeNode pointer, int key) {
        if (pointer == null) {
            return null;
        }

        if (key < pointer.val) {
            pointer.left = findNodeAndDelete(pointer.left, key);
            return pointer;
        } else if (key > pointer.val) {
            pointer.right = findNodeAndDelete(pointer.right, key);
            return pointer;
        } else {
            TreeNode leftTree = pointer.left;
            TreeNode rightTree = pointer.right;
            if (leftTree == null && rightTree == null) {
                return null;
            } else if (leftTree == null) {
                return rightTree;
            } else if (rightTree == null) {
                return leftTree;
            } else {
                TreeNode leftMostOfRight = rightTree;
                while (leftMostOfRight.left != null) {
                    leftMostOfRight = leftMostOfRight.left;
                }
                return new TreeNode(
                        leftMostOfRight.val,
                        leftTree,
                        findNodeAndDelete(rightTree, leftMostOfRight.val)
                );
            }
        }
    }
}