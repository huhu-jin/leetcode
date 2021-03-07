//  [503]下一个更大元素 II

//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 385 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

public class NextGreaterElementIi{


  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        if (nums == null) {
            return null;
        }

        int[] ret = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            boolean isFind = false;
            int setValue =-1;

            for (int p = i; p < nums.length; p++) {
                if (nums[p] > nums[i]) {
                    setValue = nums[p];
                    isFind = true;
                    break;
                }
            }

            if (!isFind ) {
                for (int p = 0; p < i; p++) {
                    if (nums[p] > nums[i]) {
                        setValue = nums[p];
                        break;
                    }
                }
            }
            ret[i] = setValue;
        }
        return ret;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    @Test
    public void testCase() {
        new Solution().nextGreaterElements(new int[]{1,8,-1,-100,-1,222,1111111,-111111});
    }

}