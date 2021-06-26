//  [剑指 Offer 34]二叉树中和为某一值的路径

//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//
// 
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 197 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

//  注意他要全路径
// 有负数
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
  
  
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
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        if(root == null) return new LinkedList<>();
        if(root.val == target && root.left == null && root.right == null){
            List<List<Integer> > list = new LinkedList<>();
            List<Integer> treeNodes = new LinkedList<>();
            treeNodes.add(root.val);
            list.add(treeNodes);
            return list;
        }
        target = target - root.val;
        return addPath(root.val,pathSum(root.left,target),pathSum( root.right,target));

    }

    private List<List<Integer>> addPath(int val, List<List<Integer>> leftPath, List<List<Integer>> rightPath) {
        List<List<Integer>> rets = new LinkedList<>();

        if (!leftPath.isEmpty()) {
            for (List eachPath : leftPath) {
                ((LinkedList) eachPath).addFirst(val);
            }
            rets.addAll(leftPath);
        }

        if (!rightPath.isEmpty()) {
            for (List eachPath : rightPath) {
                ((LinkedList) eachPath).addFirst(val);
            }
            rets.addAll(rightPath);
        }

        return rets;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        TreeNode treeNode1 = new TreeNode(-2);
        TreeNode treeNode2 = new TreeNode(-3);
        treeNode1.right = treeNode2;

        new Solution().pathSum(treeNode1, -5);
    }
  
}