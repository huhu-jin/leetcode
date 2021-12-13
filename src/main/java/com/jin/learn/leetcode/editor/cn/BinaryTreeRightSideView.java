//  [199]二叉树的右视图

//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 578 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeRightSideView{
  
  
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
    // 广度 按层遍历 取最右边的
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        ans.add(root.val);

        while (!deque.isEmpty()) {
            Deque<TreeNode> temp = new LinkedList<>();

            while (!deque.isEmpty()) {
               TreeNode node =deque.pop();
               if(node.left != null) temp.add(node.left);
               if(node.right != null) temp.add(node.right);
            }
            if(temp.isEmpty()) break;
            ans.add(temp.peekLast().val);
            deque = temp;
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}