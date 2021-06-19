//  [剑指 Offer 28]对称的二叉树

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 
// 👍 188 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;


public class DuiChengDeErChaShuLcof{
  
  
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

      //  L.val=R.val ：即此两对称节点值相等。
     //   L.left.val = R.right.valL.left.val=R.right.val ：即 LL 的 左子节点 和 RR 的 右子节点 对称；
     //   L.right.val = R.left.valL.right.val=R.left.val ：即 LL 的 右子节点 和 RR 的 左子节点 对称。
     // 递归的规律
        public boolean isSymmetric(TreeNode root) {
            return false;
        }




}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

        TreeNode root = new TreeNode(1);
        TreeNode treeNode10 = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode20 = new TreeNode(3);
        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(4);
        TreeNode treeNode23 = new TreeNode(3);

        root.left = treeNode10;
        root.right = treeNode11;
        treeNode10.left = treeNode20;
        treeNode10.right = treeNode21;
        treeNode11.left = treeNode22;
        treeNode11.right = treeNode23;

        Assert.assertTrue(new Solution().isSymmetric(root));


    }
  
}