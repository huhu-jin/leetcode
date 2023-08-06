//  [270]最接近的二叉搜索树值

//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二分查找 二叉树 
// 👍 86 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;


public class Q270_ClosestBinarySearchTreeValue{
  
  
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

    // 中序遍历 是有序递增的
    public int closestValue(TreeNode root, double target) {
       if(root == null) return Integer.MAX_VALUE;
       int left =  closestValue(root.left, target);
        // 左树 差值小 右树就不用考虑了
        if (Math.abs(left - target) < Math.abs(root.val - target)) {
            return left;
        }
        int right =  closestValue(root.right, target);
        if ( Math.abs(root.val - target) < Math.abs(right - target)) {
            return root.val;
        }else {
            return right;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
