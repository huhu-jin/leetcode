//  [111]二叉树的最小深度

//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 784 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;


public class Q111_MinimumDepthOfBinaryTree{
  
  
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
    // bfs 可以不看
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
         Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
         int level =0;

        while (!deque.isEmpty()) {
            Deque<TreeNode> temp = new LinkedList<>();
            while (!deque.isEmpty()) {
                TreeNode node = deque.pollFirst();
                if (node.left == null && node.right ==null) return level + 1;
                if (node.left !=null) temp.add(node.left);
                if (node.right !=null) temp.add(node.right);
            }
            level++;
            deque = temp;
        }
         return level;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
