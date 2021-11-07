//  [663]均匀树划分

//给定一棵有 n 个结点的二叉树，你的任务是检查是否可以通过去掉树上的一条边将树分成两棵，且这两棵树结点之和相等。 
//
// 样例 1: 
//
// 输入:     
//    5
//   / \
//  10 10
//    /  \
//   2   3
//
//输出: True
//解释: 
//    5
//   / 
//  10
//      
//和: 15
//
//   10
//  /  \
// 2    3
//
//和: 15
// 
//
// 
//
// 样例 2: 
//
// 输入:     
//    1
//   / \
//  2  10
//    /  \
//   2   20
//
//输出: False
//解释: 无法通过移除一条树边将这棵树划分成结点之和相等的两棵子树。
// 
//
// 
//
// 注释 : 
//
// 
// 树上结点的权值范围 [-100000, 100000]。 
// 1 <= n <= 10000 
// 
//
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 37 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;


public class EqualTreePartition{
  
  
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
    // 先计算和
    // 然后 找一半的子树
    private boolean ans=false;
    private TreeNode root;
    public boolean checkEqualTree(TreeNode root) {
        this.root = root;
        int target =  dfs(root);
        if (target % 2 == 0) {
            dfs(root, target/2);
            return ans;
        }
        return false;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return dfs(root.right) + root.val +  dfs(root.left);
    }


    private int dfs(TreeNode root, int target) {
        if (root == null) return 0;
        int left = dfs(root.left, target);
        int right = dfs(root.right,target);
        if (left + root.val + right== target && root !=this.root) {
            ans = true;
        }

        return left + right + root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}