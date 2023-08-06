//  [103]二叉树的锯齿形层序遍历

//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 551 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Q103_BinaryTreeZigzagLevelOrderTraversal{
  
  
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
    // form left to right, then from right to left
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if(root == null) return  ans;
        int count = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            LinkedList<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode node;

                if (count % 2 == 0) {
                    node = queue.poll();
                }else {
                    node = queue.pollLast();
                }

                temp.add(node.val);

                if (count % 2 == 0) {
                    if (node.left != null) nextLevel.add(node.left);
                    if (node.right != null) nextLevel.add(node.right);
                }else {
                    if (node.right != null) nextLevel.push(node.right);
                    if (node.left != null) nextLevel.push(node.left);
                }

            }
            count++;
            ans.add(temp);
            queue = nextLevel;
        }


        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
