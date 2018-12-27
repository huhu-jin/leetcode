package jin.learn;


// 二叉树 最近共同祖先
// 方法1 找出 两节点的path 然后比较 这个path 相同的点
// 方法2 入下 最近的肯定是比 要找的大 或者小

public class Solution_235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
}
