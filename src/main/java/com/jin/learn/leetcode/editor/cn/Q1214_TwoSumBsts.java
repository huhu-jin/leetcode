//  [1214]查找两棵二叉搜索树之和

//给出两棵二叉搜索树，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。 
//
// 如果可以找到返回 True，否则返回 False。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root1 = [2,1,4], root2 = [1,0,3], target = 5
//输出：true
//解释：2 加 3 和为 5 。
// 
//
// 示例 2： 
//
// 
//
// 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
//输出：false 
//
// 
//
// 提示： 
//
// 
// 每棵树上最多有 5000 个节点。 
// -10^9 <= target, node.val <= 10^9 
// 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 双指针 二分查找 二叉树 
// 👍 31 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class Q1214_TwoSumBsts{
  
  
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

    Set<Integer> set = new HashSet<>();

    // Hash map
    // 可以不看
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        dfs(root1);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root2);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(set.contains(target-temp.val)) return true;
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }


        return false;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        set.add(node.val);
        dfs(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
