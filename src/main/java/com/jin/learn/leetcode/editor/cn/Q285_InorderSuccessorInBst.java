//  [285]二叉搜索树中的中序后继

//给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。 
//
// 节点 p 的后继是值比 p.val 大的节点中键值最小的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [2,1,3], p = 1
//输出：2
//解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], p = 6
//输出：null
//解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 104] 内。 
// -105 <= Node.val <= 105 
// 树中各节点的值均保证唯一。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 113 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;


public class Q285_InorderSuccessorInBst{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 中序遍历  第一个 比他大的就是答案
    public TreeNode ans = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root,p);
        return ans;
    }

    public void inorder(TreeNode root,TreeNode p){
        if(root == null || ans != null) return;
         inorder(root.left,p);
        if(ans == null && root.val>p.val) ans = root;
         inorder(root.right,p);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        TreeNode treeNode1= new TreeNode(1);
        treeNode2.left = treeNode1;

        new Solution().inorderSuccessor(treeNode5, new TreeNode(1));
    }
  
}
