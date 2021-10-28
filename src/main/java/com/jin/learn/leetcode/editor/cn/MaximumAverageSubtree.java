//  [1120]子树的最大平均值

//给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。 
//
// 子树是树中的任意节点和它的所有后代构成的集合。 
//
// 树的平均值是树中节点值的总和除以节点数。 
//
// 
//
// 示例： 
//
// 
//
// 输入：[5,6,1]
//输出：6.00000
//解释： 
//以 value = 5 的节点作为子树的根节点，得到的平均值为 (5 + 6 + 1) / 3 = 4。
//以 value = 6 的节点作为子树的根节点，得到的平均值为 6 / 1 = 6。
//以 value = 1 的节点作为子树的根节点，得到的平均值为 1 / 1 = 1。
//所以答案取最大值 6。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 1 到 5000之间。 
// 每个节点的值介于 0 到 100000 之间。 
// 如果结果与标准答案的误差不超过 10^-5，那么该结果将被视为正确答案。 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 39 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;


public class MaximumAverageSubtree{
  
  
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

    double res = 0;
    // 自底向上
    // dfs 关键在于return 两个 变量出来
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) return arr;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        //设置当前树的元素和
        arr[0] = left[0] + right[0] + root.val;
        //设置节点个数
        arr[1] = left[1] + right[1] + 1;
        //更新平均值
        res = Math.max(res,(double) arr[0] / arr[1]);
        return arr;
    }




}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}