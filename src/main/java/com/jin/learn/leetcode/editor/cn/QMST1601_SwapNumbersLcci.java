//  [面试题 16.01]交换数字

//编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。 
//
// 示例： 
//
// 
//输入: numbers = [1,2]
//输出: [2,1]
// 
//
// 提示： 
//
// 
// numbers.length == 2 
// -2147483647 <= numbers[i] <= 2147483647 
// 
// Related Topics 位运算 数学 
// 👍 47 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class QMST1601_SwapNumbersLcci{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] swapNumbers(int[] numbers) {
        numbers[0]  = numbers[0] ^ numbers[1];
        numbers[1]  = numbers[0] ^ numbers[1];
        numbers[0]  = numbers[0] ^ numbers[1];
        return numbers;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
