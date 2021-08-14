//  [246]中心对称数

//中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。 
//
// 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。 
//
// 
//
// 示例 1: 
//
// 输入: num = "69"
//输出: true
// 
//
// 示例 2: 
//
// 输入: num = "88"
//输出: true 
//
// 示例 3: 
//
// 输入: num = "962"
//输出: false 
//
// 示例 4： 
//
// 输入：num = "1"
//输出：true
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 30 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class StrobogrammaticNumber{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num ==null ) return false;
        int left = 0;
        int right = num.length()-1;
        while (left <= right) {
            if (num.charAt(left) == num.charAt(right)) {
                if(num.charAt(left) != '8' &&  num.charAt(left) != '1' &&  num.charAt(left) != '0' ) return  false;
            }else {
                if ((num.charAt(left) == '6' && num.charAt(right) == '9') ||
                        (num.charAt(left) == '9' && num.charAt(right) == '6')) {

                }else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return  true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}