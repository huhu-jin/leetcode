//  [222]完全二叉树的节点个数

//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 树 深度优先搜索 二分查找 二叉树 👍 1004 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;



// https://leetcode.cn/problems/count-complete-tree-nodes/solutions/21544/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
public class Q222_CountCompleteTreeNodes{
  
  
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
    // 需要利用 满二叉树的特点
    // 左子树 高 left， 右子树高 right
    // 当 left = right 时候， 左子树是满二叉树 2的n次-1
    // 当 left ！= right 时候， 右子树是满二叉树（但是矮一层） 2 （n-1） -1
    public int countNodes(TreeNode root) {

        if (root == null) return 0;

        int leftLevel = getLevel(root.left);
        int rightLevel = getLevel(root.right);

        if (leftLevel == rightLevel) {
            // root + 左子树 + 右子树, +1 -1 抵消了
            return  (1 << leftLevel) + countNodes(root.right);
        }else {
            return  countNodes(root.left) +  (1 << rightLevel) ;
        }

    }

    private int getLevel(TreeNode root) {
        int c = 0;
        while (root != null) {
            root = root.left;
            c++;
        }
        return c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}