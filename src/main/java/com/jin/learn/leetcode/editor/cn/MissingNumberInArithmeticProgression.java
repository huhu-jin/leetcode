//  [1228]等差数列中缺失的数字

//有一个数组，其中的值符合等差数列的数值规律，也就是说： 
//
// 
// 在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相等。 
// 
//
// 我们会从该数组中删除一个 既不是第一个 也 不是最后一个的值，得到一个新的数组 arr。 
//
// 给你这个缺值的数组 arr，请你帮忙找出被删除的那个数。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [5,7,11,13]
//输出：9
//解释：原来的数组是 [5,7,9,11,13]。
// 
//
// 示例 2： 
//
// 输入：arr = [15,13,12]
//输出：14
//解释：原来的数组是 [15,14,13,12]。 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 1000 
// 0 <= arr[i] <= 10^5 
// 
// Related Topics 数组 数学 
// 👍 15 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class MissingNumberInArithmeticProgression{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 不用看
    public int missingNumber(int[] arr) {
        Integer preD = null;
        for (int i = 0; i + 1 < arr.length; i++) {

            int d = arr[i] - arr[i+1];
            if(preD == null){
                preD = d;
            }else {
                if (preD != d) {
                    if (Math.abs(preD) > Math.abs(d)) {
                        return arr[i] +d;
                    }else {
                        return arr[i] - preD;
                    }
                }

            }
        }

        return arr[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}