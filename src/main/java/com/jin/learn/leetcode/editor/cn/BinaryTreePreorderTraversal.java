//  [144]二叉树的前序遍历

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 880 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreePreorderTraversal{
  
  
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

    // 递归
    List<Integer> ans = new LinkedList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    // 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        List<Integer> ans = new LinkedList<>();

        while (!deque.isEmpty()) {

            TreeNode node = deque.pop();
            ans.add(node.val);

            if (node.right != null) {
                deque.push(node.right);
            }

            if (node.left != null) {
                deque.push(node.left);
            }

        }

        return ans;

    }





}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}