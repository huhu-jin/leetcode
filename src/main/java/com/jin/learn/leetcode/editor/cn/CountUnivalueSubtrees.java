//  [250]统计同值子树

//给定一个二叉树，统计该二叉树数值相同的子树个数。 
//
// 同值子树是指该子树的所有节点都拥有相同的数值。 
//
// 示例： 
//
// 输入: root = [5,1,5,5,5,null,5]
//
//              5
//             / \
//            1   5
//           / \   \
//          5   5   5
//
//输出: 4
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 80 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;


public class CountUnivalueSubtrees{
  
  
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
    // 难点在理解题意: 什么是同值子树,
    // 所有子树的值 和 root的值是都一样 树
    // 或者 子树为null 的树 即叶子节点
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return count;
    }
    // null 表示子树值 已经不一样了
    // return 子树的值
    private Integer dfs(TreeNode root) {
        if(root == null) return 0;
        if (root.right == null && root.left == null) {
            count++;
            return root.val;
        } else if (root.right == null) {
            Integer v = dfs(root.left);
            if(v !=null && v == root.val){
                count++;
                return root.val;
            }
            return null;
        }else if (root.left == null) {
            Integer v = dfs(root.right);
            if(v !=null && v == root.val){
                count++;
                return root.val;
            }
            return null;
        }else {
            Integer v1 = dfs(root.left);
            Integer v2 = dfs(root.right);
            if( v1 !=null && v1 == root.val && v2 !=null && v2 == root.val){
                count++;
                return root.val;
            }
            return null;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}