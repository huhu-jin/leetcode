//  [255]验证前序遍历序列二叉搜索树

//给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。 
//
// 你可以假定该序列中的数都是不相同的。 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [5,2,6,1,3]
//输出: false 
//
// 示例 2： 
//
// 输入: [5,2,1,3,6]
//输出: true 
//
// 进阶挑战： 
//
// 您能否使用恒定的空间复杂度来完成此题？ 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 108 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Stack;


public class VerifyPreorderSequenceInBinarySearchTree{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 尽最大可能认为
    // [1,2]  [2,1] 都是  true
    // [1,2,3] 都是右子树情况 true
    // [3,2,1] 都是左子树 true

    //算法理解
        // [50,20,10,17,15]
        //     50
        //    /
        //   20
        //  /
        //10   //pop 10
        //  \
        //   17
        //   /
        //  15

        // [50,20,10,22,21]
        //     50
        //    /  \
        //   20    22 // pop 20
        //  /     /
        //10    21
    // 前序遍历 左子树递减 有子树递增
    // 那么 递减到递增 就是左右子树切换 过程
    // 利用单调栈 保存左子树 递减过程 pop出的 min就是同级node (root或left)
    // 所以  新加入node(递增开始 属于右子树) 必须大于min
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < min) return false;
            while (!stack.isEmpty() && preorder[i]>stack.peek()){
                min = stack.pop(); //
            }
            stack.push(preorder[i]);
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().verifyPreorder(new int[]{5, 2, 1, 3, 6});
    }
  
}