//  [163]缺失的区间

//给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。 
//
// 示例： 
//
// 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
//输出: ["2", "4->49", "51->74", "76->99"]
// 
// Related Topics 数组 
// 👍 53 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class Q163_MissingRanges{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findQ163_MissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                ans.add(lower + "");
            } else {
                ans.add(lower + "->" + upper);
            }
        }


        Integer tempStart= lower;
        Integer tempEnd;
        int i=0;
        for (; i < nums.length; i++, lower++) {
            if (nums[i] != lower) {
                tempEnd = nums[i]-1;
                if (i - 1 >= 0) {
                    tempStart = nums[i - 1] + 1;
                }
                if (tempEnd == tempStart) {
                    ans.add(tempStart + "");
                }else {
                    ans.add(tempStart + "->" + tempEnd);
                }
                lower = nums[i];
            }
        }
        if (i - 1 >= 0) {
            if (nums[i-1] +1 == upper) {
                ans.add(nums[i-1] +1 + "");
            }else if(nums[i-1] +1 < upper){
                ans.add(nums[i-1]+1 + "->" + upper);

            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findQ163_MissingRanges(new int[]{1000}, 0, 1000);
        new Solution().findQ163_MissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
    }
  
}
