//  [156]上下翻转二叉树

//给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左
//叶节点。返回新的根。 
//
// 例子: 
//
// 输入: [1,2,3,4,5]
//
//    1
//   / \
//  2   3
// / \
//4   5
//
//输出: 返回二叉树的根 [4,5,2,#,#,3,1]
//
//   4
//  / \
// 5   2
//    / \
//   3   1  
// 
//
// 说明: 
//
// 对 [4,5,2,#,#,3,1] 感到困惑? 下面详细介绍请查看 二叉树是如何被序列化的。 
//
// 二叉树的序列化遵循层次遍历规则，当没有节点存在时，'#' 表示路径终止符。 
//
// 这里有一个例子: 
//
//    1
//  / \
// 2   3
//    /
//   4
//    \
//     5
// 
//
// 上面的二叉树则被序列化为 [1,2,3,#,#,4,#,#,5]. 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 77 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;


public class BinaryTreeUpsideDown{
  
  
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
    // 翻转: 父亲节点变子节点, 右节变左节点
    // 右边没有 深度
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode L = root.left, R = root.right;
        TreeNode res = upsideDownBinaryTree(root.left); // 递归return 最深的 left
        root.left = null;
        root.right = null;
        L.right = root;
        L.left = R;
        return res;
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
        treeNode2.right = treeNode5;

        new Solution().upsideDownBinaryTree(treeNode1);

    }
  
}