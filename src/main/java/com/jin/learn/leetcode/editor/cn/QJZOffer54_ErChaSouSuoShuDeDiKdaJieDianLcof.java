//  [剑指 Offer 54]二叉搜索树的第k大节点

//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 173 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;


public class QJZOffer54_ErChaSouSuoShuDeDiKdaJieDianLcof{
  
  
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
    // 中序 遍历的 倒序 是递减 .找到第k个 就好了

    private int res;
    private int k;
    public int kthLargest(TreeNode root, int k) {
        if(root == null) return 0;
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode curr) {
        if(curr == null) return ;
        dfs(curr.right);
        if(--k == 0){
            res = curr.val;
            return;
        }
        dfs(curr.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
