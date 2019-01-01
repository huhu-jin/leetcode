package jin.learn;

/**
 * 分两部走 就好
 * 1 左右子树 是否 balance
 * 2 左右子树 高度差是否 差1
 */

public class Solution_110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null) return false;

        if (root.left != null) {
            if(!isBalanced(root.left)) return false;
        }

        if (root.right != null) {
            if(!isBalanced(root.right)) return false;
        }

        Integer leftHight = findTreeHight(root.left);
        Integer rightHight = findTreeHight(root.right);

        return Math.abs(leftHight - rightHight) <= 1;
    }

    private Integer findTreeHight(TreeNode node) {
                if(node==null) return 0;
            return Math.max(findTreeHight(node.left),findTreeHight(node.right))+1;
        }

}
