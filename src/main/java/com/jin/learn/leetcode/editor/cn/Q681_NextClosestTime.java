//  [681]最近时刻

//给定一个形如 “HH:MM” 表示的时刻，利用当前出现过的数字构造下一个距离当前时间最近的时刻。每个出现数字都可以被无限次使用。 
//
// 你可以认为给定的字符串一定是合法的。例如，“01:34” 和 “12:09” 是合法的，“1:34” 和 “12:9” 是不合法的。 
//
// 
//
// 样例 1: 
//
// 输入: "19:34"
//输出: "19:39"
//解释: 利用数字 1, 9, 3, 4 构造出来的最近时刻是 19:39，是 5 分钟之后。结果不是 19:33 因为这个时刻是 23 小时 59 分钟之后
//。
// 
//
// 
//
// 样例 2: 
//
// 输入: "23:59"
//输出: "22:22"
//解释: 利用数字 2, 3, 5, 9 构造出来的最近时刻是 22:22。 答案一定是第二天的某一时刻，所以选择可构造的最小时刻。
// 
//
// 
// Related Topics 字符串 枚举 
// 👍 48 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q681_NextClosestTime{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //模拟 注意细节就好
        public String nextClosestTime(String time) {
            int[] nums = new int[4]; // 使用一个长度为4的数组来记录时间，比如[1,2,3,4]代表12:34。
            char[] chars = time.toCharArray();
            int index = 0;
            // 将字符串解析成数字，并将时间放到nums数组当中
            for (int i = 0; i < chars.length; i++) {
                if (i == 2) continue;
                nums[index] = chars[i] - '0';
                index++;
            }
            // 找出nums数组当中的最小值，留作后面使用
            int minNum = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                minNum = Math.min(minNum, nums[i]);
            }
            boolean found = false; // 使用一个变量来记录是否找到了最近时刻
            for (int i = nums.length - 1; i >= 0; i--) { // 从后向前遍历数据，因为改动后面的时间一定比改动前面的时间变动更小
                int largerNum = Integer.MAX_VALUE;
                for (int j = 0; j < nums.length; j++) { // 使用一个循环来找到nums中比当前数字大的所有数里最小的一个，使用它来替代当前数字时间变动一定最小
                    if (nums[j] > nums[i]) {
                        largerNum = Math.min(largerNum, nums[j]);
                    }
                }
                if (largerNum != Integer.MAX_VALUE) {
                    int temp = nums[i];
                    nums[i] = largerNum;
                    if (isValid(nums)) { // 判断变动之后数据是否合法，如果不合适则恢复原数据，然后继续遍历前一位
                        // 如果当前数据变动合法，那么应该从当前数据的位置继续向后遍历，将每一位赋值成nums数组当中的最小值
                        // 对应情况12:33，如果只是将时间变成13:33并不是最近时刻，因为13:11才是最近时刻
                        for (int j = i + 1; j < nums.length; j++) {
                            nums[j] = minNum;
                        }
                        found = true;
                        break;
                    }
                    else nums[i] = temp;
                }
            }
            if (!found) { // 如果没有找到最近时间，那么最近时间就是第2天的最小时间，将所有值都赋值成最小值即可
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = minNum;
                }
            }
            StringBuilder builder = new StringBuilder();
            // 拼装最后的结果
            for (int i = 0; i < nums.length; i++) {
                builder.append(nums[i]);
                if (i == 1) builder.append(":");
            }
            return builder.toString();
        }

        /**
         定义一个方法用于判断时间是否有效。
         当nums[0]大于2，或者nums[0]等于2时nums[1]大于3，或者 nums[2]大于5，这三种情况下时间无效。
         其他情况下时间都是有效值。
         **/
        boolean isValid(int[] nums) {
            if (nums[0] > 2 || (nums[0] == 2 && nums[1] > 3) || nums[2] > 5) return false;
            return true;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
