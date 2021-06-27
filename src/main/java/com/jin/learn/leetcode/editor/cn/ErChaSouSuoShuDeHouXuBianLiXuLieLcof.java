//  [剑指 Offer 33]二叉搜索树的后序遍历序列

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
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
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 289 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{



// 后序遍历: left right root -> [小 大 中]
// 递归检查是否是符合这样的规律 [[小 大 中] [小 大 中] 中]


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        private boolean recur(int[] postorder, int start, int end) {
            if (start >= end) return true;
            int cutPosition;
            //找到 cut position
            for (cutPosition = start; postorder[cutPosition] < postorder[end]; cutPosition++) {
            }
            // 检查剩下是否大于root
            int i;
            for (i = cutPosition; postorder[i] > postorder[end]; i++) {

            }
            return i == end && recur(postorder, start, cutPosition - 1) && recur(postorder, cutPosition, end - 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
    }
        

}