//  [剑指 Offer 32 - III]从上到下打印二叉树 III

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 
// 👍 107 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class CongShangDaoXiaDaYinErChaShuIiiLcof{
  
  
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
        boolean isFromLeft = true;

        while (!queue.isEmpty()) {

            LinkedList<Integer> currentLevel = new LinkedList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode temp = queue.pollFirst();
                if(isFromLeft){
                    currentLevel.add(temp.val);
                }else {
                    currentLevel.addFirst(temp.val);
                }

                if (temp.left != null) nextLevel.add(temp.left);
                if (temp.right != null) nextLevel.add(temp.right);
            }

            ret.add(currentLevel);
            queue = nextLevel;
            isFromLeft = !isFromLeft;

        }
        return ret;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;

        new Solution().levelOrder(treeNode1);
    }
  
}