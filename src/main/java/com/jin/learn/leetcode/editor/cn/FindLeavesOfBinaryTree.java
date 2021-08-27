//  [366]寻找二叉树的叶子节点

//给你一棵二叉树，请按以下要求的顺序收集它的全部节点： 
//
// 
// 依次从左到右，每次收集并删除所有的叶子节点 
// 重复如上过程直到整棵树为空 
// 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//  
//          1
//         / \
//        2   3
//       / \     
//      4   5    
//
//输出: [[4,5,3],[2],[1]]
// 
//
// 
//
// 解释: 
//
// 1. 删除叶子节点 [4,5,3] ，得到如下树结构： 
//
//           1
//         / 
//        2          
// 
//
// 
//
// 2. 现在删去叶子节点 [2] ，得到如下树结构： 
//
//           1          
// 
//
// 
//
// 3. 现在删去叶子节点 [1] ，得到空树： 
//
//           []         
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 124 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class FindLeavesOfBinaryTree{
  
  
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
    // 难点在于确定 当前node离边缘叶子 多远
    // 父亲节点 =  最大子节点+1   叶子节点位置0
    private Map<Integer,List<Integer>> map = new TreeMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root); return new LinkedList<>(map.values());
    }

    private int dfs(TreeNode root) {
        if (root == null)  return 0;
        int leftDistance = dfs(root.left);
        int rightDistance = dfs(root.right);
        int currentDistance = Math.max(leftDistance, rightDistance) + 1 ;
        map.computeIfAbsent(currentDistance, i->new LinkedList<>()).add(root.val);
        return currentDistance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
    }
  
}