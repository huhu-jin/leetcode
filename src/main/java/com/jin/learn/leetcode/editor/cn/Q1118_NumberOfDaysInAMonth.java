//  [1118]一月有多少天

//指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。 
//
// 
//
// 示例 1： 
//
// 输入：Y = 1992, M = 7
//输出：31
// 
//
// 示例 2： 
//
// 输入：Y = 2000, M = 2
//输出：29
// 
//
// 示例 3： 
//
// 输入：Y = 1900, M = 2
//输出：28
// 
//
// 
//
// 提示： 
//
// 
// 1583 <= Y <= 2100 
// 1 <= M <= 12 
// 
// Related Topics 数学 
// 👍 7 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1118_NumberOfDaysInAMonth{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 不用看
    //四年一闰，百年不闰，四百年再闰
    public int numberOfDays(int year, int month) {
        if (month == 2) {
            if (year%400 == 0)return 29;
            if (year %100 == 0) return 28;
            if(year %4 == 0) return 29;
            return 28;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        return 30;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
