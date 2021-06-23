//  [剑指 Offer 32 - I]从上到下打印二叉树

//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// 👍 100 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.TreeNode;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.awt.*;
import java.util.LinkedList;


public class CongShangDaoXiaDaYinErChaShuLcof{
  
  
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
    // 广度遍历
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.pollFirst();
            list.add(treeNode.val);
            if(treeNode.left !=null) queue.add(treeNode.left);
            if(treeNode.right !=null) queue.add(treeNode.right);

        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
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