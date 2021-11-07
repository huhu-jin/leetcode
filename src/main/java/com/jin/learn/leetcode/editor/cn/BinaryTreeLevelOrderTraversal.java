//  [102]二叉树的层序遍历

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 936 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class BinaryTreeLevelOrderTraversal{
  
  
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

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            TreeNode t;
            LinkedList<TreeNode> newQueue = new LinkedList<>();
            while ((t = queue.pollFirst()) !=null) {
                temp.add(t.val);
                if (t.left !=null) newQueue.add(t.left);
                if (t.right !=null) newQueue.add(t.right);
            }
            queue = newQueue;
            res.add(temp);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}