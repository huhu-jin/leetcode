//  [105]从前序与中序遍历序列构造二叉树

//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1120 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;


public class Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
  
  
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
// https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/qian-xu-bian-li-python-dai-ma-java-dai-ma-by-liwei/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    /**
     * @param preorder 二叉树前序遍历结果
     * @param inorder  二叉树中序遍历结果
     * @param preLeft  二叉树前序遍历结果的左边界
     * @param preRight 二叉树前序遍历结果的右边界
     * @param inLeft   二叉树后序遍历结果的左边界
     * @param inRight  二叉树后序遍历结果的右边界
      我来总结个口诀：前序找根，中序来分。意思是每次都可以通过前序找到根节点，再用中序遍历确定新的左右子树的范围，最后递归这个过程就可以了。
     */
    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int rootValue = preorder[preLeft];
        int InOrderLeftLength = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if(inorder[i] == rootValue){
                InOrderLeftLength = i - inLeft;   // 找到中序的 中点
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preorder, inorder,  preLeft+1,  preLeft+InOrderLeftLength,  inLeft,  inLeft+InOrderLeftLength-1);
        root.right = buildTree(preorder,inorder,  preLeft+InOrderLeftLength+1,  preRight,  inLeft+InOrderLeftLength+1,  inRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase() {
        new Solution().buildTree(new int[]{1, 2, 4, 5, 8, 9, 3, 6, 10, 7}, new int[]{4, 2, 8, 5, 9, 1, 6, 10, 3, 7});
    }
  
}
