//  [剑指 Offer 32 - II]从上到下打印二叉树 II

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 116 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class CongShangDaoXiaDaYinErChaShuIiLcof{
  
  
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();


        List<List<Integer>> ret = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> currentLevel = new LinkedList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.pollFirst();
                currentLevel.add(temp.val);
                if (temp.left != null) nextLevel.add(temp.left);
                if (temp.right != null) nextLevel.add(temp.right);
            }
            ret.add(currentLevel);
            queue = nextLevel;

        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution();
    }
  
}