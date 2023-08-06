//  [剑指 Offer 56 - II]数组中数字出现的次数 II

//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 199 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class QJZOffer56_II_ShuZuZhongShuZiChuXianDeCiShuIiLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap();

            for(int i = nums.length - 1; i >= 0; --i){
                int key = nums[i];
                if(!map.containsKey(key)){
                    // 如果之前没有遇到这一数字，则放入 map 中
                    map.put(key, 1);
                }else{
                    // 如果之前遇到过这一数字，则出现次数加 1
                    map.put(key, map.get(key) + 1);
                }
            }

            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                if(entry.getValue() == 1){
                    return entry.getKey();
                }
            }

            return -1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
