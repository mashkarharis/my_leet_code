import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

}

class Solution {
    public int maxLevelSum(TreeNode root) {

        int maxSum = root.val;
        int level = 1;
        int maxSumLevel = 1;
        List<TreeNode> currentLevelNodes = new ArrayList<>();
        currentLevelNodes.add(root);

        while (!currentLevelNodes.isEmpty()){
            int currentLevelSum = getCurrentLevelSum(currentLevelNodes);
            if (currentLevelSum > maxSum){
                maxSum = currentLevelSum;
                maxSumLevel = level;
            }
            level++;
        }
        return maxSumLevel;
    }

    private int getCurrentLevelSum(List<TreeNode> currentLevelNodes) {
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        AtomicInteger currentSum = new AtomicInteger();
        currentLevelNodes.forEach((node)->{
            currentSum.addAndGet(node.val);
            if(node.left!=null) {
                nextLevelNodes.add(node.left);
            }
            if(node.right!=null) {
                nextLevelNodes.add(node.right);
            }
        });
        currentLevelNodes.clear();
        currentLevelNodes.addAll(nextLevelNodes);
        return  currentSum.get();
    }
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