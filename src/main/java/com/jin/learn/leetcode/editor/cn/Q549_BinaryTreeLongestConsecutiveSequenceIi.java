//  [549]二叉树中最长的连续序列

//给定一个二叉树，你需要找出二叉树中最长的连续序列路径的长度。 
//
// 请注意，该路径可以是递增的或者是递减。例如，[1,2,3,4] 和 [4,3,2,1] 都被认为是合法的，而路径 [1,2,4,3] 则不合法。另一方面，
//路径可以是 子-父-子 顺序，并不一定是 父-子 顺序。 
//
// 示例 1: 
//
// 输入:
//        1
//       / \
//      2   3
//输出: 2
//解释: 最长的连续路径是 [1, 2] 或者 [2, 1]。
// 
//
// 
//
// 示例 2: 
//
// 输入:
//        2
//       / \
//      1   3
//输出: 3
//解释: 最长的连续路径是 [1, 2, 3] 或者 [3, 2, 1]。
// 
//
// 
//
// 注意: 树上所有节点的值都在 [-1e7, 1e7] 范围内。 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 88 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;


public class Q549_BinaryTreeLongestConsecutiveSequenceIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxval = 0;

    // return [inc, dcr] 一当前节点为root的 递增 递减长度
    //如果 root.val == root.left.val + 1 dcr+1 差1接上
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxval;
    }
    public int[] longestPath(TreeNode root) {
        if (root == null)
            return new int[] {0,0};
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inr = l[0] + 1;
        }
        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inr = Math.max(inr, r[0] + 1);
        }
        maxval = Math.max(maxval, dcr + inr - 1);
        return new int[] {inr, dcr};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode3.left = treeNode2;
        treeNode2.left = treeNode1;

        treeNode3.right = treeNode4;
        treeNode4.right = treeNode5;
        new Solution().longestPath(treeNode3);

    }
  
}
